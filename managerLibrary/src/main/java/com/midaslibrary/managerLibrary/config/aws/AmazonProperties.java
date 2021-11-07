package com.midaslibrary.managerLibrary.config.aws;

abstract class AmazonProperties {

    private final String region;
    private final int connectionTimeout;
    private final int errorRetry;

    private final boolean disableCertSystemProperty;

    protected AmazonProperties(
            String region,
            int connectionTimeout,
            int errorRetry,
            boolean disableCertSystemProperty
    ) {
        this.region = region;
        this.connectionTimeout = connectionTimeout;
        this.errorRetry = errorRetry;
        this.disableCertSystemProperty = disableCertSystemProperty;
    }

    public String getRegion() {
        return region;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public int getErrorRetry() {
        return errorRetry;
    }

    public boolean isDisableCertSystemProperty() {
        return disableCertSystemProperty;
    }
}
