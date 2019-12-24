package com.fourm.fourm.filter;


import com.fourm.fourm.util.JwtUtil;
import io.jsonwebtoken.Claims;


import javax.servlet.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class TokenFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //System.out.println("过滤器初始化xs");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {

        //System.out.println("过滤器运行了");
        HttpServletRequest request =(HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String token = request.getHeader("Authorization"); //获取请求传来的token
        Claims claims = JwtUtil.verifyJwt(token); //验证token
        if (claims == null) {
            response.getWriter().write("token is invalid");
        }else {
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

        //System.out.println("过滤器摧毁xs");
    }
}
