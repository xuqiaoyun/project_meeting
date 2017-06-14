package com.etc.util;


import java.util.List;

/**
 * ��ҳ������
 * ������ ��ʾ�ļ�¼����Ϣ
 * ����
 * ÿ����ʾ�ļ�¼
 * ��ǰ�ĵڼ�ҳ
 */
public class PageData {
	private List data; // ���ҵ�����

	private Integer total; // �ܼ�¼��

	private Integer rows;// ÿҳ����
	
	private Integer page;// ҳ��

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	

	public PageData() {
		super();
	}

	public PageData(List data, Integer total, Integer rows, Integer page) {
		super();
		this.data = data;
		this.total = total;
		this.rows = rows;
		this.page = page;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * �õ���ҳ��
	 * @return
	 */
	public int getTotalPage() {
		//�ܼ�¼�� ��ÿҳ��ʾ�ļ�¼�� ���õ���ҳ��
		//8   3
		int num = total / rows; //2
		if (total % rows != 0)
			num++; //3
		return num; //3
	}

	@Override
	public String toString() {
		return "PageData [data=" + data + ", total=" + total + ", rows=" + rows
				+ ", page=" + page + "]";
	}
	
}
