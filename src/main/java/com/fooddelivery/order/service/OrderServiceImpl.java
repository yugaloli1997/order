package com.fooddelivery.order.service;

import com.fooddelivery.order.dto.OrderDTO;
import com.fooddelivery.order.dto.OrderDTOFromFrontend;
import com.fooddelivery.order.dto.UserDTO;
import com.fooddelivery.order.entity.Order;
import com.fooddelivery.order.mapper.OrderMapper;
import com.fooddelivery.order.repo.OrderRepo;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public OrderDTO saveOrder(OrderDTOFromFrontend orderDTOFromFrontend) {
        Integer nextOrderId= sequenceGenerator.generateNextOrderID();
        UserDTO userDto = fetchUserDetailsForUserId(orderDTOFromFrontend.getUserId());
        Order order = new Order(nextOrderId,orderDTOFromFrontend.getRestaurant(),orderDTOFromFrontend.getFoodItemsList(),userDto);
        orderRepo.save(order);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(order);
    }

    private UserDTO fetchUserDetailsForUserId(Integer userId) {
        return restTemplate.getForObject("http://USERINFO/user/findUser/"+userId,UserDTO.class);
    }
}
