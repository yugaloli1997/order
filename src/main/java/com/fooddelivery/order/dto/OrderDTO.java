package com.fooddelivery.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer userId;
    private Restaurant restaurant;
    private List<FoodItemsDTO> foodItemsList;
    private UserDTO user;
}
