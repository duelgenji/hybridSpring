package com.duelgenji.hybridSpring.mongodb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("mongo")
public class MongoController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("list")
    public Map<String, Object> userList() {

        Map<String, Object> res = new HashMap<>();
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Joe", 34));
        personList.add(new Person("Mike", 25));
        personRepository.insert(personList);
        res.put("success",1);
        return res;

    }



}
