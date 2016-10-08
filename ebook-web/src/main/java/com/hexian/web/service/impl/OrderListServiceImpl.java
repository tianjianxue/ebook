package com.hexian.web.service.impl;

import com.hexian.web.service.OrderServices;
import com.hzit.entity.Orderlist;
import com.hzit.entity.Xiangqing;
import com.hzit.mapper.OrderlistMapper;
import com.hzit.mapper.XiangqingMapper;
import com.hzit.vo.BookVo;
import com.hzit.vo.OrderlistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2016/10/8.
 */
@Service
public class OrderListServiceImpl implements OrderServices {
    @Autowired
    private OrderlistMapper orderlistMapper;
    @Autowired
    private XiangqingMapper xiangqingMapper;


    @Override
    @Transactional  //添加事物支持。如果出现异常该方法的所有操作回滚
    public boolean addOrder(OrderlistVo order) {

          String orderID= UUID.randomUUID().toString(); //生成一个唯一编号
          //先增加订单表的数据
          Orderlist o=new Orderlist();
          o.setOrderid(orderID);
          o.setCreattime(new Date());
          o.setState("已下单");
          o.setUserid(order.getUserid());
          int sum=0;  //要用来计算订单总价
          List<BookVo> xiangqinglist= order.getBookVoList();
          for(BookVo x : xiangqinglist){
              sum+=x.getCount()*x.getBookprice();
          }
          o.setOrderprice(sum);
          orderlistMapper.insertOrderlist(o);
          //在增加详情表的数据，循环增加多行数据
          for(BookVo x : xiangqinglist){
              sum+=x.getCount()*x.getBookprice();
              Xiangqing xiangqing=new Xiangqing();
              xiangqing.setOrderid(orderID);
              xiangqing.setBookid(x.getBookid());
              xiangqing.setCount(x.getCount());
              xiangqing.setPrice(x.getBookprice());
              xiangqingMapper.insertXiangqing(xiangqing);
          }
          return true;


    }
}
