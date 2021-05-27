package com.vcc.mlbigdata.layer.presentation.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.core.Response;

public class ResponseStatus {
    public static final int OK_STATUS = 1;
    public static final int ERROR_STATUS = 0;

    public static Response responseSuccess(String message) throws JSONException {
        JSONObject resStt = new JSONObject();
        resStt.put("status", OK_STATUS)
                .put("message", message)
                .put("code", Response.Status.OK.getStatusCode());
        return Response.ok().entity(resStt.toString()).build();
    }

    public static Response responseServerError(String message) throws JSONException {
        JSONObject resStt = new JSONObject();
        resStt.put("status", ERROR_STATUS)
                .put("message", message)
                .put("code", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
                .put("result", new JSONArray()); //?
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(resStt.toString()).build(); //?
    }

    public static Response responseClientError(String message) throws JSONException {
        JSONObject resStt = new JSONObject();
        resStt.put("status", ERROR_STATUS)
                .put("message", message)
                .put("code", Response.Status.BAD_REQUEST.getStatusCode())
                .put("result", new JSONObject());
        return Response.status(Response.Status.BAD_REQUEST).entity(resStt.toString()).build();
    }

}
