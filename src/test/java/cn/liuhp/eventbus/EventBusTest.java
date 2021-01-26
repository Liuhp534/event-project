package cn.liuhp.eventbus;

import cn.liuhp.BaseTest;
import cn.liuhp.eventbus.event.GuavaEvent;
import cn.liuhp.eventbus.event.GuavaSubEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 20:56
 */
@Slf4j
public class EventBusTest extends BaseTest {


    private Executor executor = Executors.newFixedThreadPool(10);

    @Test
    public void testPostEvent() {
        GuavaEvent guavaEvent = new GuavaEvent();
        EventBusPublisher.postEvent(guavaEvent);
        log.info("完成发布");
    }

    @Test
    public void testMultiThreadPostEvent() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                GuavaEvent guavaEvent = new GuavaEvent();
                EventBusPublisher.postEvent(guavaEvent);
            });
        }
        Thread.sleep(Integer.MAX_VALUE);
        log.info("完成发布");
    }


    @Test
    public void testPostSubEvent() {
        GuavaSubEvent guavaEvent = new GuavaSubEvent();
        EventBusPublisher.postEvent(guavaEvent);
    }

    @Test
    public void testAsyncPostEvent() {
        GuavaEvent guavaEvent = new GuavaEvent();
        AsyncEventBusPublisher.postEvent(guavaEvent);
        log.info("完成发布");
    }
}
