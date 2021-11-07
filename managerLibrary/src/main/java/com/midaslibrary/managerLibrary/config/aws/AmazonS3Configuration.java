package com.midaslibrary.managerLibrary.config.aws;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class AmazonS3Configuration extends AmazonConfiguration {

    public AmazonS3Configuration(AmazonS3Properties properties) {
        super(properties);
    }

    @Bean
    @Profile("dev")
    public AmazonS3 amazonS3Client() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(getProperties().getRegion()))
                .withClientConfiguration(clientConfigurationEnviroment())
                .build();
    }

    @Bean
    @Primary
    @Profile("local")
    public AmazonS3 amazonS3ClientLocalStack() {
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(endpointConfigurationLocalStack())
                .withClientConfiguration(clientConfigurationLocalStack())
                .build();
    }
}
