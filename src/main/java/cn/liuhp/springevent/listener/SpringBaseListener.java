package cn.liuhp.springevent.listener;

import cn.liuhp.springevent.event.SpringSubCustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 11:22
 */
@Slf4j
@Component
public class SpringBaseListener {


    //@EventListener
    public void customListenerMethod(ApplicationEvent event) {
        log.info("-----------收到事件={}", event.getClass().getSimpleName());
    }

    @EventListener
    public void customListenerMethod(SpringSubCustomEvent event) {
        log.info("-----------收到事件={}", event.getClass().getSimpleName());
    }
}
