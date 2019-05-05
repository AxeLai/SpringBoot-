package com.example.demo.controller;

import com.example.demo.model.WiselyMessage;
import com.example.demo.model.WiselyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

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
    @Autowired
    private SimpMessagingTemplate messagingTemplate;//1 SimpMessagingTemplate用于向浏览器发送信息。

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) { //2在spring mvc中，principal包含了登录用户的信息，在这里我们直接用。
        if (principal.getName().equals("user1")) {//3这里是一段写死的代码，如果登录的用户是dzz,那就将消息发送给zbb，大家根据自己的需求进行修改。通过convertAndSendToUser（）方法进行发送，第一个参数是信息接收的目标，第二个参数是要发送的地址，第三个参数是要发送的信息。
            messagingTemplate.convertAndSendToUser("user2",
                    "/queue/notifications", principal.getName() + "-send:"
                            + msg);
        } else {
            messagingTemplate.convertAndSendToUser("user1",
                    "/queue/notifications", principal.getName() + "-send:"
                            + msg);
        }
    }
}
