package com.piper.valley.viewmodels;

import com.piper.valley.models.domain.Order;
import com.piper.valley.models.domain.Role;
import com.piper.valley.models.domain.Store;
import com.piper.valley.models.domain.User;
import com.piper.valley.models.service.OrderService;
import com.piper.valley.models.service.StoreService;
import com.piper.valley.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

@Component
public class ProfileViewModel {
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    StoreService storeService;
    public HashMap<String,Object> create(Long userID)
    {
        HashMap<String, Object> model = new HashMap<>();
        Collection<Order> orders= orderService.getOrders(userID,true);
        User otherUser=userService.getUserById(userID).get(); //We don't have to check if it exists, we have already done this.
        Collection<Store> stores = null;
        if(otherUser.getRole().contains(Role.STORE_OWNER))
            stores=storeService.getAllAcceptedUserStores(otherUser.getStoreOwner().getId());
        model.put("orders",orders);
        model.put("otherUser",otherUser);
        model.put("stores",stores);
        return model;
    }
}