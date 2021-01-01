package com.ecommerce.restaurant.service;

import com.ecommerce.repos.entity.UserEntity;
import com.ecommerce.repos.exception.LitilException;
import com.ecommerce.repos.repository.UserRepository;
import com.ecommerce.repos.util.LitilConstants;
import com.ecommerce.restaurant.entity.FoodCartEntity;
import com.ecommerce.restaurant.entity.ItemsEntity;
import com.ecommerce.restaurant.entity.RestaurantsEntity;
import com.ecommerce.restaurant.mapper.ItemsMapper;
import com.ecommerce.restaurant.mapper.RestaurantsMapper;
import com.ecommerce.restaurant.repository.FoodCartRepository;
import com.ecommerce.restaurant.repository.ItemsRepository;
import com.ecommerce.restaurant.repository.RestaurantsRepository;
import com.ecommerce.restaurant.response.RestaurantResponse;
import com.ecommerce.restaurant.response.RestaurantsResponse;
import com.ecommerce.restaurant.vo.ItemsVO;
import com.ecommerce.restaurant.vo.RestaurantsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class RestaurantsService {

    @Autowired
    RestaurantsRepository restaurantsRepository;


    @Autowired
    FoodCartRepository foodCartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemsRepository itemsRepository;


    public RestaurantsResponse getAll() {
        List<RestaurantsVO> restaurantVO = new LinkedList<>();
        List<RestaurantsEntity> resEntity = restaurantsRepository.findAll();
        if (resEntity.isEmpty()) {
            throw new LitilException("No Restaurents Found !!!");
        } else {
            for (RestaurantsEntity eEntity : resEntity) {
                if (eEntity.getActive()) {
                    RestaurantsVO resVO = new RestaurantsVO();
                    RestaurantsMapper.convertRestaurantEntitytoRestaurantVO(eEntity, resVO);
                    restaurantVO.add(resVO);
                }
            }
        }
        RestaurantsResponse restaurantsResponse = new RestaurantsResponse();
        restaurantsResponse.setRestaurantsVO(restaurantVO);
        return restaurantsResponse;
    }

    public RestaurantResponse displayMenu(String restaurantName, String user_name) {
        RestaurantsEntity resEntity = restaurantsRepository.findRestaurant(restaurantName);
        UserEntity uEntity = userRepository.findByUserId(user_name);
        RestaurantsVO resVO = new RestaurantsVO();
        RestaurantsMapper.convertRestaurantEntitytoRestaurantVO(resEntity, resVO);
        List<ItemsEntity> itemsList = itemsRepository.findAll(resEntity);
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        List<FoodCartEntity> fCEntity = foodCartRepository.findCart(uEntity);
        Map<Integer, Integer> map = new TreeMap<>();
        for (FoodCartEntity fCart : fCEntity) {
            map.put(fCart.getItem_id().getId(), fCart.getQuantity());
        }
        List<ItemsVO> itemVOList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(itemsList)) {
            for (ItemsEntity iEntity : itemsList) {
                if (iEntity.getActive()) {
                    ItemsVO iVO = new ItemsVO();
                    if (map.containsKey(iEntity.getId())) {
                        ItemsMapper.convertItemEntitytoItemVO(iEntity, iVO);
                        iVO.setQuantity(map.get(iEntity.getId()));
                    } else {
                        ItemsMapper.convertItemEntitytoItemVO(iEntity, iVO);
                    }
                    itemVOList.add(iVO);
                }
            }
            restaurantResponse.setItems(itemVOList);
            restaurantResponse.setResVO(resVO);
        } else {
            restaurantResponse.setStatusCode(LitilConstants.FAILURE_CODE);
            restaurantResponse.setStatusDesc("Restaurant Hasn't add any menu");
        }
        return restaurantResponse;
    }
}
