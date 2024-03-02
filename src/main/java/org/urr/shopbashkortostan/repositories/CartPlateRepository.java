package org.urr.shopbashkortostan.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.CartStove;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartPlateRepository extends JpaRepository<CartStove, Long> {
    List<CartStove> findAllByHeightAndSize(float height, CartStove.Size size);
    List<CartStove> findAllByHeight(float height);

    List<CartStove> findAllBySize(CartStove.Size size);

    List<CartStove> findAllByDensity(int density);





    CartStove findCartStoveByPriceAndDensityAndHeightAndText(BigDecimal price, int density, float height, String Text);
    Optional<CartStove>findCartStoveByHeight(float height);

}
