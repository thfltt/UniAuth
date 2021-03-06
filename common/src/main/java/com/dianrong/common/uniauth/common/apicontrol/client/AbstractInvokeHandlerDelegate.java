package com.dianrong.common.uniauth.common.apicontrol.client;

import java.lang.reflect.Method;

/**
 * 模板方法，处理调用handler逻辑 
 * @author wanglin
 */
public abstract class AbstractInvokeHandlerDelegate implements InvokeHandlerDelegate {
    @Override
    public Object invoke(Object target, Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Throwable cause = null;
        beforeInvoke(target, proxy, method, args);
        try {
            result = doInvoke(target, proxy, method, args);
        } catch(Throwable t) {
            cause = t;
        } 
        return afterInvoke(target, proxy, method, args, result, cause);
    }
    
    /**
     * real method invoke
     * @param target target
     * @param proxy proxy
     * @param method method
     * @param args args
     * @return invoke result
     * @throws Throwable throwable
     */
    protected Object doInvoke(Object target, Object proxy, Method method, Object[] args) throws Throwable{
        return method.invoke(target, args);
    }
    
    public abstract void beforeInvoke(Object target, Object proxy, Method method, Object[] args);
    
    
    public abstract Object afterInvoke(Object target, Object proxy, Method method, Object[] args, Object result, Throwable cause) throws Throwable;
}
