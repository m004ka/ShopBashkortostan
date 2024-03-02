package org.urr.shopbashkortostan.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.CartStove;

@Repository
public interface CartPlateRepository extends JpaRepository<CartStove, Long> {
}
