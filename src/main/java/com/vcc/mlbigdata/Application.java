package com.vcc.mlbigdata;

import com.vcc.mlbigdata.layer.infrastructure.JdbcConnection;
import com.vcc.mlbigdata.layer.infrastructure.ResponseRepository;
import com.vcc.mlbigdata.layer.presentation.controller.API;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.sql.Connection;

import static com.vcc.mlbigdata.layer.infrastructure.JdbcConnection.getJdbcConnection;

public class Application {
    public static void main(String[] args) throws Exception {
        /*
        final String url = "http://localhost:" + 8080;
        URI uri = URI.create(url);
        ResourceConfig serverConfig = new ResourceConfig(API.class);

        Server server = JettyHttpContainerFactory.createServer(uri, serverConfig, false);

        try {
            server.start();
            server.join();
        }
        finally{
            server.stop();
        }
    }
         */

        Connection conn = getJdbcConnection();
        if (conn != null){
            System.out.println("Connected MySQL");
        } else System.out.println("Connection failed");
        ResponseRepository response = new ResponseRepository();
        response.getAccountID(10);
        System.exit(0);
    }

}


// API -call-> service, service -call-> reposotory