<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/7
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title></title>
  <link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
<div id="header" class="wrap">
  <div id="logo">合众艾特网上书城</div>
  <div id="navbar">
    <div class="userMenu">
      <ul>
        <li><a href="index.html">User首页</a></li>
        <li><a href="orderlist.html">我的订单</a></li>
        <li class="current"><a href="shopping.html">购物车</a></li>
        <li><a href="#">注销</a></li>
      </ul>
    </div>
    <form method="get" name="search" action="">
      搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
    </form>
  </div>
</div>
<div id="content" class="wrap">
  <div class="list bookList">
    <form method="post" name="shoping" action="../addorder">
      <table>
        <tr class="title">
          <th class="view">图片预览</th>
          <th>书名</th>
          <th class="nums">数量</th>
          <th class="price">单价</th>
          <th class="price">小计</th>
          <th class="price">删除</th>
        </tr>
        <c:forEach items="${cart}" var="g">
        <tr>
          <td class="thumb"><img src="${g.value.picture}" height="150" /></td>
          <td class="title">${g.value.bookname}</td>
          <td>
            <input class="input-text" type="text" name="nums"  bid="${g.value.bookid}" price="${g.value.bookprice}" value="${g.value.count}" /></td>
          <td>￥<span>${g.value.bookprice}</span></td>
          <td>￥<span>${g.value.bookprice*g.value.count}</span></td>
          <td><span><a class="del" href="javascript:void(0)" bid="${g.value.bookid}" >删除</a></span></td>
        </tr>
        </c:forEach>
      </table>
      <div class="button">
        <h4>总价：￥<span id="total">65.00</span>元</h4>
        <input class="input-chart" type="submit" name="submit" value="" />
      </div>
    </form>
  </div>
</div>
<div id="footer" class="wrap">
  合众艾特网上书城 &copy; 版权所有
</div>
<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
  $(function(){

      $(".input-text").blur(function(){
        var price=$(this).attr("price");
        var count=$(this).val();
        //先修改本地小计
      $(this).parent().next().next().children("span").html( price* count )
        //在修改服务器:
        $.post("updatecount",{"bid":$(this).attr("bid"),"count":$(this).val()},function(a){
             $("#total").html(a)
        })




      })


      $(".del").click(function(){
            $(this).parents("tr").slideUp(1000)
        $.post("deletebook",{"bid":$(this).attr("bid")},function(a){
          $("#total").html(a)

        })
      })
  })
</script>

</body>
</html>

