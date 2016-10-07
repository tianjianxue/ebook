package com.hexian.web.controller;
import com.fc.platform.commons.page.Page;
import com.hexian.web.service.BookServices;
import com.hzit.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class BookController extends BaseController{

    @Autowired
    private BookServices bookServices;

    @RequestMapping("/bypage")
    public String findbypage(@RequestParam( name="page",defaultValue = "0")int page,ModelMap modelMap){
        //System.out.println("已经进入了控制器");
        if(page<0){
            page=0;
        }
        Page<Book>data=bookServices.findbypage(page, 3);
        modelMap.put("slist",data);
        modelMap.put("current",page);
        return "index";
    }
}
