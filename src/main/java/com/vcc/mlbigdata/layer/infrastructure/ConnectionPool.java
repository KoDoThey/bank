package com.vcc.mlbigdata.layer.infrastructure;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
    private static HikariConfig hikariConfig = new HikariConfig();
    private static HikariDataSource ds;
    static {
        //hikariConfig.setDriverClassName();
    }
}
