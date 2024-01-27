package org.example.mailsend.controller;

import org.example.mailsend.dto.AfterUploadPdf;
import org.example.mailsend.service.FileService;
import org.example.mailsend.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ApiResponse getIpptest(@RequestParam("file") MultipartFile file){
        AfterUploadPdf afPdf = fileService.handleFileUpload(file);
        if(afPdf != null){
            return new ApiResponse(200,"上传成功",afPdf);
        }
        return new ApiResponse(400,"上传失败",null);
    }

}
