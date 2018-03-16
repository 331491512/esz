package com.esuizhen.bigdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by fqc on 16/11/9.
 */

@SpringBootApplication
@ServletComponentScan
@EnableJpaRepositories(basePackages = {"com.esuizhen.bigdata.repository"})
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
