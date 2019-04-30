package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author AxeLai
 * @date 2019-04-29 09:31
 */
@Controller
public class IndexPageConfig {

    @RequestMapping("/")
    public RedirectView ws() {
        return new RedirectView("/websocket1.html");
    }
}
