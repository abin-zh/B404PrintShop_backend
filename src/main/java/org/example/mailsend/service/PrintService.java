package org.example.mailsend.service;

import org.example.mailsend.utils.PrinterBuilder;

import java.util.Map;


public interface PrintService {

    /**
     * 打印
     * @param printerBuilder
     */
    public String print(PrinterBuilder printerBuilder);
}
