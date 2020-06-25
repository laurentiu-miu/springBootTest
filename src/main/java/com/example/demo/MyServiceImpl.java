package com.example.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
/**
 * Created by LaurentiuM on 25/06/2020.
 */
@Service
public class MyServiceImpl {
  @EventListener(ApplicationReadyEvent.class)
  public void doStuff(){
    int count = 0;
    while(true){
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(count++);
    }
  }
}
