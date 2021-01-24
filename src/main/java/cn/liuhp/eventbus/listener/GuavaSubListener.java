package cn.liuhp.eventbus.listener;

import cn.liuhp.eventbus.event.GuavaSubEvent;
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
public class GuavaSubListener implements MessageProcessor<GuavaSubEvent> {


    @Override
    @Subscribe
    public void process(GuavaSubEvent event) {
        log.info("-----------收到事件={}", event.getClass().getSimpleName());
    }
}
