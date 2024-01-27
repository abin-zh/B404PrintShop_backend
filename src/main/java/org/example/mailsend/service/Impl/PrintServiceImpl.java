package org.example.mailsend.service.Impl;


import org.cups4j.CupsPrinter;
import org.cups4j.PrintJob;
import org.cups4j.PrintRequestResult;
import org.example.mailsend.service.PrintService;
import org.example.mailsend.utils.CommonUtil;
import org.example.mailsend.utils.PrintUtil;
import org.example.mailsend.utils.PrinterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Service
public class PrintServiceImpl implements PrintService {
    private PrintUtil printUtil;

    @Autowired
    public PrintServiceImpl(PrintUtil printUtil){
        this.printUtil = printUtil;
    }

    @Override
    public String print(PrinterBuilder printerBuilder) {
        //URL printerURL = new URL("https://192.168.2.152:631/printers/HP_OfficeJet_Pro_7740_series");
        //Map<String,String> attr = new HashMap<>();
        String path = CommonUtil.getPath() + "/" + printerBuilder.getFileName() + ".pdf";
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CupsPrinter cupsPrinter = printUtil.getCupsPrinter();
        PrintJob printJob = printUtil.createPrintJob(printerBuilder,inputStream);
        String jobState = null;
        try{
            PrintRequestResult result = cupsPrinter.print(printJob);
            jobState = result.getResultMessage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(jobState);
        return jobState;
    }
}
