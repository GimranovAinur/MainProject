package info.kpfu.itis.controllers;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import info.kpfu.itis.model.FileUpload;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {

    private static String UPLOAD_LOCATION = "/assets/images";


    @RequestMapping(value = "/singleUpload", method = RequestMethod.GET)
    public String getSingleUploadPage(ModelMap model) {
        FileUpload fileModel = new FileUpload();
        model.addAttribute("fileUpload", fileModel);
        return "search";
    }

    @RequestMapping(value = "/singleUpload", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public String singleFileUpload(@Valid FileUpload fileUpload, BindingResult result, ModelMap model) throws IOException {

        if (result.hasErrors()) {
            System.out.println("validation errors");
            return "search";
        } else {
            System.out.println("Fetching file");
            MultipartFile multipartFile = fileUpload.getFile();

            //Now do something with file...
            FileCopyUtils.copy(fileUpload.getFile().getBytes(), new File(UPLOAD_LOCATION + fileUpload.getFile().getOriginalFilename()));

            String fileName = multipartFile.getOriginalFilename();
            model.addAttribute("fileName", fileName);
            return "search";
        }
    }
}