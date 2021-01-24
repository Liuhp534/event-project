package cn.liuhp.springevent.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.Executors;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 14:18
 */
@Configuration
public class CustomMulticasterConfiguration {


    @Bean
    public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster(ApplicationContext applicationContext) {

        SimpleApplicationEventMulticaster simple =
                (SimpleApplicationEventMulticaster) applicationContext.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME);
        if (null == simple) {
            simple = new SimpleApplicationEventMulticaster();
        }
        simple.setErrorHandler(this.customErrorHandler());
        simple.setTaskExecutor(Executors.newFixedThreadPool(5));
        return simple;
    }

    @Bean
    public CustomErrorHandler customErrorHandler() {
        return new CustomErrorHandler();
    }

}
