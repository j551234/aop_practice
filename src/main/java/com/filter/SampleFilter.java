package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/**
 * url patterns design filter route path
 * */
@WebFilter(urlPatterns = "/123", filterName = "testFilter")
public class SampleFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("filter destroy method");
    }

    /**
     * if not use filter chain function will skip function
     *
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("filter : doFilter method");
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) {
    }
}
