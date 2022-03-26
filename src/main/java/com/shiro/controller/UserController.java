package com.shiro.controller;

import com.shiro.entity.User;
import com.shiro.service.UserRoleService;
import com.shiro.service.UserService;
import com.shiro.util.VerifyCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
//    , String verifyCode,HttpSession session
    public String login(String username, String password){
        // 校验验证码
//        String verifyCodes = (String) session.getAttribute("verifyCode");
        // 获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        try {
//            if(verifyCodes.equalsIgnoreCase(verifyCode)){
                subject.login(new UsernamePasswordToken(username,password));
//                session.setAttribute("userId",userService.userByNaem(username).getId());
                return "redirect:/index.jsp";
//            } else {
//                throw new RuntimeException("验证码错误");
//            }
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误~");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误~");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("登陆失败");
        // 如果认证失败仍然回到登录页面
        return "redirect:/login.jsp";
    }

    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
        //验证码放入session
        session.setAttribute("verifyCode",verifyCode);
        //验证码存入图片
        ServletOutputStream os = response.getOutputStream();
        response.setContentType("image/png");
        VerifyCodeUtil.outputImage(180,40,os,verifyCode);
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        // 退出后仍然会到登录页面
        return "redirect:/login.jsp";
    }

    //注册时自动授权为user
    @RequestMapping("/register")
    public String register(User user){
        try {
            userService.register(user);
            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/register.jsp";
    }

    @RequestMapping("/userSelect")
    @ResponseBody
    public List<User> userSelect(){
        List<User> userList= userService.userSelect();
        return userList;
    }

    //为staff注册授权
    @PostMapping("/staffregister")
    public String staffregister(User user){
       try{
           userService.staffregister(user);
           return "redirect:/user/userSelect";
       }catch (Exception e){
           e.printStackTrace();
       }
       return "redirect:/userinsert.jsp";
    }

}


