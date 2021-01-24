package cn.liuhp.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 20:33
 */
public class AsyncEventBusPublisher {

    private static final AsyncEventBus asyncEventBus = new AsyncEventBus("test", Executors.newFixedThreadPool(5));

    public static void register(Object bean) {
        asyncEventBus.register(bean);
    }

    public static void postEvent(Object event) {
        asyncEventBus.post(event);
    }

}
