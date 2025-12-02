package com.fitness.ai_service.repository;

import com.fitness.ai_service.model.Recommendations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationRepository extends MongoRepository<Recommendations, String> {
    List<Recommendations> findByUserId(String userId);

    Optional<Recommendations> findByActivityId(String activityId);
}
