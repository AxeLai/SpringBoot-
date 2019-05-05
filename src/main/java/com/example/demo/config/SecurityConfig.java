package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author AxeLai
 * @date 2019-04-30 15:15
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Bean
    public PasswordEncoder passwordEncoder(){
        //当然，如果你有自己的加密方法，这个方法就写自己的加密方法好了
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置需要登入验证
//        http.formLogin()          // 定义当需要用户登录时候，转到的登录页面。
//                .and()
//                .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
//                .anyRequest()        // 任何请求,登录后可以访问
//                .authenticated();
    //配置需要登入验证的自定义配置
        http.formLogin()          // 定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login.html")      // 设置登录页面
                .loginProcessingUrl("/user/login") // 自定义的登录接口
                .and()
                .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html").permitAll()   // 设置所有人都可以访问登录页面
                .anyRequest()        // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();     // 关闭csrf防护

        //配置不需要登入验证
//        http.authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }
    //4
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder.encode("123")).roles("USER")//这里两个是分别账号和密码（账号：user1密码：123）
                .and()
                .withUser("user2").password(passwordEncoder.encode("123")).roles("USER");//这里两个是分别账号和密码（账号：user2密码：123）
    }
    //5忽略静态资源的拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
