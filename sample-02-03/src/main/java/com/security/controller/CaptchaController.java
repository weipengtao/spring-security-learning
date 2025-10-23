package com.security.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.io.IOException;

@RestController
public class CaptchaController {

    @GetMapping("/captcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
        // 生成验证码：宽100，高40，4位字符，2条干扰线
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40, 4, 2);

        // 将验证码存入 session，用于登录校验
        session.setAttribute("captcha", captcha.getCode());

        // 输出图片到浏览器
        response.setContentType("image/png");
        ImageIO.write(captcha.getImage(), "png", response.getOutputStream());
    }
}
