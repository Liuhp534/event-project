package cn.liuhp.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 10:46
 */
@Component
public class SpringPublisher {

    @Autowired
    private ApplicationContext applicationContext;


    public void pushEvent(Object event) {
        this.applicationContext.publishEvent(event);
    }

}
