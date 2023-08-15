package com.szq.web;

import javax.servlet.*;
import java.io.File;
import java.io.IOException;

//自定义过滤器
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行了MyFilter,doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
