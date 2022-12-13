package fun.rpdk.mvcxmlx.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ErrorFilter")
public class ErrorFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (request.getLocalAddr().equals(request.getRemoteAddr()))
            chain.doFilter(request, response);
        else
            ((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath());
    }
}
