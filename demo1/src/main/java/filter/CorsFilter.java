package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: UserDemo
 * @description:
 * @author: Cui
 * @create: 2020-09-03 20:07
 */
public class CorsFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,

            ServletException {

// TODO Auto-generated method stub

        HttpServletResponse res = (HttpServletResponse) response;


        res.setContentType("text/html;charset=UTF-8");

        res.setHeader("Access-Control-Allow-Origin", "*");

        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

        res.setHeader("Access-Control-Max-Age", "0");

        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type,token,x-token");

        res.setHeader("Access-Control-Allow-Credentials", "true");

        res.setHeader("Access-Control-Expose-Headers", "Authorization");

        res.setHeader("XDomainRequestAllowed", "1");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}