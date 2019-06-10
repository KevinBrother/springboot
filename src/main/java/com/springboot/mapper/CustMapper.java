package com.springboot.mapper;

import com.springboot.modal.Cust;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

// @Mapper   //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface CustMapper {

    Cust find(Long id);

    List<Cust> getAllCust();

    List<Map> findByMap(Map<String, Long> map);

    Map findByCorpIdAndName(
            @Param(value = "corpId") Long corpId,
            @Param(value = "name") String name);
}
