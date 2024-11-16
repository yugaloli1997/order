package com.fooddelivery.order.entity;

import com.fooddelivery.order.dto.FoodItemsDTO;
import com.fooddelivery.order.dto.Restaurant;
import com.fooddelivery.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    @Id
    private Integer userId;
    private Restaurant restaurant;
    private List<FoodItemsDTO> foodItemsList;
    private UserDTO user;
}
