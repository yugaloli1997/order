package com.fooddelivery.order.service;

import com.fooddelivery.order.dto.OrderDTO;
import com.fooddelivery.order.dto.OrderDTOFromFrontend;

public interface OrderService {

    OrderDTO saveOrder(OrderDTOFromFrontend orderDTOFromFrontend);
}
