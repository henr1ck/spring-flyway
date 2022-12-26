package br.edu.ifpi.springflyway;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplicationContext {

    public static void main(String[] args){
        ConfigurableApplicationContext context = new SpringApplicationBuilder(MyApplicationContext.class)
                .web(WebApplicationType.NONE)
                .run(args);

    }
}
