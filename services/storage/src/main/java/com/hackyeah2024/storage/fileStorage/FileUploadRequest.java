package com.hackyeah2024.storage.fileStorage;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUploadRequest {
    private MultipartFile file;
    private String destinationPath;
}