package com.piper.valley.models.service;

import com.piper.valley.forms.AddOrderForm;
import com.piper.valley.models.domain.Order;
import com.piper.valley.models.domain.StoreProduct;
import com.piper.valley.models.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface OrderService {
   Optional<Order>getOrderById(Long id);
   Order addOrder(User user, StoreProduct storeProduct, AddOrderForm addOrderForm);
}