package com.jeekite.sys;

import com.jeekite.common.utils.IdWorker;
import com.jeekite.common.utils.JwtUtil;
import com.jeekite.sys.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;


import java.net.InetAddress;
import java.net.UnknownHostException;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.jeekite.sys.mapper")
@EnableSwagger2
public class SysApplication {
    private static Logger log= LoggerFactory.getLogger(SysApplication.class);
    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(SysApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Jeekite-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger-UI: \t\thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1,1);
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
    @Bean
    public RedisUtil redisUtil(){
        return new RedisUtil();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
