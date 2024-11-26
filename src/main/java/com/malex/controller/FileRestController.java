package com.malex.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileRestController {

    public static final String FILE_REST_REQUEST_MAPPING = "/api/v1/files";

    public static final String ATTACHMENT_HEADER_FORMATTER = "attachment;filename=%s.txt";

    private final String fileContent;

    private final String attachmentHeader;

    private FileRestController(@Value("${tests.performance.endpoint}") String endpoint) {
        this.attachmentHeader = ATTACHMENT_HEADER_FORMATTER.formatted(endpoint);
        this.fileContent = endpoint;
    }

    @GetMapping(FILE_REST_REQUEST_MAPPING)
    public void export(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", attachmentHeader);
        ServletOutputStream out = response.getOutputStream();
        out.println(fileContent);
        out.flush();
        out.close();
    }

}
