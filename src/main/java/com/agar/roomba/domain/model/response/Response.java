package com.agar.roomba.domain.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This class represents a Response object sent back to user
 *
 * @param <T>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {

    private static final Logger logger = LoggerFactory.getLogger(Response.class);

    enum Status { OK, FAIL }

    private T coords;
    private int patches;
    private Status status;
    private String errors = "";

    public int getPatches() {
        return patches;
    }

    public Response setPatches(int patches) {
        this.patches = patches;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getCoords() {
        return coords;
    }

    public Response setCoords(T coords) {
        this.coords = coords;
        return this;
    }

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(Status.OK);
        return response;
    }

    public static <T> Response<T> fail() {
        Response<T> response = new ErrorResponse<>();
        response.setStatus(Status.FAIL);
        return response;
    }

    public String getErrors() {
        return errors;
    }

    public Response setErrors(String errors) {
        this.errors = errors;
        return this;
    }

    @Override
    public String toString() {
        return "Response { patches: " + getPatches()
                + ", coords: " + getCoords().toString() + " }";
    }
}
