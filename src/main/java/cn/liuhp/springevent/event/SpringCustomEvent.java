package cn.liuhp.springevent.event;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;

/**
 * @description: 自定义spring事件
 * @author: liuhp534
 * @create: 2021-01-24 10:40
 */
public class SpringCustomEvent extends ApplicationEvent {

    public SpringCustomEvent(Object source) {
        super(source);
    }

}
