package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

/**
 * 如果實作過濾的話會把requestmapping的路由給取代掉，抓進filter裡面
 * 不會返回controller指定的值
 */
@WebFilter(urlPatterns = "/a", filterName = "testFilter")
public class testFilter implements Filter {
    @Override
    public void destroy() {
        System.out.println("filter destroy method");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) {
        System.out.println("filter doFilter method");
    }

    @Override
    public void init(FilterConfig arg0) {
        System.out.println("filter init method");
    }
}
