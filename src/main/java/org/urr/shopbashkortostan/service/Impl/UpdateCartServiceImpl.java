package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.dto.CartForm;
import org.urr.shopbashkortostan.models.Plate;
import org.urr.shopbashkortostan.repositories.CartPlateRepository;
import org.urr.shopbashkortostan.service.interfaces.UpdateCartService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateCartServiceImpl implements UpdateCartService {
    public final CartPlateRepository cartPlateRepository;
    @Override
    public void updateCart(CartForm cartForm, CartForm cartFormNew) {
        Optional<Plate> cart = Optional.of(cartPlateRepository.findCartStoveByPriceAndDensityAndHeightAndText(cartForm.getPrice(), cartForm.getDensity(), cartForm.getHeight(), cartForm.getText()));

    }
}
