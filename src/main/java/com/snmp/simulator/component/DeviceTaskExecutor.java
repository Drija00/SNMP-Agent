package com.snmp.simulator.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;

@Configuration
public class DeviceTaskExecutor {
    @Bean(name = "deviceRunTaskExecutor")
    public Executor deviceRunTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setQueueCapacity(50);
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setRejectedExecutionHandler(getRejectedExecutionHandler());
        executor.setThreadNamePrefix("device-snmp-");
        executor.initialize();

        return executor;
    }

    private RejectedExecutionHandler getRejectedExecutionHandler() {
        return (runnable, threadPoolExecutor) -> {
            try {
                threadPoolExecutor.getQueue().put(runnable);
            } catch (InterruptedException e) {
                throw new RejectedExecutionException("Unexpected InterruptedException while waiting to add Runnable to ThreadPoolExecutor queue...", e);
            }
        };
    }
}
