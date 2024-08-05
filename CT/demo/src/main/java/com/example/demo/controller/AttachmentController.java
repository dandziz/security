package com.example.demo.controller;

import com.example.demo.dto.AttachmentRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequestMapping("/attachment")
@RestController
public class AttachmentController {

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String uploadAttachment(
            @RequestParam(name = "attachment_idx") Long attachmentIdx,
            @RequestPart(value = "added_files") MultipartFile[] addedFiles,
            @RequestParam(name = "removed_files") List<String> removedFiles,
            @RequestParam(name = "file_urls") List<String> fileUrls,
            @RequestParam(name = "file_type") Long fileType
            ) {
        System.out.println(attachmentIdx);
        System.out.println(addedFiles);
        return addedFiles.toString();
    }

    @PostMapping(
            value = "/all",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String uploadAllAttachment(
            @RequestParam(name = "attachment_idx") Long attachmentIdx,
            @RequestParam(value = "body") AttachmentRequest[] body
            ) {
        return "";
    }
}
