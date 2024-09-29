package com.hackyeah2024.feed.feed;

import org.springframework.stereotype.Service;
import recommender.RecommenderOuterClass;

@Service
public class RequesterMapper {
    public RecommenderOuterClass.RequesterType toRequesterType(String requester) {
        return switch (requester) {
            case "VOLUNTEER" -> RecommenderOuterClass.RequesterType.REQUESTER_VOLUNTEER;
            case "COMPANY" -> RecommenderOuterClass.RequesterType.REQUESTER_COMPANY;
            case "NGO" -> RecommenderOuterClass.RequesterType.REQUESTER_NGO;
            case null, default -> RecommenderOuterClass.RequesterType.REQUESTER_UNKNOWN;
        };
    }

    public String toString(RecommenderOuterClass.RequesterType requesterType) {
        return switch (requesterType){
            case REQUESTER_VOLUNTEER -> "VOLUNTEER";
            case REQUESTER_COMPANY -> "COMPANY";
            case REQUESTER_NGO -> "NGO";
            case null, default -> "UNRECOGNIZED";
        };
    }

    public RecommenderOuterClass.RequestedType toRequestedType(String requested) {
        return switch (requested) {
            case "VOLUNTEER" -> RecommenderOuterClass.RequestedType.REQUESTED_VOLUNTEER;
            case "COMPANY" -> RecommenderOuterClass.RequestedType.REQUESTED_COMPANY;
            case "NGO" -> RecommenderOuterClass.RequestedType.REQUESTED_NGO;
            case null, default -> RecommenderOuterClass.RequestedType.REQUESTED_UNKNOWN;
        };
    }

    public String toString(RecommenderOuterClass.RequestedType requestedType) {
        return switch (requestedType){
            case RecommenderOuterClass.RequestedType.REQUESTED_VOLUNTEER -> "VOLUNTEER";
            case RecommenderOuterClass.RequestedType.REQUESTED_COMPANY -> "COMPANY";
            case RecommenderOuterClass.RequestedType.REQUESTED_NGO -> "NGO";
            case null, default -> "UNRECOGNIZED";
        };
    }
}
