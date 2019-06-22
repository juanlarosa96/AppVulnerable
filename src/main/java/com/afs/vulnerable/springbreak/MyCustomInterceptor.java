package com.afs.vulnerable.springbreak;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

public class MyCustomInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {
        if ("POST".equalsIgnoreCase(request.getMethod()) || "PATCH".equalsIgnoreCase(request.getMethod())) {
            try {
                String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                System.out.println(body);
            } catch (Exception e) {

            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception{
        if((var2.getStatus() == 404)){

        }
    }

    public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception{}
}
