//package com.ecommerce.litil.controller;
//
//import com.ecommerce.litil.response.FileUploadResponse;
//import com.ecommerce.litil.service.FileStorageService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//public class FileUploadController {
//
//
//    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
//
//
//    @Autowired
//    private FileStorageService fileStorageService;
//
//    @PostMapping(value = "/images/productimage", consumes = "multipart/form-data")
//    public FileUploadResponse uploadProductImageFile(@RequestParam("file") MultipartFile file) {
//        return fileStorageService.uploadProductImageFile(file);
//
//    }
//
//    @GetMapping("/product/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
//
//        Resource resource = null;
//        try {
//            resource = fileStorageService.loadAsResource(filename);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        return ResponseEntity.ok()
//                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
//}
