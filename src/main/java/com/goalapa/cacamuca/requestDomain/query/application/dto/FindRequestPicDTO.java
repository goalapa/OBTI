package com.goalapa.cacamuca.requestDomain.query.application.dto;

public class FindRequestPicDTO {

    private int requestNo;
    private String requestURL;

    public FindRequestPicDTO(int requestNo, String requestURL) {
        this.requestNo = requestNo;
        this.requestURL = requestURL;
    }

    public int getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(int requestNo) {
        this.requestNo = requestNo;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    @Override
    public String toString() {
        return "FindRequestPicDTO{" +
                "requestNo=" + requestNo +
                ", requestURL=" + requestURL +
                '}';
    }

}
