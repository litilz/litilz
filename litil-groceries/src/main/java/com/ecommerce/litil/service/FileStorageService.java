package com.ecommerce.litil.service;

import com.ecommerce.litil.config.StorageProperties;
import com.ecommerce.litil.response.FileUploadResponse;
import com.ecommerce.litil.util.LitilConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {


    private final Path rootLocation;

    @Autowired
    public FileStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            //throw new StorageException("Could not initialize storage location", e);
        }
    }

    public FileUploadResponse uploadProductImageFile(MultipartFile file) {
        FileUploadResponse fileUploadResponse = new FileUploadResponse();

        try {
            Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
            fileUploadResponse.setStatusCode(LitilConstants.SUCCESS_CODE);
            fileUploadResponse.setStatusDesc(LitilConstants.SUCCESS_DESC);
        } catch (Exception e) {
            e.printStackTrace();
            fileUploadResponse.setStatusCode(LitilConstants.FAILURE_CODE);
            fileUploadResponse.setStatusDesc(LitilConstants.FAILURE_DESC);
        }
        fileUploadResponse.setFileName(file.getOriginalFilename());
        return fileUploadResponse;
    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) throws Exception {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException(
                        "Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not read file: " + filename);
        }
    }

}
