package com.helpmate.helpmate.controller;

import com.helpmate.helpmate.common.ApiResponse;
import com.helpmate.helpmate.entity.User;
import com.helpmate.helpmate.payload.AddToCartDto;
import com.helpmate.helpmate.payload.JWTAuthResponse;
import com.helpmate.helpmate.payload.OrderDto;
import com.helpmate.helpmate.security.JwtTokenProvider;
import com.helpmate.helpmate.service.AuthenticationService;
import com.helpmate.helpmate.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderpage")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private AuthenticationService authenticationService;

    //post order API

    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addtoCartDto,
                                                 @RequestParam("token") String token) {
        //authenticate token
        authenticationService.authenticate(token);

        //find the user

        User user = authenticationService.getUser(token);

        orderService.addToCart(addtoCartDto, user);

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }

    //get all order items for a user
    @GetMapping("/")
    public ResponseEntity<OrderDto> getCartItems(@RequestParam("token") String token){
        //authenticate the token
        authenticationService.authenticate(token);

        //find the user
        User user = authenticationService.getUser(token);

        //get cart items
        OrderDto orderDto =orderService.listCartItems(user);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }
    //delete all order items for a user
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Long itemId,
                                                      @RequestParam("token") String token) {
    //authenticate the token
    authenticationService.authenticate(token);
    //find the user
    User user = authenticationService.getUser(token);

    orderService.deleteCartItem(itemId, user);

    return new ResponseEntity<>(new ApiResponse(true, "item has been removed"), HttpStatus.OK);
    }
}
