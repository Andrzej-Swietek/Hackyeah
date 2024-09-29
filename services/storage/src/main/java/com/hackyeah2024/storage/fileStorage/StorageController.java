package com.hackyeah2024.storage.fileStorage;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/storage")
@AllArgsConstructor
public class StorageController {

    private final Storage storage;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@ModelAttribute FileUploadRequest request) {
        MultipartFile file = request.getFile();
        String destinationPath = request.getDestinationPath();

        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        storage.store(file, destinationPath);
        return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully");
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam String filePath) {
        Resource resource = storage.load(filePath);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFile(@RequestParam String filePath) {
        storage.delete(filePath);
        return ResponseEntity.ok("File deleted successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> listFiles(@RequestParam String directoryPath) {
        List<String> files = storage.listFiles(directoryPath);
        return ResponseEntity.ok(files);
    }
}
