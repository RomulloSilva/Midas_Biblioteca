package com.midaslibrary.managerLibrary.config.aws;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.client.builder.AwsClientBuilder;


import static com.amazonaws.SDKGlobalConfiguration.DISABLE_CERT_CHECKING_SYSTEM_PROPERTY;
import static java.lang.String.valueOf;

public class AmazonConfiguration {

    private static final String LOCAL_PROXY_HOST = "127.0.0.1";
    private static final String LOCAL_ENDPOINT = "http://127.0.0.1:4566";

    private final AmazonProperties properties;

    AmazonConfiguration(AmazonProperties properties) {
        this.properties = properties;
        checkSystemProperty();
    }

    private void checkSystemProperty() {
        System.setProperty(DISABLE_CERT_CHECKING_SYSTEM_PROPERTY, valueOf(getProperties().isDisableCertSystemProperty()));
    }

    protected AmazonProperties getProperties() {
        return properties;
    }

    protected ClientConfiguration clientConfigurationLocalStack() {
        return clientConfigurationEnviroment()
                .withNonProxyHosts(LOCAL_PROXY_HOST);
    }

    protected ClientConfiguration clientConfigurationEnviroment() {
        return new ClientConfiguration()
                .withMaxErrorRetry(properties.getErrorRetry())
                .withConnectionTimeout(properties.getConnectionTimeout())
                .withUseExpectContinue(true);
    }

    protected AwsClientBuilder.EndpointConfiguration endpointConfigurationLocalStack() {
        return new AwsClientBuilder.EndpointConfiguration(LOCAL_ENDPOINT, properties.getRegion());
    }
}
