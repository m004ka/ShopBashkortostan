package org.urr.shopbashkortostan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.urr.shopbashkortostan.models.Feedback;
import org.urr.shopbashkortostan.models.Product;

import java.util.List;
import java.util.Optional;

public interface FeedBackRepository extends JpaRepository<Feedback, Long> {

    Optional<Feedback> findFirstByProduct(Product product);

    List<Feedback> findAllByProduct(Product product);

    Optional<Feedback> findFeedbackById(Long id);
}
