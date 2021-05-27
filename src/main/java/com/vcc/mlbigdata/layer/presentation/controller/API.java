package com.vcc.mlbigdata.layer.presentation.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;

@Path("/")
public class API {
    @GET
    @Path("/queryparam")
    @Produces("text/plain")
    public String queryParam(@QueryParam("page") Integer page,
                             @QueryParam("limit") String limit1) throws JSONException {
        return "This" + page + " & " + limit1 + "\n" + ResponseStatus.responseSuccess("a");
    }

    @GET
    @Path("/pathparam/{page}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response pathParam(@PathParam("page") int page) throws JSONException {
       return ResponseStatus.responseSuccess("page" + page);
    }

    @GET
    @Path("/select")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getSelect()  throws Exception{

        return null;
    }
}
