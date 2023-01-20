package com.meshgroup.demo.util;

import org.testcontainers.containers.PostgreSQLContainer;

public class MeshGroupDemoSqlContainer extends PostgreSQLContainer<MeshGroupDemoSqlContainer> {
    private static final String IMAGE_VERSION = "postgres:latest";

    private static MeshGroupDemoSqlContainer container;


    private MeshGroupDemoSqlContainer() {
        super(IMAGE_VERSION);
    }

    public static MeshGroupDemoSqlContainer getInstance() {
        if (container == null) {
            container = new MeshGroupDemoSqlContainer();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() { }

}
