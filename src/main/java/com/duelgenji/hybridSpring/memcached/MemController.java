package com.duelgenji.hybridSpring.memcached;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("mem")
public class MemController {

    @Autowired
    private XmemcachedUtils<String> xmemcachedUtils;

    @RequestMapping("")
    public Map<String, Object> get(@RequestParam String key) {

        Map<String, Object> res = new HashMap<>();

        res.put("success",1);
        res.put("value",xmemcachedUtils.get(key));
        return res;

    }


    @RequestMapping(value = "set",method = RequestMethod.GET)
    public Map<String, Object> set(@RequestParam String key, @RequestParam String value) {

        Map<String, Object> res = new HashMap<>();

        xmemcachedUtils.set(key, value);
        res.put("success",1);
        return res;

    }


}
