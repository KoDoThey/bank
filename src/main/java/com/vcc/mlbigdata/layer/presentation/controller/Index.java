package com.vcc.mlbigdata.layer.presentation.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class Index {
    @GET
    @Produces("text/plain")
    public String index(){
        return ("Welcome to Bank Test Application");
    }
}
