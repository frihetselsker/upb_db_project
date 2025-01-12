package com.langlearning.crud.response;

import java.util.Objects;

public class Response {
    private int code;
    private String message;

    public Response(int code, String message){
        this.code = code;
        this.message = message;
    }

    public Response(int code){
        this.code = code;
        this.message = "";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Code=" + code +
                ", Message='" + message + "\'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Response response = (Response) o;
        return code == response.code && Objects.equals(message, response.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }
}
