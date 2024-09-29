package com.hackyeah2024.storage.fileStorage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class S3Storage implements Storage {

    @Override
    public void store(MultipartFile file, String destinationPath) {

    }

    @Override
    public Resource load(String filePath) {
        return null;
    }

    @Override
    public void delete(String filePath) {

    }

    @Override
    public boolean exists(String filePath) {
        return false;
    }

    @Override
    public void move(String sourcePath, String destinationPath) {

    }

    @Override
    public void rename(String currentPath, String newName) {

    }

    @Override
    public void copy(String sourcePath, String destinationPath) {

    }

    @Override
    public String generateUniqueFileName(String originalFileName) {
        return "";
    }

    @Override
    public List<String> listFiles(String directoryPath) {
        return List.of();
    }

    @Override
    public void deleteDirectory(String directoryPath) {

    }
}
