package cn.liuhp.eventbus.listener;

public interface MessageProcessor<T> {

    void process(T t);
}
