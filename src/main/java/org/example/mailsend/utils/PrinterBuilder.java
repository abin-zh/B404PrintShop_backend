package org.example.mailsend.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PrinterBuilder {
    private int copies = 1;
    private String pageRanges = null;
    private String userName;
    private boolean duplex = false;
    private boolean color = false;
    private String pageFormat;
    private String fileName;

    public PrinterBuilder() {
    }

    public PrinterBuilder(int copies, String pageRanges, String userName, boolean duplex, boolean color, String pageFormat) {
        this.copies = copies;
        this.pageRanges = pageRanges;
        this.userName = userName;
        this.duplex = duplex;
        this.color = color;
        this.pageFormat = pageFormat;
    }

}
