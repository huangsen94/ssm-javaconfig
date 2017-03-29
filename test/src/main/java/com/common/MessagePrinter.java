package com.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hs on 2016/12/8.
 */
@Component
public class MessagePrinter {

    @Autowired(required = false)
    private MessageService messageService;

    public void printMessage() {
        System.out.println(this.messageService.getMessage());
    }
}
