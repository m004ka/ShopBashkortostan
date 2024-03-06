package org.urr.shopbashkortostan.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.urr.shopbashkortostan.models.Plate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartPlateRepository extends JpaRepository<Plate, Long> {
    List<Plate> findAllByHeightAndSize(float height, Plate.Size size);
    List<Plate> findAllByHeight(float height);

    List<Plate> findAllBySize(Plate.Size size);

    List<Plate> findAllByDensity(int density);





    Plate findCartStoveByPriceAndDensityAndHeightAndText(BigDecimal price, int density, float height, String Text);
    Optional<Plate>findCartStoveByHeight(float height);

}
