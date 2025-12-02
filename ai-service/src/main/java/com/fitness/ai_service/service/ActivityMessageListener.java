package com.fitness.ai_service.service;

import com.fitness.ai_service.model.Activity;
import com.fitness.ai_service.model.Recommendations;
import com.fitness.ai_service.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {

    private final ActivityAIService aiService;

    private final RecommendationRepository recommendationRepository;

    @RabbitListener(queues = "activity.queue")
    private void processActivity(Activity activity){
        log.info("Received activity for processing: {}", activity.getId());
        //log.info("Generated Recommendation : {}", aiService.generateRecommendation(activity));
       Recommendations recommendation = aiService.generateRecommendation(activity);
       recommendationRepository.save(recommendation);
    }
}
