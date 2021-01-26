package cn.liuhp.springevent;

import cn.liuhp.BaseTest;
import cn.liuhp.springevent.event.CustomEvent;
import cn.liuhp.springevent.event.SpringCustomEvent;
import cn.liuhp.springevent.event.SpringSubCustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 11:17
 */
@Slf4j
public class SpringEventTest extends BaseTest {

    @Autowired
    private SpringPublisher springPublisher;

    private Executor executor = Executors.newFixedThreadPool(10);
    /**
     *  发布ApplicationEvent体系的自定义事件
     */
    @Test
    public void testSpringPush() {
        SpringCustomEvent event = new SpringCustomEvent(this);
        springPublisher.pushEvent(event);
    }

    /**
     *  发布ApplicationEvent体系的自定义子事件
     */
    @Test
    public void testSpringPushSub() {
        SpringSubCustomEvent springSubCustomEvent = new SpringSubCustomEvent(this);
        springPublisher.pushEvent(springSubCustomEvent);
    }

    /**
     *  发布非ApplicationEvent体系的自定义事件
     */
    @Test
    public void testSpringPushCustom() {
        CustomEvent customEvent = new CustomEvent();
        springPublisher.pushEvent(customEvent);
        log.info("发布时间完成");
    }

    /**
     *  发布ApplicationEvent体系的自定义事件
     */
    @Test
    public void testSpringPushBase() {
        ApplicationEvent event = new ApplicationEvent(this) {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        };
        springPublisher.pushEvent(event);
    }


    @Test
    public void testMultiThreadPostEvent() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                SpringCustomEvent event = new SpringCustomEvent(this);
                springPublisher.pushEvent(event);
            });
        }
        Thread.sleep(Integer.MAX_VALUE);
        log.info("完成发布");
    }
}
