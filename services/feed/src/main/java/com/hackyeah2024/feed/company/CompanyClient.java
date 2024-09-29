package com.hackyeah2024.feed.company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@FeignClient(
        name = "company-service",
        url = "${application.config.company-url}"
)
public interface CompanyClient {

    @PostMapping("/api/v1/company/populate")
    Optional<List<CompanyDTO>> populateCompany(@RequestBody PopulateRequest requestBody);

    @PostMapping("/api/v1/ngo/populate")
    Optional<List<NgoDTO>> populateNgo(@RequestBody PopulateRequest requestBody);
}