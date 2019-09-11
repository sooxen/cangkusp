package com.lin.cangkusp.controller;

import com.github.botaruibo.xvcode.generator.PngVCGenerator;
import com.lin.cangkusp.common.config.yu;
import com.lin.cangkusp.common.constant.ConResult;
import com.lin.cangkusp.pojo.User;
import com.lin.cangkusp.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.botaruibo.xvcode.generator.Generator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login")
    @ResponseBody
    @yu
    public ConResult userLogin(User user, String remember, String code,HttpServletResponse response,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (StringUtils.isBlank(code) || !code.equals(session.getAttribute("code"))){
            return ConResult.error().setMsg("验证码错误");
        }

        session.setAttribute("sno", user.getSno());
        session.setAttribute("upwd", user.getUpwd());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getSno(), user.getUpwd());
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return ConResult.error().setMsg("用户名或密码错误！");
        } catch (Exception e){
            return ConResult.error().setMsg("未知错误！");
        }
        if (subject.isAuthenticated()) {
            return ConResult.ok();
        }
        return ConResult.error().setMsg("用户名或密码错误！");
    }

    @RequestMapping("verifycode")
    public void VerifyCode(HttpServletResponse response, HttpServletRequest request){
        Integer height = 30;//image 高度。  image height. count as pixel
        Integer width = 160;//image 宽度。 image width. count as pixel
        Integer count = 4;	// validation code length.
        String validCode = null; //验证码
        HttpSession session = request.getSession();
        Generator generator = new PngVCGenerator(width, height, count);
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpeg");
        try {
            generator.write2out(response.getOutputStream()).close();
            validCode = generator.text();
            session.setAttribute("code",validCode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
