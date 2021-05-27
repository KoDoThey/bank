package com.vcc.mlbigdata;

import com.vcc.mlbigdata.layer.presentation.controller.API;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Application {
    public static void main(String[] args) throws Exception {
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
}
// API -call-> service, service -call-> reposotory