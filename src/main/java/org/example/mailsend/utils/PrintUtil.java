package org.example.mailsend.utils;

import org.cups4j.CupsAuthentication;
import org.cups4j.CupsClient;
import org.cups4j.CupsPrinter;
import org.cups4j.PrintJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class PrintUtil {
    @Value("${cups.username}")
    private String host;

    @Value("${cups.port}")
    private int port;

    @Value("${cups.username}")
    private String username;

    @Value("${cups.password}")
    private String password;

    @Value("${cups.printer}")
    private String printer;


    private CupsPrinter cupsPrinter;

    @Autowired
    public PrintUtil() throws Exception {
        CupsAuthentication creds = new CupsAuthentication(username, password);
        CupsClient cupsClient = new CupsClient(host, port, username, creds);
        cupsPrinter = cupsClient.getPrinter(printer);
    }

    public CupsPrinter getCupsPrinter() {
        return cupsPrinter;
    }

    public PrintJob createPrintJob(PrinterBuilder printerBuilder, InputStream file) {
        Map attr = new HashMap();
        attr.put("attributes-charset","utf-8");
        attr.put("document-format","application/pdf");
        PrintJob printJob = new PrintJob.Builder(file)
                .copies(printerBuilder.getCopies())
                .pageRanges(printerBuilder.getPageRanges())
                .userName(printerBuilder.getUserName())
                .duplex(printerBuilder.isDuplex())
                .color(printerBuilder.isColor())
                .pageFormat(printerBuilder.getPageFormat())
                .attributes(attr)
                .build();
        return printJob;
    }

}
