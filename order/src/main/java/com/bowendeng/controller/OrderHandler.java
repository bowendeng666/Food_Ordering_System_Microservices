package com.bowendeng.controller;

import com.bowendeng.entity.Order;
import com.bowendeng.entity.OrderVO;
import com.bowendeng.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAlByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(index, limit, uid));
        return orderVO;
    }

}
