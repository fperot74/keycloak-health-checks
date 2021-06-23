package com.github.thomasdarimont.keycloak.healthchecker.spi.database;

import com.github.thomasdarimont.keycloak.healthchecker.spi.HealthIndicator;
import com.github.thomasdarimont.keycloak.healthchecker.spi.HealthIndicatorFactory;
import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class DatabaseHealthIndicatorFactory implements HealthIndicatorFactory {

    public static final String ID = "database-health";

    private Config.Scope config;

    @Override
    public HealthIndicator create(KeycloakSession session) {
        return new DatabaseHealthIndicator(session, config);
    }

    @Override
    public void init(Config.Scope config) {
        this.config = config;
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        //NOOP
    }

    @Override
    public void close() {
        //NOOP
    }

    @Override
    public String getId() {
        return ID;
    }
}
