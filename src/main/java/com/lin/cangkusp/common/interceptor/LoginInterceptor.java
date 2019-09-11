package com.lin.cangkusp.common.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        String uri = request.getRequestURI();
        if (!uri.endsWith("html")) {
            return true;
        }
        if (uri.equals("/login.html")||uri.equals("/user/login")){
            return true;
        }
        Object sn = session.getAttribute("sno");
        if (sn != null) {
            String sno = sn.toString();
            if (StringUtils.isNotBlank(sno)) {
                return true;
            }
        }
        response.sendRedirect("login.html");
        return false;
    }
}
