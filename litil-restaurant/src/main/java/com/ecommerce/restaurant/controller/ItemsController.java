//package com.ecommerce.restaurant.controller;
//
//
//import com.ecommerce.restaurant.entity.ItemCategoryEntity;
//import com.ecommerce.restaurant.repository.ItemCategoryRepository;
//import com.ecommerce.restaurant.service.ItemsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class ItemsController {
//
//    @Autowired
//    ItemsService itemsService;
//
//    @Autowired
//    ItemCategoryRepository ItemCategoryRepository;
//
//    @GetMapping("/getItems/{restaurant}")
//    public void getItems(@PathVariable("restaurant") String restaurant) {
//        itemsService.getItems(restaurant);
//
//    }
//
//    @GetMapping("/categories")
//    public List<ItemCategoryEntity> getCategories() {
//        List<ItemCategoryEntity> itemCategoryEntity = ItemCategoryRepository.findAll();
//        return itemCategoryEntity;
//    }
//
//}
