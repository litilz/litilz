//package com.ecommerce.litil;
//
//import com.ecommerce.litil.repository.ProductRepository;
//import com.ecommerce.litil.response.CategoryResponse;
//import com.ecommerce.litil.service.ProductService;
//import com.ecommerce.litil.util.LitilConstants;
//import com.ecommerce.litil.vo.CategoryVO;
//import org.junit.Assert;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.commons.logging.Logger;
//import org.junit.platform.commons.logging.LoggerFactory;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.stubbing.OngoingStubbing;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//@Ignore
//class LitilApplicationTests {
//
//    Logger logger = LoggerFactory.getLogger(LitilApplicationTests.class);
//
//	@Mock
//    ProductRepository productRepository;
//
//    @Mock
//    ProductService productService;
//
//    CategoryResponse categoryResponse = new CategoryResponse();
//
//    @Test
//    public void retrieve() {
//        Set<String> set = new TreeSet<>();
//        set.add("oils");
//        set.add("pulses");
//        set.add("sugar&salts");
//
//        CategoryVO ct = new CategoryVO();
//        List<CategoryVO> cVO = new ArrayList<>();
//
//
//
//
//
//        List<String> list = new ArrayList<>(set);
//        categoryResponse.setCategories(list);
//        Mockito.when(productService.getCategories()).thenReturn(categoryResponse);
//        Assert.assertEquals(categoryResponse, productService.getCategories());
//        Mockito.when(productService.getCategories().getCategorys()).thenReturn(set);
//        Assert.assertEquals(set,productService.getCategories().getCategorys());
//    }
//}
