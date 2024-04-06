package org.urr.shopbashkortostan.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.urr.shopbashkortostan.dto.FeedbackDTO;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Feedback;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.repositories.FeedBackRepository;


import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@Service
public class FeedbackService {

    private final FeedBackRepository feedBackRepository;
    public void createFeedback(FeedbackDTO feedbackDTO, Account account, Product product){
        Date currentDateAndTime = new Date();
        Feedback feedback = Feedback.builder()
                .account(account)
                .text(feedbackDTO.getText())
                .product(product)
                .rating(feedbackDTO.getRating())
                .date(currentDateAndTime)
                .build();

    }
    public Feedback getLastFeedback(Product product){
        return feedBackRepository.findFirstByProduct(product).orElseThrow(() -> new RuntimeException("Отзыв не найден"));
    }
    public List<Feedback> allFeedbackByProduct(Product product){
        return feedBackRepository.findAllByProduct(product);
    }

    public Feedback updateFeedback(Long id, FeedbackDTO feedbackDTO){
        Date currentDateAndTime = new Date();
       Feedback feedback = feedBackRepository.findFeedbackById(id).orElseThrow(() -> new RuntimeException("Отзыв не найден"));
       feedback.setText(feedbackDTO.getText());
       feedback.setDate(currentDateAndTime);
       feedback.setRating(feedbackDTO.getRating());

       return feedBackRepository.save(feedback);
    }

    public void deleteFeedback(Feedback feedback){
        feedBackRepository.delete(feedback);
    }
}
