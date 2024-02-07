package com.me.controller;

import com.me.DAO.MedicationDAO;
import com.me.DAO.UserDAO;
import com.me.pojo.User;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author namithajc
 */
@Controller
public class UserController {
    
    @GetMapping("/register.htm")
    public String goToRegister(){
        return "registerUser";
    }
    
    @GetMapping("/login.htm")
    public String goToLogin(){
        return "login";
    }
    
    @PostMapping("/register.htm")
    public String saveUser(HttpServletRequest request,UserDAO userDao,ModelMap model,HttpSession session)throws ParseException{
        String fname = request.getParameter("firstName");
        String lname = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String password = request.getParameter("password");
        User user = new User();
            user.setFirstname(fname);
            user.setLastname(lname);
            user.setEmail(email);
            user.setDateofbirth(dob);
            user.setPassword(password);
            if(userDao.checkifEmailAlreadyExists(email)){
                return "register";
            }
            else{
        int id = userDao.saveUser(user);
        if(id > 0){
            model.addAttribute("user", user);
            session.setAttribute("user", user.getUserid());
            return "index";
        }
        else{
            return "register";
        }
            }
    }
    
    @PostMapping("/login.htm")
    public String loginUser(HttpServletRequest request,UserDAO userDao,ModelMap model,HttpSession session){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userDao.loginUser(email,password);
        if(user == null){
            return "login";
        }
        else{
            model.addAttribute("user", user);
            session.setAttribute("user", user.getUserid());
            return "index";
        }
    }
}
