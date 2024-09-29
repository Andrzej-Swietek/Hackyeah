package com.hackyeah2024.feed.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataCollectionService {

    @Scheduled(cron = "0 0 * * * ?") // Każdą godzinę
    public void collectData() {
        // Pobieranie danych z users, companies, NGOs
    }
}
