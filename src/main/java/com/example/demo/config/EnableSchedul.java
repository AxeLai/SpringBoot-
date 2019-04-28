package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Date;
/**
 * @author AxeLai
 * @date 2019-04-28 12:38
 * 定时器任务
 */
@Configuration
@EnableScheduling
public class EnableSchedul {
//    /**
//     * 每2秒执行一次
//     */
//    @Scheduled(cron = "0 0/2 * * * ?")
//    public void testScheduling1(){
//        System.out.println("定时器任务1:"+ new Date());
//
//    }
//    //每天0点执行
//    @Scheduled(cron = "0 0 0 * * ?")
//    public void testScheduling2(){
//        System.out.println("定时器任务2:"+ new Date());
//
//    }
}
