package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
/**
 *  如果實作過濾的話會把requestmapping的路由給取代掉
 *  不會返回controller指定的值
 * */
@WebFilter(urlPatterns = "/index", filterName = "testFilter")
public class testFilter implements Filter{
	  @Override
	  public void destroy() {
	    System.out.println("filter destroy method");
	  }
	  @Override
	  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
	      throws IOException, ServletException {
	    System.out.println("filter doFilter method");
	  }
	  @Override
	  public void init(FilterConfig arg0) throws ServletException {
	    System.out.println("filter init method");
	  }
	}
