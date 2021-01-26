package cn.liuhp.springevent.listener;

import cn.liuhp.springevent.event.SpringCustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: 接收SpringCustomEvent类型的消息
 * @author: liuhp534
 * @create: 2021-01-24 10:41
 */
@Slf4j
@Component
public class SpringCustomListener implements ApplicationListener<SpringCustomEvent> {


    @Override
    public void onApplicationEvent(SpringCustomEvent event) {
        //log.info("-----------收到事件={}", event.getClass().getSimpleName());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("-----------收到事件完成={}, threadName={}", event.getClass().getSimpleName(), Thread.currentThread().getName());
    }

}
