package com.system.ribbon.bean;

import java.io.Serializable;

public class MyPage implements Serializable{
	
	private Object data;
	private boolean flag;
	private String msg;
	private int totalPages;
	private long totalElements;
	private int startPage;
	private int currentPage;
	private int pageSizes;
	
	
	
	
	public MyPage(){
		
	}
   
	public int getStartPage(){
		return this.currentPage-1;
	}
	
	public MyPage(Object data,int totalPages,long totalElements,int pageSizes,int currentPage) {
		this.data = data;
		this.totalPages=totalPages;
		this.totalElements=totalElements;
		this.pageSizes=pageSizes;
		this.currentPage=currentPage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSizes() {
		return pageSizes;
	}

	public void setPageSizes(int pageSizes) {
		this.pageSizes = pageSizes;
	}
	
	

}
