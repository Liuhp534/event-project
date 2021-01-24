package cn.liuhp.springevent.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-01-24 14:16
 */
@Slf4j

public class CustomErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        log.error("-----------自定义异常处理器", t);
    }
}
