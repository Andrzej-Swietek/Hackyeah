package com.hackyeah2024.storage.fileStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FileSystemStorage implements Storage {

    @Value("${storage.local.base-path}")
    private String basePath;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    @Async
    public void store(MultipartFile file, String destinationPath) {
        try {
            Resource resource = resourceLoader.getResource(basePath + destinationPath);
            File destinationFile = resource.getFile();
            Files.createDirectories(destinationFile.getParentFile().toPath());
            Files.copy(file.getInputStream(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file: " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filePath) {
        try {
            Resource resource = new FileSystemResource(ResourceUtils.getFile(filePath));
            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("Resource not found or not readable.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error loading resource: " + e.getMessage());
        }
    }
    @Override
    public void delete(String filePath) {
        try {
            File fileToDelete = ResourceUtils.getFile(basePath + File.separator + filePath);

            if (fileToDelete.exists() && fileToDelete.isFile()) {
                if (!fileToDelete.delete()) {
                    throw new RuntimeException("Failed to delete file.");
                }
            } else {
                throw new FileNotFoundException("File not found or is not a file.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete file: " + e.getMessage());
        }
    }

    @Override
    public boolean exists(String filePath) {
        try {
            File fileToCheck = ResourceUtils.getFile(basePath + File.separator + filePath);
            return fileToCheck.exists() && fileToCheck.isFile();
        } catch (IOException e) {
            return false;
        }
    }


    public void move(String sourcePath, String destinationPath) {
        try {
            Path source = Paths.get(basePath, sourcePath);
            Path destination = Paths.get(basePath, destinationPath);

            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to move file or directory: " + e.getMessage());
        }
    }

    @Override
    public void rename(String currentPath, String newName) {
        try {
            Path currentFile = Paths.get(basePath, currentPath);
            Path renamedFile = currentFile.resolveSibling(newName);
            Files.move(currentFile, renamedFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to rename file: " + e.getMessage());
        }
    }

    @Override
    public void copy(String sourcePath, String destinationPath) {
        try {
            Path source = Paths.get(basePath, sourcePath);
            Path destination = Paths.get(basePath, destinationPath);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to copy file or directory: " + e.getMessage());
        }
    }

    @Override
    public String generateUniqueFileName(String originalFileName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        String uniqueId = UUID.randomUUID().toString();
        String fileExtension = getFileExtension(originalFileName);

        return timestamp + "_" + uniqueId + "." + fileExtension;
    }

    public List<String> listFiles(String directoryPath) {
        try {
            File directory = ResourceUtils.getFile(basePath + File.separator + directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();
                List<String> fileNames = new ArrayList<>();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            fileNames.add(file.getName());
                        }
                    }
                }

                return fileNames;
            } else {
                throw new FileNotFoundException("Directory not found or is not a directory.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to list files: " + e.getMessage());
        }
    }

    public void deleteDirectory(String directoryPath) {
        try {
            File directoryToDelete = ResourceUtils.getFile(basePath + File.separator + directoryPath);

            if (directoryToDelete.exists() && directoryToDelete.isDirectory()) {
                if (!FileSystemUtils.deleteRecursively(directoryToDelete)) {
                    throw new RuntimeException("Failed to delete directory.");
                }
            } else {
                throw new FileNotFoundException("Directory not found or is not a directory.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete directory: " + e.getMessage());
        }
    }

    private String getFileExtension(String originalFileName) {
        int lastDotIndex = originalFileName.lastIndexOf(".");
        if (lastDotIndex != -1) {
            return originalFileName.substring(lastDotIndex + 1);
        }
        return "";
    }


}
