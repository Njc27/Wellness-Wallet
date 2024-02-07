/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.controller;

import com.me.DAO.HealthValuesDAO;
import com.me.DAO.UserDAO;
import com.me.pojo.HealthValues;
import com.me.pojo.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author namithajc
 */
@Controller
public class HealthController {    
    @GetMapping("/redirectUpload.htm")
    public ModelAndView gotoHealthValues(HealthValuesDAO healthValuesDao,HttpSession session,UserDAO userDao){
        int userId = (int) session.getAttribute("user");
        User user = userDao.getUserById(userId);
        return new ModelAndView("healthDetails", "healthDetailsList", healthValuesDao.getHealthDataByUserId(user));
    }
    
    @PostMapping("/uploadDetails.htm")
    public ModelAndView uploadHealthData(HttpServletRequest request,HealthValuesDAO healthDao,HttpSession session,UserDAO userDao)throws ParseException{
        HealthValues healthValues = new HealthValues();
        int userId = (int) session.getAttribute("user");
        String bp = request.getParameter("bloodPressure");
        String bs = request.getParameter("bloodSugar");
        String ts = request.getParameter("totalCholestrol");
        String bmi = request.getParameter("bmi");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String currentDate = formatter.format(date);
        User user = userDao.getUserById(userId);
        healthValues.setBloodPressure(bp);
        healthValues.setBloodSugar(bs);
        healthValues.setBmi(bmi);
        healthValues.setTotalCholestrol(ts);
        healthValues.setDatetime(currentDate);
        healthValues.setUser(user);
        healthDao.saveHealth(healthValues);
        return new ModelAndView("healthDetails", "healthDetailsList", healthDao.getHealthDataByUserId(user));
    }
    
    @PostMapping("/updateDetails.htm")
    public ModelAndView updateHealthData(HttpServletRequest request,HealthValuesDAO healthDao,HttpSession session,UserDAO userDao)throws ParseException{
        int healthId = Integer.parseInt(request.getParameter("selected"));
        HealthValues healthValues = healthDao.getHealthDataById(healthId);
        int userId = (int) session.getAttribute("user");
        String bp = request.getParameter("bloodPressure");
        String bs = request.getParameter("bloodSugar");
        String ts = request.getParameter("totalCholestrol");
        String bmi = request.getParameter("bmi");
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String currentDate = formatter.format(date);
        User user = userDao.getUserById(userId);
        healthValues.setBloodPressure(bp);
        healthValues.setBloodSugar(bs);
        healthValues.setBmi(bmi);
        healthValues.setTotalCholestrol(ts);
        healthValues.setDatetime(currentDate);
        healthValues.setUser(user);
        healthDao.updateHealth(healthValues);
        return new ModelAndView("healthDetails", "healthDetailsList", healthDao.getHealthDataByUserId(user));
    }
    
}
