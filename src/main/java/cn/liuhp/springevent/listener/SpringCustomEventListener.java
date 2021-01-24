package cn.liuhp.springevent.listener;

import cn.liuhp.springevent.event.CustomEvent;
import cn.liuhp.springevent.event.SpringSubCustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @description:接收自定义类型的消息
 * @author: liuhp534
 * @create: 2021-01-24 11:32
 */
@Slf4j
@Component
public class SpringCustomEventListener {


    @EventListener(classes = CustomEvent.class )
    public void customListenerMethod(Object event) {
        log.info("-----------收到事件={}", event.getClass().getSimpleName());
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 1/0;

    }

}
