package com.example.demo.controller;

import com.example.demo.model.WiselyMessage;
import com.example.demo.model.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author AxeLai
 * @date 2019-04-29 09:08
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")//1@MessageMapping和@RequestMapping功能类似，用于设置URL映射地址，浏览器向服务器发起请求，需要通过该地址。
    @SendTo("/topic/getResponse")//2如果服务器接受到了消息，就会对订阅了@SendTo括号中的地址传送消息
    public WiselyResponse say(WiselyMessage message) throws Exception {
        return new WiselyResponse("你好, " + message.getName() + "!");
    }

}
