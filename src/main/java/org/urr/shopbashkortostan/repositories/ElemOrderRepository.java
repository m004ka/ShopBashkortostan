package org.urr.shopbashkortostan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.urr.shopbashkortostan.models.ElemOrder;
@Repository
public interface ElemOrderRepository extends JpaRepository<ElemOrder, Long> {
}
