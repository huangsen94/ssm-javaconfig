package com.common;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hs on 2016/12/8.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean(initMethod = "init")
    MessageService mockMessageService() {
      return new MessageService() {
          public String getMessage() {
              return "Hello World!";
          }

          private void init() {
              System.out.println("init...");
          }
      };
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
        context.register(Application.class);
        context.refresh();
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }

}
