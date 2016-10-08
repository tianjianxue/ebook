package com.hexian.web.controller;

import com.hexian.web.service.OrderServices;
import com.hexian.web.service.UserServices;
import com.hzit.entity.Book;
import com.hzit.entity.User;
import com.hzit.vo.BookVo;
import com.hzit.vo.OrderlistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class OrderController extends BaseController {
    @Autowired
    private OrderServices orderServices;

   @RequestMapping("addorder")
   @ResponseBody
    public Object addOrder(HttpSession session){
       try {
           //从session中获取用户对象
           User user = (User) session.getAttribute("user");
           //从session中获取购物车对象
           Map<Integer, BookVo> cart = (Map) session.getAttribute("cart");
           //获取购物车中的所有值
           Collection<BookVo> values = cart.values();
           List list = new ArrayList();
           //将购物车的所有值转移到集合中，以便于放入到订单对象中
           for (BookVo bookVo : values) {
               list.add(bookVo);
           }
           OrderlistVo o = new OrderlistVo();
           o.setUserid(user.getUserid());
           o.setBookVoList(list);
           boolean boo = orderServices.addOrder(o);
           return boo;
       }catch (Exception ex){
           ex.printStackTrace();
           return false;
       }
   }


}