package com.hackyeah2024.feed.recommender;

import com.hackyeah2024.feed.config.RecommenderClient;
import org.springframework.stereotype.Service;
import recommender.RecommenderOuterClass;

import java.util.List;

@Service
public class  RecommenderService {

    public List<String> getRecommendation(
            String userId,
            RecommenderOuterClass.RequesterType requesterType,
            RecommenderOuterClass.RequestedType requestedType
    ) {
        var recommenderClient = new RecommenderClient(
                userId, requesterType, requestedType
        );
        return recommenderClient.getRecommendations();
    }

    public  List<String> getNGORecommendation( String userId, RecommenderOuterClass.RequestedType requestedType ) {
        var recommenderClient = new RecommenderClient(
                userId,
                RecommenderOuterClass.RequesterType.REQUESTER_NGO,
                requestedType
        );
        return recommenderClient.getRecommendations();
    }

    public  List<String> getCompanyRecommendation( String userId, RecommenderOuterClass.RequestedType requestedType ) {
        var recommenderClient = new RecommenderClient(
                userId,
                RecommenderOuterClass.RequesterType.REQUESTER_COMPANY,
                requestedType
        );
        return recommenderClient.getRecommendations();
    }
}
