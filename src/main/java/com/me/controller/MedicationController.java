/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.controller;

import com.me.DAO.MedicationDAO;
import com.me.DAO.UserDAO;
import com.me.pojo.Medication;
import com.me.pojo.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author namithajc
 */
@Controller
public class MedicationController {
    
    @GetMapping("/medicine.htm")
    public ModelAndView allMedication(MedicationDAO medicationDAO,HttpSession session,UserDAO userDao) {
        int userId = (int) session.getAttribute("user");
        User user = userDao.getUserById(userId);
        return new ModelAndView("medication", "medicationList", medicationDAO.getMedicationByUsers(user));
    }
    
    @PostMapping("/updateMedicines.htm")
    public ModelAndView editMedication(HttpServletRequest request,MedicationDAO medicationDAO,ModelMap model,HttpSession session,UserDAO userDao) {
        int  id = Integer.parseInt(request.getParameter("selection"));
        Medication med = medicationDAO.getMedicationId(id);
        int userId = (int) session.getAttribute("user");
        User user = userDao.getUserById(userId);
         String button = request.getParameter("button");
        if (button.equals("Delete")) {
            med.setUser(null);
            medicationDAO.editMedication(med);
            return new ModelAndView("medication", "medicationList", medicationDAO.getMedicationByUsers(user));
        } else if (button.equals("Update")) {
            return new ModelAndView("updateMedication", "medicationList", med);
        }
            return new ModelAndView("updateMedication", "medicationList", med);
    }
    
    @PostMapping("/medicine.htm")
    public ModelAndView addMedication(HttpServletRequest request,MedicationDAO medicationDAO,HttpSession session,UserDAO userDao) throws ParseException {
        Medication med = new Medication();
        int userId = (int) session.getAttribute("user");
        User user = userDao.getUserById(userId);
        String name = request.getParameter("medicineName");
        String quantity = request.getParameter("quantity");
        String dateString = request.getParameter("expiryDate");
        String morning = request.getParameter("morning");
        if(morning == null){
           med.setIsMorning(false);
        }
        else{
            med.setIsMorning(true);
        }
        String afternoon = request.getParameter("afternoon");
        if(afternoon == null){
           med.setIsAfternoon(false);
        }
        else{
            med.setIsAfternoon(true);
        }
        String evening = request.getParameter("evening");
        if(evening == null){
           med.setIsEvening(false);
        }
        else{
            med.setIsEvening(true);
        }
        med.setExpiryDate(dateString);
        med.setName(name);
        med.setQuantity(Integer.parseInt(quantity));
        med.setUser(user);
        medicationDAO.saveMedication(med);
        return new ModelAndView("medication", "medicationList", medicationDAO.getMedicationByUsers(user));
    }

    @PostMapping("/updateMedi.htm")
    public ModelAndView editMedicationValues(HttpServletRequest request,MedicationDAO medicationDAO,HttpSession session,UserDAO userDao){
        String name = request.getParameter("medicineName");
        int  id = Integer.parseInt(request.getParameter("selection"));
        int userId = (int) session.getAttribute("user");
        User user = userDao.getUserById(userId);
        Medication med = medicationDAO.getMedicationId(id);
        String quantity = request.getParameter("quantity");
        String dateString = request.getParameter("expiryDate");
        String morning = request.getParameter("morning");
        if(morning == null){
           med.setIsMorning(false);
        }
        else{
            med.setIsMorning(true);
        }
        String afternoon = request.getParameter("afternoon");
        if(afternoon == null){
           med.setIsAfternoon(false);
        }
        else{
            med.setIsAfternoon(true);
        }
        String evening = request.getParameter("evening");
        if(evening == null){
           med.setIsEvening(false);
        }
        else{
            med.setIsEvening(true);
        }
        med.setExpiryDate(dateString);
        med.setQuantity(Integer.parseInt(quantity));
       
        medicationDAO.editMedication(med);
        return new ModelAndView("medication", "medicationList", medicationDAO.getMedicationByUsers(user));
}
}
