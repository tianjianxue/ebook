package com.hexian.web.service;

import com.hzit.entity.Orderlist;
import com.hzit.vo.BookVo;
import com.hzit.vo.OrderlistVo;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/8.
 */
public interface OrderServices {




    public boolean addOrder(OrderlistVo order);


}
