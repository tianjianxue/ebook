package bookservicestest;

import com.fc.platform.commons.page.Page;
import com.hexian.web.QiDong;

import com.hexian.web.service.OrderServices;
import com.hexian.web.service.impl.BookServiceImpl;
import com.hzit.entity.Book;
import com.hzit.mapper.BookMapper;
import com.hzit.vo.BookVo;
import com.hzit.vo.OrderlistVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(QiDong.class)
public class BookTest {
    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private OrderServices orderServices;

    @Test
    public void testaddOrder(){
        OrderlistVo o=new OrderlistVo();
        o.setUserid(1);
        BookVo v1=new BookVo();
        v1.setBookid(1);
        v1.setCount(2);
        v1.setBookprice(100);


        BookVo v2=new BookVo();
        v2.setBookid(2);
        v2.setCount(3);
        v2.setBookprice(45);
        List list=new ArrayList();
        list.add(v1);
        list.add(v2);
        o.setBookVoList(list);

        orderServices.addOrder(o);





    }



    @Test
    public void findall() {
        List<Book> list = bookService.findall();
        for (Book s : list) {
            System.out.println(s.getBookname());
        }
    }

    @Test
    public void findbypage() {
        Page<Book> p = bookService.findbypage(1, 3);
        List<Book>list=p.getContent();
        for(Book s:list){
            System.out.println(s.getBookname());
        }
    }
}