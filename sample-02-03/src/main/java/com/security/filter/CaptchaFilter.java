package com.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CaptchaFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        // 只在登录请求时校验
        if ("/doLogin".equals(request.getRequestURI()) && "POST".equalsIgnoreCase(request.getMethod())) {
            String captchaInput = request.getParameter("captcha");
            String captchaSession = (String) request.getSession().getAttribute("captcha");

            if (captchaSession == null || !captchaSession.equalsIgnoreCase(captchaInput)) {
                response.sendRedirect("/login?captchaError=true");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
