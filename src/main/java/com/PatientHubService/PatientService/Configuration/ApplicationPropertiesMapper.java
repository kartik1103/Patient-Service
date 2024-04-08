package com.PatientHubService.PatientService.Configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:${environment}-api.properties"})
@Getter
public class ApplicationPropertiesMapper {

    @Value("${db_userid}")
    private String userId;

    @Value("${db_password")
    private String password;

}
