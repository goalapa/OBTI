package com.goalapa.cacamuca.requestDomain.command.application.dto;

public class RequestPicDTO {

    private int requestNo;
    private int requestURL;

    public RequestPicDTO(int requestNo, int requestURL) {
        this.requestNo = requestNo;
        this.requestURL = requestURL;
    }

    public int getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(int requestNo) {
        this.requestNo = requestNo;
    }

    public int getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(int requestURL) {
        this.requestURL = requestURL;
    }

    @Override
    public String toString() {
        return "RequestPicDTO{" +
                "requestNo=" + requestNo +
                ", requestURL=" + requestURL +
                '}';
    }
}
