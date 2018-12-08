package servlet;

import entity.User;
import service.Impl.UserServiceImpl;
import service.UserService;
import util.Md5Encrypt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmpass = request.getParameter("password2");
        String sex=  request.getParameter("sex");
        UserService userservice = new UserServiceImpl();
        if (name!=null&&name!=""&&password!=""&&password!=null&&confirmpass!=null&&confirmpass!="") {
            if (sex.equals(null)||sex.equals("")) {
                response.getWriter().print("{\"res\": 28, \"info\":\"性别不能为空！\"}");
                return;
            }
            if (userservice.queryUser(name)!= null) {
                response.getWriter().print("{\"res\": 19, \"info\":\"尊敬的用户:你输入的账号已经存在!注册失败，请换一个其它账号呗！\"}");
                return;
                }else {
                if (password.equals(confirmpass)) {
                    Md5Encrypt md5=new Md5Encrypt();
                    try{
                        password= md5.Encrypt(request.getParameter("password"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                        User user = new User();
                        user.setName(name);
                        user.setSex(sex);
                        user.setPassword(password);
                        try {
                            if (userservice.add(user)==1) {
                                response.getWriter().print("{\"res\": 1, \"info\":\"注册成功\"}");
                                return;
                            } else {
                                response.getWriter().print("{\"res\": -1, \"info\":\"注册失败\"}");
                                return;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {
                    response.getWriter().print("{\"res\": 5, \"info\":\"尊敬的用户:确认密码跟新密码不匹配，请重新输入确认密码！\"}");
                    return;
                    }
                }
        }else{
            response.getWriter().print("{\"res\": 3, \"info\":\"请输入用户名和密码！\"}");
            return;
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

}
