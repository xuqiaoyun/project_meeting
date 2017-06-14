package com.etc.util;


public class PageBean {
    private int page;
    private int rows;
    private String str;
    public PageBean() {
		// TODO Auto-generated constructor stub
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public PageBean(int page, int rows, String str) {
		super();
		this.page = page;
		this.rows = rows;
		this.str = str;
	}
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", str=" + str
				+ "]";
	}
    
}