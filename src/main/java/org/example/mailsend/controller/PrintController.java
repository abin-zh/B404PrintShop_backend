package org.example.mailsend.controller;

import org.cups4j.PrintJob;
import org.example.mailsend.service.PrintService;
import org.example.mailsend.utils.PrinterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/print")
public class PrintController {

    private PrintService printService;

    @Autowired
    public PrintController(PrintService printService){
        this.printService = printService;
    }

    @PostMapping("printjob")
    public String print(@RequestBody PrinterBuilder printerBuilder){
        printService.print(printerBuilder);
        System.out.println(printerBuilder.toString());
        return "print job";
    }
}
