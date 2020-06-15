package com.xuezx.blog.controller.common;

import com.xuezx.blog.result.UploadTokenResult;
import com.xuezx.blog.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/config")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConfigController {

    @Autowired
    private ConfigService configService;


    @RequestMapping(value = "/image/getUploadToken", method = {RequestMethod.GET})
    public UploadTokenResult getUploadToken(@RequestParam("fileNameNumber") String fileNameNumber) {

        return configService.getUploadToken(Integer.parseInt(fileNameNumber));
    }

}