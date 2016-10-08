package com.hexian.web.controller;

import com.hexian.web.service.BookServices;
import com.hzit.entity.Book;
import com.hzit.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/10/7.
 */
@Controller
@RequestMapping("/cart")
public class ShopCartController {
    @Autowired
    private BookServices bookServices;

        @RequestMapping("/putcart")
        public String putCart(@RequestParam("bookId") String[] bookId,HttpSession session){
            System.out.print("放入购物车功能");
            //创建了一个购物车对象,先假设session中有购物车，如果没有才创建购物车
            Map cart=(Map)session.getAttribute("cart");  //假设session中有购物车
            if(cart==null)  //如果没有。就创建购物车
            {
                cart=new HashMap();
            }
            //通过BookID获取Book对象
            for(int i=0;bookId!=null && i<bookId.length;i++){
                String currentBookid=bookId[i];
                //通过图书ID获取图书对象
                Book book=bookServices.findbyId(currentBookid);
                BookVo vo=new BookVo();
                vo.setBookcount(book.getBookcount());
                vo.setBookid(book.getBookid());
                vo.setBookname(book.getBookname());
                vo.setBookprice(book.getBookprice());
                vo.setPicture(book.getPicture());
                //如果购物中存在相同的图书。则购买数量为当前购物车中的图书数量加一。否则购买数量为1
                BookVo cartbookvo=(BookVo)cart.get(vo.getBookid());
                if(cartbookvo==null)
                        vo.setCount(1);
                else{
                    vo.setCount( cartbookvo.getCount()+1);
                }
                //预备把vo对象放入到购物车中
                cart.put(vo.getBookid(),vo);
            }
            session.setAttribute("cart", cart);
            return "redirect:/cart/toshoping";
        }


    @RequestMapping("/updatecount")
    @ResponseBody
    public Object updatecount(@RequestParam("bid") Integer bid,@RequestParam("count") Integer count,HttpSession session){
        System.out.println("修改了"+bid+"的数量，新的值是"+count);
        Map cart=(Map)session.getAttribute("cart");
        BookVo bookVo=(BookVo)cart.get(bid);
        if(bookVo!=null){
            bookVo.setCount(count);
        }
        int sum=0;
        Collection<BookVo> value= cart.values();
        for(BookVo vo : value){
            sum+=vo.getCount()*vo.getBookprice();
        }
        session.setAttribute("cart",cart);
        return sum;
    }

    @RequestMapping("/deletebook")
    @ResponseBody
    public Object deleteBook(@RequestParam("bid") Integer bid,HttpSession session){

        Map cart=(Map)session.getAttribute("cart");
        cart.remove(bid);
        session.setAttribute("cart",cart);
        int sum=0;
        Collection<BookVo> value= cart.values();
        for(BookVo vo : value){
            sum+=vo.getCount()*vo.getBookprice();
        }
        return sum;
    }

    @RequestMapping("toshoping")
    public String shoppping(){
            return "shopping";
    }
}
