package com.duelgenji.hybridSpring.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("user")
public class SqlController {

    @Autowired
    private HybridUserRepository hybridUserRepository;

    @Autowired
    private AirUserRepository airUserRepository;

    @RequestMapping("list")
    public Map<String, Object> userList() {

        Map<String, Object> res = new HashMap<>();

        res.put("success",1);
        res.put("list",hybridUserRepository.findAll());
        return res;

    }


    @RequestMapping("add")
    public Map<String, Object> add(@RequestParam String name) {

        Map<String, Object> res = new HashMap<>();

        HybridUser hybridUser = new HybridUser();
        hybridUser.setUserName(name);
        hybridUserRepository.save(hybridUser);

        res.put("success",1);
        return res;

    }

    @RequestMapping("air")
    public Map<String, Object> addAir(@RequestParam String name) {

        Map<String, Object> res = new HashMap<>();

        AirUser airUser = new AirUser();
        airUser.setName(name);
        airUserRepository.save(airUser);

        res.put("success",1);
        return res;

    }


}
