package com.example.kampusku.Kampus;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetKampus {

    String status;
    List<ResultKampus> result;
    String message;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<ResultKampus> getResult() {
        return result;
    }
}
