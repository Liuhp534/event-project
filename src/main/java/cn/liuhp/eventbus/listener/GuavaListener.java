package cn.liuhp.eventbus.listener;

import cn.liuhp.eventbus.event.GuavaEvent;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 20:45
 */
@Slf4j
@Component
public class GuavaListener implements MessageProcessor<GuavaEvent> {


    @Override
    @Subscribe
    public void process(GuavaEvent event) {
        log.info("-----------收到事件={}", event.getClass().getSimpleName());
        int i = 1/0;
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("-----------收到事件完成={}", event.getClass().getSimpleName());
    }
}
