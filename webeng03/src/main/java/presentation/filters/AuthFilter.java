package presentation.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

//headercache control
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
       // String loginURL = request.getContextPath() + "./protected/index.html";

        HttpSession sesh = req.getSession(false);
        boolean istAngemeldet = sesh != null && sesh.getAttribute("username") != null ;

        if(istAngemeldet){
            chain.doFilter(req, res);
        }
        else{
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "not logged in");
        }

    }
}
