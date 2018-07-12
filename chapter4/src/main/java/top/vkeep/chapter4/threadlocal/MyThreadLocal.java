package top.vkeep.chapter4.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-12
 **/
public class MyThreadLocal<T> {

    // 使用同步Map:指令重排
    private Map<Thread, T> container = Collections.synchronizedMap(new HashMap<>());

    public void set(T value) {
        container.put(Thread.currentThread(), value);
    }

    public T get() {
        Thread thread = Thread.currentThread();
        T value = container.get(thread);

        if (value == null && !container.containsKey(thread)) {
            value = initialValue();
            container.put(thread, value);
        }

        return value;
    }

    public void remove() {
        container.remove(Thread.currentThread());
    }

    protected T initialValue() {
        return null;
    }
}
