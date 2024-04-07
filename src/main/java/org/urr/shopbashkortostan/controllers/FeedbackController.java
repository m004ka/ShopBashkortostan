package org.urr.shopbashkortostan.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.urr.shopbashkortostan.dto.FeedbackDTO;
import org.urr.shopbashkortostan.models.Account;
import org.urr.shopbashkortostan.models.Feedback;
import org.urr.shopbashkortostan.models.Product;
import org.urr.shopbashkortostan.repositories.FeedBackRepository;
import org.urr.shopbashkortostan.repositories.ProductRepository;
import org.urr.shopbashkortostan.service.Impl.AccountService;
import org.urr.shopbashkortostan.service.Impl.FeedbackService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final AccountService accountService;
    private final FeedbackService feedbackService;
    private final ProductRepository productRepository;
    private final FeedBackRepository feedBackRepository;


    @PostMapping("/create/{id}")
    public void createFeedback(Authentication authentication, FeedbackDTO feedbackDTO, @PathVariable Long id){
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        Product product = productRepository.getProductById(id).orElseThrow(() -> new RuntimeException("Товар не найден"));
        feedbackService.createFeedback(feedbackDTO, account, product);
    }

    @GetMapping("/getLastFeedbackByProduct/{id}")
    public Feedback getLastFeedback(@PathVariable Long id){
        Product product = productRepository.getProductById(id).orElseThrow(() -> new RuntimeException("Товар не найден"));
        return feedbackService.getLastFeedback(product);
    }

    @GetMapping("/getAllFeedbackByProduct/{id}")
    public List<Feedback> allFeedbackByProduct(@PathVariable Long id){
        Product product = productRepository.getProductById(id).orElseThrow(() -> new RuntimeException("Товар не найден"));
        return feedbackService.allFeedbackByProduct(product);
    }

    @PutMapping("/update/{id}")
    public Feedback updateFeedback(Authentication authentication, @PathVariable Long id, FeedbackDTO feedbackDTO){
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        Feedback feedback = feedBackRepository.findFeedbackById(id).orElseThrow(()-> new RuntimeException("Отзыв не найден"));
        if(Objects.equals(feedback.getAccount().getId(), account.getId())){
           return feedbackService.updateFeedback(id, feedbackDTO);
        }else {
            throw  new RuntimeException("Не твой отзыв");
        }

    }

    @DeleteMapping("/delete/{id}")
    public void deleteFeedback(Authentication authentication, @PathVariable Long id){
        Account account = accountService.getAccountFromAuthentication(authentication).orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
        Feedback feedback = feedBackRepository.findFeedbackById(id).orElseThrow(()-> new RuntimeException("Отзыв не найден"));
        if(Objects.equals(feedback.getAccount().getId(), account.getId())){
             feedbackService.deleteFeedback(feedback);
        }else {
            throw  new RuntimeException("Не твой отзыв");
        }
    }


}
