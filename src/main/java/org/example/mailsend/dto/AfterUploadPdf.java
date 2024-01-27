package org.example.mailsend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AfterUploadPdf {
    private String fileName;
    private int count;

    public AfterUploadPdf() {
    }

    public AfterUploadPdf(String fileName, int count) {
        this.fileName = fileName;
        this.count = count;
    }
}
