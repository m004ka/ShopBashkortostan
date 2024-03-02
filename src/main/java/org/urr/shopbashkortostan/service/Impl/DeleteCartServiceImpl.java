package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.dto.CartForm;
import org.urr.shopbashkortostan.models.CartStove;
import org.urr.shopbashkortostan.repositories.CartPlateRepository;
import org.urr.shopbashkortostan.service.interfaces.DeleteCartService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteCartServiceImpl implements DeleteCartService {
    CartPlateRepository cartPlateRepository;
    @Override
    public boolean DeleteCart(CartForm cartForm) { // тут тоже знаю что колхоз)
        Optional<CartStove> cart = Optional.of(cartPlateRepository.findCartStoveByPriceAndDensityAndHeightAndText(cartForm.getPrice(), cartForm.getDensity(), cartForm.getHeight(), cartForm.getText()));

        if (cart.isPresent()){
            cartPlateRepository.delete(cart.get());
            return true;
        }
        else {
            return false;
        }
    }
}
