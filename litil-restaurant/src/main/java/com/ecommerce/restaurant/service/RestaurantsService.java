package com.ecommerce.restaurant.service;

import com.ecommerce.restaurant.entity.Restaurant_vs_itemsEntity;
import com.ecommerce.restaurant.entity.RestaurantsEntity;
import com.ecommerce.restaurant.mapper.ItemsMapper;
import com.ecommerce.restaurant.mapper.RestaurantsMapper;
import com.ecommerce.restaurant.repository.RestaurantRepository;
import com.ecommerce.restaurant.repository.RestaurantVSItemsRepository;
import com.ecommerce.restaurant.response.RestaurantResponse;
import com.ecommerce.restaurant.response.RestaurantsResponse;
import com.ecommerce.restaurant.vo.ItemsVO;
import com.ecommerce.restaurant.vo.RestaurantsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RestaurantsService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantVSItemsRepository restaurantVSItemsRepository;


    public RestaurantsResponse getAll() {
        List<RestaurantsVO> restaurantVO = new LinkedList<>();
        List<RestaurantsEntity> resEntity = restaurantRepository.findAll();
        for (RestaurantsEntity eEntity : resEntity) {
            if (eEntity.getActive()) {
                RestaurantsVO resVO = new RestaurantsVO();
                RestaurantsMapper.convertRestaurantEntitytoRestaurantVO(eEntity, resVO);
                restaurantVO.add(resVO);
            }
        }
        RestaurantsResponse restaurantsResponse = new RestaurantsResponse();
        restaurantsResponse.setRestaurantsVO(restaurantVO);
        return restaurantsResponse;
    }

    public RestaurantResponse displayMenu(String restaurantname) {
        RestaurantResponse restaurantResponse = new RestaurantResponse();

        List<Restaurant_vs_itemsEntity> resVSitems = restaurantVSItemsRepository.findAll();
        RestaurantsEntity resEntity = restaurantRepository.findRestaurant(restaurantname);
        List<ItemsVO> itemVo = new LinkedList<>();

        for (Restaurant_vs_itemsEntity resvsItems : resVSitems) {
            ItemsVO iVo = new ItemsVO();
            ItemsMapper.convertItemEntitytoItemVO(resvsItems.getItem_id(), iVo);
            iVo.setPrice(resvsItems.getPrice());
            iVo.setCategory(resvsItems.getItem_id().getCategory());
            iVo.setQuantity(resvsItems.getQuantity());
            itemVo.add(iVo);
        }
        restaurantResponse.setName(restaurantname);
        restaurantResponse.setLocation(resEntity.getRestaurant_loc());
        restaurantResponse.setItems(itemVo);
        return restaurantResponse;
    }
}
