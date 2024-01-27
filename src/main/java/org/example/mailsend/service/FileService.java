package org.example.mailsend.service;

import org.example.mailsend.dto.AfterUploadPdf;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {

    /**
     * 文件上传
     * @param file
     */
    public AfterUploadPdf handleFileUpload(MultipartFile file);

    /**
     * 获取文件(pdf)页数
     * @param file
     */
    public int getPDFPages(MultipartFile file);

}
