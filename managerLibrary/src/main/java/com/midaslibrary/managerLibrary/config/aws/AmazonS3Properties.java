package com.midaslibrary.managerLibrary.config.aws;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AmazonS3Properties extends AmazonProperties {

    private final String bucketName;
    private final long urlExpiration;

    public AmazonS3Properties(@Value("${aws.s3.region}") final String region,
                              @Value("${aws.s3.connectionTimeout}") final int connectionTimeout,
                              @Value("${aws.s3.errorRetry}") final int errorRetry,
                              @Value("${aws.s3.bucketName}") final String bucketName,
                              @Value("${aws.s3.url.expiration}") final long urlExpiration,
                              @Value("${aws.global.disableCertSystemProperties}") final boolean disableCertSystemProperties){
        super(region, connectionTimeout, errorRetry, disableCertSystemProperties);
        this.bucketName = bucketName;
        this.urlExpiration= urlExpiration;
    }
}
