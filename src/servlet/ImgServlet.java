package servlet;

import cn.itcast.servlet.BaseServlet;
import entity.ImageBean;
import service.ImgService;
import service.Impl.ImgServiceImpl;
import util.DownloadPicFromURL;
import util.PageBean;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.MalformedURLException;


public class ImgServlet extends BaseServlet {
    private ImgService imgService = new ImgServiceImpl();

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         *1.获取页面传递的pc
         * 2.给定pr的值
         * 3.使用pc和pr调用service方法，得到pageBean，保存到request域
         * 4.转发到list.jsp
         */
        /*
         * 1.得到pc
         *   如果pc参数不存在，说明pc＝1
         *   如果pc参数存在，需要转换成int类型
         */
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");//获取登录用户
        if (username.equals("admin")) {
            int pc = getPc(request);
            int pr = 5;//给定pr的值，每页5行纪录
            PageBean<ImageBean> pb = imgService.findAll(pc, pr);
            pb.setUrl(getUrl(request));
            request.setCharacterEncoding("utf-8");
            request.setAttribute("pb", pb);
            return "f:user/list.jsp";
        } else {
            request.setAttribute("error", "你不是管理员，没有权限！");
            ((HttpServletRequest) request).getRequestDispatcher("/login.jsp").forward(request, response);
            return "login.jsp";
        }
    }

    public String findUserImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pc = getPc(request);
        int pr = 5;//给定pr的值，每页5行纪录
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");//获取登录用户
        if (username.equals(null)) {
            request.setAttribute("error", "你还没登陆！");
            ((HttpServletRequest) request).getRequestDispatcher("/login.jsp").forward(request, response);
            return "login.jsp";
        }
        PageBean<ImageBean> pb = imgService.findUserImg(pc, pr, username);
        pb.setUrl(getUrl(request));
        request.setCharacterEncoding("utf-8");
        request.setAttribute("pb", pb);
        System.out.println(pb);
        return "f:user/list.jsp";
    }

    public String detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");//获取登录用户
        int id = Integer.parseInt(request.getParameter("id"));
        ImageBean imageBean = imgService.findByid(id);
        request.setAttribute("imageBean", imageBean);
            return "user/detail.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = ((HttpServletRequest) request).getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {
            request.setAttribute("error", "你还没有登录！");
            ((HttpServletRequest) request).getRequestDispatcher("/login.jsp").forward(request, response);
        }
        imgService.deleteByid(id);
        request.setAttribute("info", "图片已经成功删除！");
        if (user.equals("admin")) {
            return "user/show_img_src.jsp";
        } else {
            return findUserImg(request, response);
        }
    }

    private int getPc(HttpServletRequest request) {
        String value = request.getParameter("pc");

        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }

    private ImageBean encoding(ImageBean imageBean) throws UnsupportedEncodingException {
        String name = imageBean.getName();
        String src = imageBean.getSrc();
        String date = imageBean.getDate();
        int id = imageBean.getId();
        String username = imageBean.getUsername();
        if (name != null && !name.trim().isEmpty()) {
            name = new String(name.getBytes("ISO-8859-1"), "utf-8");
            imageBean.setName(name);
        }
        if (src != null && !src.trim().isEmpty()) {
            src = new String(src.getBytes("ISO-8859-1"), "utf-8");
            imageBean.setSrc(src);
        }
        if (username != null && !username.trim().isEmpty()) {
            username = new String(username.getBytes("ISO-8859-1"), "utf-8");
            imageBean.setUsername(username);
        }
        return imageBean;
    }

    private String getUrl(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String queryString = request.getQueryString();

        if (queryString.contains("&pc=")) {
            int index = queryString.lastIndexOf("&pc=");
            queryString = queryString.substring(0, index);
        }

        return contextPath + servletPath + "?" + queryString;
    }

    public String downloadPicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,MalformedURLException{
        request.setCharacterEncoding("utf-8");
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String url = basePath+request.getParameter("url");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = ((HttpServletRequest) request).getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {
            request.setAttribute("error", "你还没有登录！");
            ((HttpServletRequest) request).getRequestDispatcher("/login.jsp").forward(request, response);
        }
//        String savepath = this.getServletContext().getRealPath("/") + "image";
        String savepath = "D:\\"+"image\\test.jpg";
        // 根据路径名创建一个 File实例
        File file = new File(savepath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();//创建父级文件路径
            file.createNewFile();//创建文件
//            file.mkdir();		// 如果不存在则创建此路径的目录
        }
        DownloadPicFromURL downloadPicFromURL = new DownloadPicFromURL();
        try {
            downloadPicFromURL.downloadPicture(url, savepath);
        }catch (Exception e){
            request.setAttribute("info", "图片下载异常！");
        }
        request.setAttribute("info", "图片已经下载成功！默认下载位置为：D:\\image");
        ImageBean imageBean = imgService.findByid(id);
        request.setAttribute("imageBean", imageBean);
        if (user.equals("admin")) {
            return "user/detail1.jsp";
        } else {
            return "user/detail.jsp";
        }

    }
    public String download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //设置ContentType字段值
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String url = basePath+request.getParameter("url");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = ((HttpServletRequest) request).getSession();
        String user = (String) session.getAttribute("user");
        //获取所要下载的文件名称
        String filename = request.getParameter("url").substring(6,request.getParameter("url").length());
        System.out.println(filename);
        //下载文件所在目录
        String folder = url;
        //通知浏览器以下载的方式打开
        response.addHeader("Content-type", "appllication/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename="+filename);
        //通知文件流读取文件
        InputStream in = this.getServletContext().getResourceAsStream(folder);
        //获取response对象的输出流
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        //循环取出流中的数据
        while((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }
        request.setAttribute("info", "图片已经下载成功！");
        ImageBean imageBean = imgService.findByid(id);
        request.setAttribute("imageBean", imageBean);
        if (user.equals("admin")) {
            return "user/detail1.jsp";
        } else {
            return "user/detail.jsp";
        }
    }
    public void download1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //设置ContentType字段值
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String url = basePath+request.getParameter("url");
        int id = Integer.parseInt(request.getParameter("id"));
        String filename = request.getParameter("url").substring(6,request.getParameter("url").length());
        HttpSession session = ((HttpServletRequest) request).getSession();
        String user = (String) session.getAttribute("user");
//获取文件
        File file = new File(this.getServletContext().getRealPath("/") + "image/"+filename);
//将图片读成二进制流
        FileImageInputStream fs = new FileImageInputStream (file);
        int streamLength = (int)fs.length();
        byte[] image = new byte[streamLength ];
        fs.read(image,0,streamLength );
        fs.close();
        response.setHeader("Content-Type","application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename="+filename);
        response.getOutputStream().write(image );
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }


}
