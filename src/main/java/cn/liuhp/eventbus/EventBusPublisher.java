package cn.liuhp.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 20:33
 */
public class EventBusPublisher {


    private static final EventBus eventBus = new EventBus(new CustomSubscriberExceptionHandler());

    public static void register(Object bean) {
        eventBus.register(bean);
    }

    public static void postEvent(Object event) {
        eventBus.post(event);
    }


    @Slf4j
    private static class CustomSubscriberExceptionHandler implements SubscriberExceptionHandler {

        @Override
        public void handleException(Throwable exception, SubscriberExceptionContext context) {
            log.info("----------------自定义异常处理 {}", exception);
        }
    }
}
