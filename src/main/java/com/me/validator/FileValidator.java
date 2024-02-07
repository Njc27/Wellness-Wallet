/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.me.validator;

import com.me.pojo.FilePdf;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class FileValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return FilePdf.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object command, Errors errors) {
        FilePdf file = (FilePdf) command;
//        
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "empty-isbn", "ISBN cannot be empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "empty-title", "Book Title cannot be empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "empty-author", "Author cannot be empty");
//        
        if (file.getFilePdf().getSize() == 0)
            errors.rejectValue("filePdf", "empty-file", "File is empty");
        
        if (!file.getFilePdf().getOriginalFilename().endsWith(".pdf"))
            errors.rejectValue("filePdf", "file-type", "File MUST BE .pdf");
    }
}
