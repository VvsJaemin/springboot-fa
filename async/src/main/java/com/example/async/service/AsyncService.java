package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class AsyncService {


    @Async("async-thread")
    public CompletableFuture run() throws InterruptedException {
        return new AsyncResult(hello()).completable();
    }


    public String hello() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            log.info("thread sleep ...");
        }

        return "async hello";
    }
}
