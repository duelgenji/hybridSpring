package com.duelgenji.Java;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

class CGlibHosee
{
    public String sayhi()
    {
        return "Welcome oschina hosee's blog";
    }

    public String sayNo(){
        return "Noooo";

    }
}

class CGlibHoseeProxy
{
    Object obj;

    public Object bind(final Object target)
    {
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(new MethodInterceptor()
        {
            @Override
            public Object intercept(Object obj, Method method, Object[] args,
                                    MethodProxy proxy) throws Throwable
            {
                System.out.println("I'm proxy!");
                Object res = method.invoke(target, args);
                return res;
            }
        });
        return enhancer.create();
    }

    public static void main(String[] args)
    {
        CGlibHosee cGlibHosee = new CGlibHosee();
        CGlibHoseeProxy cGlibHoseeProxy = new CGlibHoseeProxy();
        CGlibHosee proxy = (CGlibHosee) cGlibHoseeProxy.bind(cGlibHosee);
        System.out.println(proxy.sayhi());
        System.out.println(proxy.sayNo());
    }
}
