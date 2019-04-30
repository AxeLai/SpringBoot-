package com.example.demo.model;

/**
 * @author AxeLai
 * @date 2019-04-29 09:06
 * 服务器向浏览器传送消息，用该类进行传送
 */
public class WiselyResponse {
    private String responseMessage;
    public WiselyResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage(){
        return responseMessage;
    }

}
