package com.helpmate.helpmate.service;

import com.helpmate.helpmate.entity.Order;
import com.helpmate.helpmate.entity.Product;
import com.helpmate.helpmate.entity.User;
import com.helpmate.helpmate.exception.ResourceNotFoundException;
import com.helpmate.helpmate.payload.AddToCartDto;
import com.helpmate.helpmate.payload.OrderDto;
import com.helpmate.helpmate.payload.ProductDto;
import com.helpmate.helpmate.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    ProductService productService;

    @Autowired
    OrderRepository orderRepository;

    public void addToCart(AddToCartDto addToCartDto, User user) {
        //validate if product id is valid

        Product product = productService.findById(addToCartDto.getProductId());

        Order order = new Order();
        order.setUser(user);
        order.setProductList(order.getProductList());
        order.setPrice(order.getPrice());
        order.setCreatedDate(new Date());

        //save the cart
        orderRepository.save(order);
    }
    public OrderDto listCartItems(User user) {
        List<Order> productList = orderRepository.findAllByUserOrderByCreatedDateDesc(user);

        List<ProductDto> productItems= new ArrayList<>();
        double totalCost = 0;
        for (Order product: productList) {
            ProductDto productDto = new ProductDto(product);
            totalCost += productDto.getPrice();
            productItems.add(productDto);
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setPrice(totalCost);
        return orderDto;
    }

    public void deleteCartItem(Long productItemId,User user){
        //item id belongs to user

        Optional<Order> optionalOrder = orderRepository.findById(productItemId);

        if (optionalOrder.isEmpty()) {
            throw new ResourceNotFoundException("Product Id is invalid: " + productItemId);
        }

        Order order = optionalOrder.get();

        orderRepository.delete(order);
    }
}
