package org.example.mailsend.service.Impl;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import org.apache.commons.io.IOUtils;
import org.example.mailsend.dto.AfterUploadPdf;
import org.example.mailsend.service.FileService;
import org.example.mailsend.utils.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public AfterUploadPdf handleFileUpload(MultipartFile file) {
        InputStream inputStream = null;
        String fileName = null;
        int count = 0;
        AfterUploadPdf afPdf = null;
        try{
            inputStream = file.getInputStream();
            System.out.println(getPDFPages(file));
            //当文件正确且大小不超过10M时
            if(file.getContentType().equals("application/pdf") && file.getSize() < 1024 * 1024 * 10){
                UUID uuid = UUID.randomUUID();
                fileName = uuid.toString();
                String path = CommonUtil.getPath();
                File dir = new File(path);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                count = getPDFPages(file);
                afPdf = new AfterUploadPdf(fileName,count);
                File tempFile = new File(path + "/" +fileName + ".pdf");
                file.transferTo(tempFile);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭流
            if(inputStream != null){
                IOUtils.closeQuietly(inputStream);
            }
        }
        return afPdf;
    }

    @Override
    public int getPDFPages(MultipartFile file) {
        InputStream inputStream = null;
        try{
            inputStream = file.getInputStream();
            PdfReader reader = new PdfReader(inputStream);
            PdfDocument pdfDocument = new PdfDocument(reader);
            int count = pdfDocument.getNumberOfPages();
            return count;
        }catch (IOException e){
            e.printStackTrace();
            return 0;
        }finally {
            if(inputStream != null){
                IOUtils.closeQuietly(inputStream);
            }
        }
    }
}
