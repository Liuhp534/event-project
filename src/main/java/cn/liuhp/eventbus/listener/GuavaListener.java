package cn.liuhp.eventbus.listener;

import cn.liuhp.eventbus.event.GuavaEvent;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 20:45
 */
@Slf4j
@Component
public class GuavaListener implements MessageProcessor<GuavaEvent> {


    @Override
    @Subscribe
    @AllowConcurrentEvents
    public void process(GuavaEvent event) {
        //log.info("-----------收到事件={}, threadName={}", event.getClass().getSimpleName(), Thread.currentThread().getName());
        //int i = 1/0;
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("-----------收到事件完成={}, threadName={}", event.getClass().getSimpleName(), Thread.currentThread().getName());
    }
}
