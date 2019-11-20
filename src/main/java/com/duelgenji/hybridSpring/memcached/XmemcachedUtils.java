package com.duelgenji.hybridSpring.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class XmemcachedUtils<T> {

    @Autowired
    private static MemcachedClient client;

    @Autowired
    private static MemcachedClient memcachedClient;

    public XmemcachedUtils() {
        {
            try {
                //多个节点，数组里是权重，如果数字不同则以大的优先
                MemcachedClientBuilder builder = new
                        XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11222 localhost:11211"),new int[]{1,1});
//                // 设置连接池大小，即客户端个数
//                builder.setConnectionPoolSize(50);
//                // 宕机报警
//                builder.setFailureMode(true);
                memcachedClient=builder.build();
//                client = new XMemcachedClient("localhost",11211);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public T get(String key){
        T obj = null;
        try {
            obj = memcachedClient.get(key);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
        return obj;
    }


    public void set(String key , T value){
        try {
            memcachedClient.set(key,3600,value);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MemcachedException e) {
            e.printStackTrace();
        }
    }
}
