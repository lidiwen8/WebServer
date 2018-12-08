package servlet;

import dao.GeneralDao;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.IPUtil;
import util.UuidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<Object, Object> map = new HashMap<Object, Object>();
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("user");//获取发布者
        DiskFileItemFactory factory = new DiskFileItemFactory();
        String path = this.getServletContext().getRealPath("/") + "image";
        // 根据路径名创建一个 File实例
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();		// 如果不存在则创建此路径的目录
        }
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024*1024) ;
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //可以上传多个文件
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
            for(FileItem item : list){
                if(!item.isFormField()){
                    String name = item.getName() ;
                    upload.setFileSizeMax(1024 * 1024);// 设置图片上传的最大不能超过1M
                    factory.setSizeThreshold(1024 * 512);//超过512k设置临时文件缓存
                    float size=item.getSize()/1024;
                    if(size>1024){
                        request.setAttribute("error", "上传的每张图片大小最大不能超过1M！");
                        request.getRequestDispatcher("user/upload2.jsp").forward(request,response);
                        return;
                    }
                    String prefix = name.substring(name.lastIndexOf(".") + 1);
                    String fileSuffix  = name.substring(name.lastIndexOf(".")+1,name.length());
                    String oldName = name.replaceAll("." + fileSuffix,"");
//                    String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
                    String fileName= UuidUtil.Uuid();
                    String newName = fileName + "." + fileSuffix;
                    OutputStream out = new FileOutputStream(new File(path,newName));
                    InputStream in = item.getInputStream() ;
                    int length = 0 ;
                    byte [] buf = new byte[1024] ;
                    while( (length = in.read(buf) ) != -1){
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                    Date day=new Date();
                    SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//发布时间
                    String ip= IPUtil.getIP(request);//发布者的IP地址
                    // 存入数据库
                    String sql = "insert into img_src(name,src,date,username,ip,size) values(?,?,?,?,?,?)";//存储图片路径
                    // 设置图片存储的虚拟路径
                    String virtualPath = "image/" + fileName+ "." + prefix;
                    String picname="批量上传";
                    Object values[] = new Object[] {picname,virtualPath,da.format(day),username,ip,size};
                    int ok = GeneralDao.update(sql, values);
                    if (ok == 1) {
                        System.out.println("存入数据库成功，虚拟路径为：" + virtualPath);
                    } else {
                        System.out.println("存入数据库失败 ！");
                    } // if (ok == 1)
                    /**将上传处理后的数据返回**/
                    map.put("fileSuffix",fileSuffix);
                    map.put("fileName",oldName);
                    map.put("filePath",fileName);
                   // break;
                }
            }
        }catch (Exception e) {
            System.out.println("出错了：" + e.getMessage());
        }
        response.setContentType("text/xml; charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = JSONObject.fromObject(map);
        String msg =  jsonObject.toString();
        out.print(msg);
        out.close();
        if(username.equals("admin")){
            response.sendRedirect("user/show_img_src.jsp");
        }else{
            response.sendRedirect("ImgServlet?method=findUserImg");
        }
	}
}

