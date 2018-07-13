package top.vkeep.smart.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.vkeep.smart.annotation.Transaction;
import top.vkeep.smart.helper.DatabaseHelper;

import java.lang.reflect.Method;

/**
 * 事务代理
 * <p>@author: zhourl(zhouronglv@gmail.com)
 * <p>@description: keep
 * <p>@since: v1.1
 * <p>@date: 2018-07-13
 **/
public class TransactionProxy implements Proxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);

    private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return false;
        }
    };


    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;
        boolean flag = FLAG_HOLDER.get();
        Method method = proxyChain.getTargetMethod();
        if (!flag && method.isAnnotationPresent(Transaction.class)) {
            FLAG_HOLDER.set(true);
            try {
                DatabaseHelper.beginTransaction();
                LOGGER.debug("begin transaction");
                result = proxyChain.doProxyChain();
                DatabaseHelper.commitTransaction();
                LOGGER.debug("commit transaction");
            } catch (Exception e) {
                DatabaseHelper.rollbackTransaction();
                LOGGER.debug("rollback transaction");
                throw e;
            } finally {
                FLAG_HOLDER.remove();
            }

        } else {
            result = proxyChain.doProxyChain();
        }
        return result;
    }
}
