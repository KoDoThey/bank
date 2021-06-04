package com.vcc.mlbigdata.layer.presentation.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vcc.mlbigdata.layer.application.service.AccountAction;
import com.vcc.mlbigdata.layer.infrastructure.ResponseRepository;
import com.vcc.mlbigdata.layer.infrastructure.Strings;
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
    public Response getSelect(@PathParam("accountID") long accountID) throws JSONException{

        return null;
    }

    @POST
    @Path("/createuser/")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response createUser(String jsonParam,
                               @PathParam("accountID") long accountID,
                               @PathParam("accountName") String accountName) throws Exception {
        if (Strings.isNullOrEmptyString(jsonParam)){
            throw new ClientException("Invalid request format");
        }
        try {
            ResponseRepository response = new ResponseRepository();
            if (response.getAccountID(accountID) != null){
                throw new ClientException("Account ID is existed!");
            }

        } catch (ClientException e) {
            e.printStackTrace();
        }

        return null;
    }
}



















