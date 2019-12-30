package com.fourm.fourm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletRequest.getMethod();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1 ");
        // 这个allow-headers要配为*，这样才能允许所有的请求头
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        //resp.setHeader("Access-Control-Allow-Headers", "*");
        //resp.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (httpServletRequest.getMethod().equalsIgnoreCase("GET")){
            chain.doFilter(request,response);
        }else if (session==null||session.getAttribute("user")==null){
            response.getWriter().write("{\"code\":\"9002\",\"msg\":\"你还未登录\"}");
        }else{
            chain.doFilter(request,response);
        }
    }
}
