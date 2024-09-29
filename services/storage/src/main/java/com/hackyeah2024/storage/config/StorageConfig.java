package com.hackyeah2024.storage.config;

import com.hackyeah2024.storage.fileStorage.FileSystemStorage;
import com.hackyeah2024.storage.fileStorage.S3Storage;
import com.hackyeah2024.storage.fileStorage.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class StorageConfig {


    @Bean
    @Profile("local")
    public Storage localStorage() {
        return new FileSystemStorage();
    }

    @Bean
    @Profile("s3")
    public Storage s3Storage() {
        return new S3Storage(); // TODO: Implement S3Storage class
    }

}
