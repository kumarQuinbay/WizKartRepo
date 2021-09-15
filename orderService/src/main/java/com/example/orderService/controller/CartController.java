package com.example.orderService.controller;


import com.example.orderService.dto.CartDTO;
import com.example.orderService.entity.Cart;
import com.example.orderService.service.CartSerivce;
import com.example.orderService.service.OrderSerivce;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "order/cart/db")
public class CartController {

    @Autowired
    OrderSerivce orderSerivce;

    @Autowired
    CartSerivce cartService;

    @GetMapping("/display")
    public String display(){
        return "Cart Display";
    }

    @PostMapping
    public CartDTO save(@RequestBody CartDTO cartDto){
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDto,cart);
        cartService.save(cart);
        return cartDto;

    }

    @GetMapping(value = "/get/{id}")
    public CartDTO get(@PathVariable(name = "id") Long id){

        CartDTO cartDto = new CartDTO();
        Cart cart = cartService.get(id);

        BeanUtils.copyProperties(cart,cartDto);
        return cartDto;



    }

    @PutMapping(value="/update")
    public CartDTO update(@RequestBody CartDTO cartDto){
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDto,cart);
        cartService.save(cart);
        return cartDto;

    }

    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id){
        cartService.delete(id);

    }

    @DeleteMapping(value="/deleteByUserId/{userId}")
    public void deleteByUserId(@PathVariable(name = "userId") long userId){
        cartService.deleteByUserId(userId);

    }

    @GetMapping(value="/findByUserId/{userId}")
    public List<CartDTO> findByUserId(@PathVariable(name = "userId") long userId){

        List<Cart> cartList = cartService.findByUserId(userId);

        List<CartDTO> cartDtoList = new ArrayList<CartDTO>();
        for(Cart c: cartList){
            CartDTO cartDto = new CartDTO();
            BeanUtils.copyProperties(c,cartDto);
            cartDtoList.add(cartDto);

        }

        return cartDtoList;
    }

}
