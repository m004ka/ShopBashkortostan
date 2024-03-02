package org.urr.shopbashkortostan.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.urr.shopbashkortostan.dto.CartForm;
import org.urr.shopbashkortostan.service.interfaces.CreateNewCartService;
import org.urr.shopbashkortostan.service.interfaces.DeleteCartService;

@RestController
@RequestMapping("/createCard")
@RequiredArgsConstructor
public class CartPlateController {
    CreateNewCartService createNewCartService;
    DeleteCartService deleteCartService;

    @PostMapping("/newCart")
    ResponseEntity<?> CreateCart(CartForm cartForm){
        createNewCartService.CreateCart(cartForm);
        return ResponseEntity.ok("Success body");
    }
    @PostMapping("/deleteCart")
    ResponseEntity<?> DeleteCart(CartForm cartForm){ //Да да я знаю что это колхоз
        boolean res = deleteCartService.DeleteCart(cartForm);
        if (res){
            return ResponseEntity.ok("Success body");
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
