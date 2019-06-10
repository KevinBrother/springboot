package com.springboot.controller;


import com.springboot.modal.Cust;
import com.springboot.service.CustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/cust")
public class CustController {

    @Autowired
    private CustService custService;

    Logger logger = LoggerFactory.getLogger(CustController.class);

    @ResponseBody
    @RequestMapping("/getAllCust")
    public List<Cust> getAllCust() {
        List<Cust> users =  custService.getAllCust();

        return users;
    }

    @ResponseBody
    @RequestMapping("/find/{id}")
    // http://localhost:8080/cust/find/10
    // public Cust find(@PathVariable("id") Long id) {
    public Cust find(@PathVariable Long id) {

        Cust cust =  custService.find(id);

        return cust;
    }

    @ResponseBody
    @RequestMapping("/findByCorpIdAndName/{corpId}/{name}")
    // http://localhost:8080/cust/findByCorpIdAndName/1/曹俊杰
    public Map findByCorpIdAndName(@PathVariable Long corpId, @PathVariable String name) {

        Map map = custService.findByCorpIdAndName(corpId, name);

        return map;
    }

    @ResponseBody
    @RequestMapping("/findByCorpIdAndName")
    // http://localhost:8080/cust/findByCorpIdAndName?corpId=1&name=曹俊杰
    public Map findByCorpIdAndNameParam(@RequestParam("corpId") Long corpId, @RequestParam("name") String name) {

        Map map = custService.findByCorpIdAndName(corpId, name);

        return map;
    }

    @ResponseBody
    @RequestMapping("/findByMap/{condition}")
    // http://localhost:8080/cust/findByMap/condition;corpId=1;hotelId=0
    public List<Map> findByMap(@MatrixVariable(pathVar = "condition") Map<String, Long> map) {
        logger.info("===================== map =================" + map);
        List<Map> cust =  custService.findByMap(map);

        return cust;
    }


}
