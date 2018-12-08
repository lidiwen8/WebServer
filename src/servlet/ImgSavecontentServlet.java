package servlet;

import dao.GeneralDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.IPUtil;
import util.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ImgSavecontentServlet extends HttpServlet {
    private String name=null;//标题
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");//解决编码问题
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");//获取发布者
        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            request.setAttribute("error", "请选择一张图片上传！");
            request.getRequestDispatcher("user/upload.jsp").forward(request, response);
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 中文处理
        upload.setHeaderEncoding("utf-8");
        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (item.isFormField()) {
                        name = item.getString();
                        name = new String(name.getBytes("ISO-8859-1"), "utf-8");
                        if (name.equals("") || name.equals(null)) {
                            request.setAttribute("error", "请填写图片标题！");
                            request.getRequestDispatcher("user/upload.jsp").forward(request, response);
                            return;
                        } else if (name.length() > 20 || name.length() < 2) {
                            request.setAttribute("error", "图片的标题长度必须要在2到20之间！");
                            request.getRequestDispatcher("user/upload.jsp").forward(request, response);
                            return;
                        }
                    }
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        if (fileName.equals(null) || fileName.equals("")) {
                            request.setAttribute("error", "请选择一张图片上传！");
                            request.getRequestDispatcher("user/upload.jsp").forward(request, response);
                            return;
                        }
                        String filetype = fileName.substring(fileName.indexOf("."), fileName.length());
                        if (!(filetype.equals(".jpg") || filetype.equals(".png") || filetype.equals(".gif"))) {
                            System.out.println("你上传的图片格式不正确");
                            request.setAttribute("error", "你上传的图片格式不正确,请重新上传");
                            request.getRequestDispatcher("user/upload.jsp").forward(request, response);
                            return;
                        }
                        upload.setFileSizeMax(1024 * 1024);// 设置图片上传的最大不能超过1M
                        factory.setSizeThreshold(1024 * 512);//超过512k设置临时文件缓存
                        float size = item.getSize() / 1024;
                        if (size > 1024) {
                            request.setAttribute("error", "上传的图片大小最大不能超过1M！");
                            request.getRequestDispatcher("user/upload.jsp").forward(request, response);
                            return;
                        }
                        // 获取文件名后缀, 返回 "."在文件名最后出现的索引, 就是文件后缀名
                        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
                        // 存储的文件名根据获取的id来唯一确定, 这里测试使用 "test"
                        // id可以绑定到session或request变量等等，自己根据需要来扩展
                        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
                        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
                        String id = date;
                        String fileSaveName = id + "." + prefix; // id.后缀
                        // 获取文件输入流
                        InputStream inputStream = item.getInputStream();
                        InputStream in = (InputStream) ImageUtil.getImageByte(item.getInputStream().toString());
                        in.available();
                        inputStream.close();
                        item.delete();
                        Date day = new Date();
                        SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//发布时间
                        String ip = IPUtil.getIP(request);//发布者的IP地址
                        // 存入数据库
                        String sql = "insert into img_src2(name,img,date,username,ip,size) values(?,?,?,?,?,?)";//存储图片内容
                        // 设置图片存储的虚拟路径
                        String virtualPath = "image/" + fileSaveName;
                        Object values[] = new Object[]{name, in, da.format(day), username, ip, in.available()};
                        int ok = GeneralDao.update(sql, values);
                        if (ok == 1) {
                            System.out.println("存入数据库成功，虚拟路径为：" + virtualPath);
                        } else {
                            System.out.println("存入数据库失败 ！");
                        } // if (ok == 1)
                    }
                    // if (!item.isFormField())
                } // for
            } // try
        } catch (FileUploadException e) {
            request.setAttribute("error", "上传的图片大小最大不能超过1M！");
            request.getRequestDispatcher("user/upload.jsp").forward(request, response);
            return;
        }
       catch (Exception e) {
            request.setAttribute("error", "图片上传错误，请检查网络是否连接正常！");
            request.getRequestDispatcher("user/upload.jsp").forward(request,response);
            return;
        }
        if(username.equals("admin")){
            response.sendRedirect("user/show_img_src.jsp");
        }else{
            response.sendRedirect("ImgServlet?method=findUserImg");
        }
        // 重定向到显示图片页面
    }

}
