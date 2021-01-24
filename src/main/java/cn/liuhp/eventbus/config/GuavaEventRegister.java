package cn.liuhp.eventbus.config;

import cn.liuhp.eventbus.AsyncEventBusPublisher;
import cn.liuhp.eventbus.EventBusPublisher;
import cn.liuhp.eventbus.listener.MessageProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 20:48
 */
@Slf4j
@Component
public class GuavaEventRegister implements SmartInitializingSingleton {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void afterSingletonsInstantiated() {
        Map<String, MessageProcessor> beanList = applicationContext.getBeansOfType(MessageProcessor.class);
        if (CollectionUtils.isEmpty(beanList)) {
            return;
        }
        for (Map.Entry<String, MessageProcessor> entry : beanList.entrySet()) {
            log.info("注册到eventBus注册表 {}", entry.getValue().getClass().getSimpleName());
            EventBusPublisher.register(entry.getValue());
            AsyncEventBusPublisher.register(entry.getValue());
        }
    }











}
