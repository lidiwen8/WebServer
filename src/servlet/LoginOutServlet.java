package servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginOutServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String name= (String) request.getSession().getAttribute("user");
        if(request.getSession().getAttribute("user") != null){
            System.out.println(request.getSession().getAttribute("user") + "退出");
            ServletContext application = this.getServletContext();
            request.getSession().invalidate();//使session无效
//            ServletContext application = this.getServletContext();
            application.removeAttribute("users");//从application中移除users使session无效
            request.setAttribute("error", name+"退出成功,欢迎你下次继续访问");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}


