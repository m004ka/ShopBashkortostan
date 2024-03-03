package org.urr.shopbashkortostan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.urr.shopbashkortostan.dto.CartForm;
import org.urr.shopbashkortostan.service.interfaces.CreateNewCartService;
import org.urr.shopbashkortostan.service.interfaces.DeleteCartService;
import org.urr.shopbashkortostan.service.interfaces.UpdateCartService;

@RestController
@RequestMapping("/createCard")
@RequiredArgsConstructor
public class CartPlateController {
    CreateNewCartService createNewCartService;
    DeleteCartService deleteCartService;
    UpdateCartService updateCartService;

    @PostMapping("/newCart")
    ResponseEntity<?> createCart(CartForm cartForm){
        createNewCartService.CreateCart(cartForm);
        return ResponseEntity.ok("Success body");
    }
    @PostMapping("/deleteCart")
    ResponseEntity<?> deleteCart(CartForm cartForm){ //Да да я знаю что это колхоз
        boolean res = deleteCartService.DeleteCart(cartForm);
        if (res){
            return ResponseEntity.ok("Success body");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/updateCart")
    ResponseEntity<?> updateCart(CartForm cartForm, CartForm cartNewForm){
        updateCartService.updateCart(cartForm, cartNewForm);
        return ResponseEntity.ok("Success body");
    }
}
