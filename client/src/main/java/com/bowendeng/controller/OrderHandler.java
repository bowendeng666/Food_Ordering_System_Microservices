package com.bowendeng.controller;

import com.bowendeng.entity.Menu;
import com.bowendeng.entity.Order;
import com.bowendeng.entity.OrderVO;
import com.bowendeng.entity.User;
import com.bowendeng.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") int mid, HttpSession session){
        User user = (User)session.getAttribute("user");
        Menu menu = new Menu();
        menu.setId((mid));
        Order order = new Order();
        order.setUser(user);
        order.setMenu(menu);
        orderFeign.save(order);
        return "order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session){
        User user = (User) session.getAttribute("user");
        int index = (page-1)*limit;
        return orderFeign.findAllByUid(index, limit, user.getId());

    }

}
