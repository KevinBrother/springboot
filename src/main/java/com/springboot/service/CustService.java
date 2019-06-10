package com.springboot.service;


import com.springboot.modal.Cust;
import com.springboot.mapper.CustMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value = "custService")
public class CustService {

    @Resource
    private CustMapper custMapper;

    public List<Cust> getAllCust() {
        return custMapper.getAllCust();
    }

    public Cust find(Long id) {
        return custMapper.find(id);
    }

    public List<Map> findByMap(Map<String, Long> map) {
        return custMapper.findByMap(map);
    }

    public Map findByCorpIdAndName(Long corpId, String name) {
        return custMapper.findByCorpIdAndName(corpId, name);
    }
}
