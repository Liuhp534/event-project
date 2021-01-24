package cn.liuhp.springevent.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

/**
 * @description: 通过GenericApplicationListener方式实现监听
 * @author: liuhp534
 * @create: 2021-01-24 13:49
 */
@Slf4j
//@Component
public class SpringGenericApplicationListener implements GenericApplicationListener {

    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        return Boolean.TRUE;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("-----------收到事件={}", event.getClass().getSimpleName());
    }
}
