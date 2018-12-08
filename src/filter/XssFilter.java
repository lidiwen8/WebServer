package filter;

import util.XssHttpServletRequestWraper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(filterName = "XssFilter", urlPatterns = {"/*"})
public class XssFilter implements Filter {

    @Override
    public void destroy() {

    }


    @Override

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XssHttpServletRequestWraper(
                (HttpServletRequest) request), response);//对request和response进行过滤
    }


    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }


}
