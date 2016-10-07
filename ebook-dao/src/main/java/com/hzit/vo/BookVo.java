package com.hzit.vo;

/**
 * 
 * @author renhao
 */
public class BookVo {
	/**
	 *  图书编号
	 */
	private Integer bookid;
	/**
	 *  图书名
	 */
	private String bookname;
	/**
	 *  图书价格
	 */
	private Integer bookprice;
	/**
	 *  图书库存
	 */
	private Integer bookcount;
	/**
	 *  图书图片地址
	 */
	private String picture;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 购买数量
	 */

	private int count;
	/**
	 * 图书编号
	 * @param bookid
	 */
	public void setBookid(Integer bookid){
		this.bookid = bookid;
	}
	
    /**
     * 图书编号
     * @return Integer
     */	
    public Integer getBookid(){
    	return bookid;
    }
	/**
	 * 图书名
	 * @param bookname
	 */
	public void setBookname(String bookname){
		this.bookname = bookname;
	}
	
    /**
     * 图书名
     * @return String
     */	
    public String getBookname(){
    	return bookname;
    }
	/**
	 * 图书价格
	 * @param bookprice
	 */
	public void setBookprice(Integer bookprice){
		this.bookprice = bookprice;
	}
	
    /**
     * 图书价格
     * @return Integer
     */	
    public Integer getBookprice(){
    	return bookprice;
    }
	/**
	 * 图书库存
	 * @param bookcount
	 */
	public void setBookcount(Integer bookcount){
		this.bookcount = bookcount;
	}
	
    /**
     * 图书库存
     * @return Integer
     */	
    public Integer getBookcount(){
    	return bookcount;
    }
	/**
	 * 图书图片地址
	 * @param picture
	 */
	public void setPicture(String picture){
		this.picture = picture;
	}
	
    /**
     * 图书图片地址
     * @return String
     */	
    public String getPicture(){
    	return picture;
    }
}