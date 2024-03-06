package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.dto.CartForm;
import org.urr.shopbashkortostan.models.Plate;
import org.urr.shopbashkortostan.repositories.CartPlateRepository;
import org.urr.shopbashkortostan.service.interfaces.CreateNewCartService;

@Service
@RequiredArgsConstructor
public class CreateNewCartServiceImpl implements CreateNewCartService {

    public final CartPlateRepository cartPlateRepository;
    @Override
    public void CreateCart(CartForm cartForm) {
        Plate cartStove = Plate.builder()
                .price(cartForm.getPrice()) //цена
                .brand(cartForm.getMark()) // Марка продукции
                .description(cartForm.getText()) //Описание
                .density(cartForm.getDensity()) //плотность
                .height(cartForm.getHeight()) // высота
                //.priceForMeterSquare(cartForm.getPrice()(cartForm.getHeight()*0.6))

                .build();

        cartPlateRepository.save(cartStove);
    }



}
