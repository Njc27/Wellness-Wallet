/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.controller;

import com.me.DAO.FilePdfDAO;
import com.me.DAO.MedicationDAO;
import com.me.DAO.UserDAO;
import com.me.pojo.FilePdf;
import com.me.pojo.User;
import com.me.validator.FileValidator;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.hibernate.internal.util.io.StreamCopier.BUFFER_SIZE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author namithajc
 */
@Controller
public class FileController {
    private ServletContext servletContext;
   
//    @Autowired
//    FileValidator validator; //okay to be shared. so, declared globally

    
    @GetMapping("/index.htm")
    public String welcome(@ModelAttribute("user") User user) {
        return "index";
    }
    
    @GetMapping("/goHome.htm")
    public String welcome(ModelMap model,HttpSession session,UserDAO userDao) {
        int userId = (int) session.getAttribute("user");
        User user = userDao.getUserById(userId);
        model.addAttribute("user", user);
        return "index";
    }
    
     @GetMapping("/fileUpload.htm")
    public String fileUpload(ModelMap model, FilePdf filePdf) {
        model.addAttribute("filePdf", filePdf);
        return "uploadfile";
    }
    
    @GetMapping("/viewAll.htm")
    public ModelAndView allFiles(FilePdfDAO fileDao,HttpSession session,UserDAO userDao) {
        int userId = (int) session.getAttribute("user");
        User user = userDao.getUserById(userId);
        return new ModelAndView("viewFiles", "fileList", fileDao.getFilesByUsers(user));
    }
    
     @PostMapping("/fileUpload.htm")
    public String showSuccess(@RequestParam CommonsMultipartFile filePdf,ModelMap model, FilePdf fileObj, HttpSession session, BindingResult result, SessionStatus status, FilePdfDAO filedao,UserDAO userDao,HttpServletRequest request)throws Exception {
        FileValidator validator = new FileValidator();
        validator.validate(fileObj, result);

        if (result.hasErrors()) {
            return "uploadfile";
        }
       String rootPath = System.getProperty("catalina.home");
       File dir = new File(rootPath + File.separator + "images");
       if (!dir.exists())
	dir.mkdirs();
        
    String filename = filePdf.getOriginalFilename();  
    
    byte[] bytes = filePdf.getBytes();  
    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
         new File(dir.getAbsoluteFile() + File.separator + filename)));  
    stream.write(bytes);  
    stream.flush();  
    stream.close();
    int userId = (int) session.getAttribute("user");
    User user = userDao.getUserById(userId);
    fileObj.setFilename(filename);
    fileObj.setFilePath(dir.getAbsoluteFile() + File.separator + filename);
    fileObj.setUser(user);

    //        //Mark the current handler's session processing as complete, allowing for cleanup of session attributes
        status.setComplete();

        //persist the Book object
        filedao.saveBook(fileObj);
        
        model.addAttribute("user", user);
        return "index";
}
    
    @PostMapping("/download.htm")
    public void  downloadFile(FilePdfDAO filedao,HttpServletRequest request,HttpSession session,HttpServletResponse response)throws Exception {
        int  id = Integer.parseInt(request.getParameter("selection"));
        FilePdf file = filedao.getFileById(id);
        

        ServletContext context = session.getServletContext(); 
        String appPath = context.getRealPath("");
 
        // absolute path of the file
        String fullPath = file.getFilePath();      
        File downloadFile = new File(fullPath);
        FileInputStream inputStream = new FileInputStream(downloadFile);
         
        // MIME type of the file
        String mimeType = context.getMimeType(fullPath);
        if (mimeType == null) {
            // Set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
 
        // set content attributes for the response object
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
 
        // set headers for the response object
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);
 
        // get output stream of the response
        OutputStream outStream = response.getOutputStream();
 
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
 
        // write each byte of data  read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
 
        inputStream.close();
        outStream.close();
}
    
    
}
