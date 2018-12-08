package servlet;
import entity.User;
import service.Impl.UserServiceImpl;
import service.UserService;
import util.Md5Encrypt;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        String name = request.getParameter("username");
        String password= request.getParameter("password");
        String password1=password;
        String verifyCode = request.getParameter("verifyCode");
        String rememberme = request.getParameter("rememberme");//记住登陆
        if ((name!=""&&password!="")) {
            String vcode = (String) request.getSession().getAttribute("vCode");
            if (verifyCode.equalsIgnoreCase(vcode)) {
            UserService userService = new UserServiceImpl();
            Md5Encrypt md5 = new Md5Encrypt();
            try {
                password = md5.Encrypt(request.getParameter("password"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (userService.login(name, password) != null) {
                // 获取application对象
                ServletContext application = this.getServletContext();
                // 获取application对象中user
                ArrayList<String> users = (ArrayList<String>) application.getAttribute("users");
                if (users != null && users.contains(name)) {
                    request.setAttribute("error", "你已经登录了，不能重复登录！");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                } else {
                    if (users == null)// 如果当前application中没有user，初始化user对象
                    {
                        users = new ArrayList<String>();
                    }
                    users.add(name);
                    application.setAttribute("users", users);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", name);//获取用户名
                    User us = userService.login(name, password);
                    if (us.getSex().equals("男")) {
                        request.setAttribute("error", name + "先生登陆成功，欢迎你！");
                    } else {
                        request.setAttribute("error", name + "女士登陆成功，欢迎你！");
                    }
                    //存入cookie
                    if(rememberme!=null) {
                        //创建两个Cookie对象
                        Cookie nameCookie = new Cookie("username", name);
                        //设置Cookie的有效期为3天
                        nameCookie.setMaxAge(60 * 60 * 24 * 3);
                        Cookie pwdCookie = new Cookie("password", password1);
                        pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                        response.addCookie(nameCookie);
                        response.addCookie(pwdCookie);
                    }
                    request.getRequestDispatcher("user/upload.jsp").forward(request, response);
                    //LoginOutUtil.loginOut(this.getServletContext(), session);
                    //session.setMaxInactiveInterval(60);//设置过期时间为60秒
                    return;
                }
            } else {
                request.setAttribute("error", "用户名或密码错误！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
        }else {
                request.setAttribute("error", "验证码错误！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
            }else {
                request.setAttribute("error", "请输入用户名和密码！");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                return;
            }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request,response);
    }

}
