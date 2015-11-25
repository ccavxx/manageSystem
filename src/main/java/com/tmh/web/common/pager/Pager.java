package com.tmh.web.common.pager;

import java.util.ArrayList;
import java.util.List;

import com.tmh.web.common.BaseObject;
 
/**
 * 
 * className:Pager
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年9月28日-上午9:42:04
 * @Remark 备注说明
 * @param <E>
 */
public class Pager<E> extends BaseObject {
	 
	private static final long serialVersionUID = 1L;
	public static int FIRST_PAGE = 1;// 第一页
	public static int MAX_PAGE_COUNT = 10;
	public static int PAGE_SIZE= 5;
	private Integer toPage = FIRST_PAGE;// 当前页码

	private int pageSize;// 每页显示记录数

	private int maxPageCount = MAX_PAGE_COUNT;// 页面显示使用google分页样式时的页码列表最大数量，比如[1][2][3][4]....[15],[3][2][3][4]....[18]

	private int totalItem;// 查询出的数据总数

	private List<Integer> pageNumList;// 页码列表[1][2][3][4]...

	private List<E>   list = new ArrayList<E>(); // 查询返回的数据列表


	public int getMaxPageCount() {
		return maxPageCount < 1 ? MAX_PAGE_COUNT : maxPageCount;
	}

	public void setMaxPageCount(int maxPageCount) {
		this.maxPageCount = maxPageCount;
	}

	public Integer getToPage() {
		return toPage;
	}

	public void setToPage(Integer toPage) {
		this.toPage = toPage;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
		if(totalItem != null) {
			this.totalItem = totalItem;
		}
	}

	public int getPageSize() {
		return pageSize <= 0 ? PAGE_SIZE : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Integer> getPageNumList() {
		pageNumList = new ArrayList<Integer>();
		int totalPage = this.getTotalPage();
		toPage = toPage < 1 ? FIRST_PAGE : (toPage > totalPage ? totalPage
				: toPage);
		int currentOption = toPage;
		int endOption = currentOption + getMaxPageCount() / 2;
		if (endOption > totalPage) {
			endOption = totalPage;
		}
		int beginOption = endOption - getMaxPageCount() + 1;
		if (beginOption <= 0) {
			beginOption = 1;
		}
		for (int i = beginOption; i <= endOption; i++) {
			pageNumList.add(i);
		}
		return pageNumList;
	}

	/**
	 * 判断当前页是否为第一页
	 *
	 * @return boolean
	 */
	public boolean getIsFirstPage() {
		return toPage == FIRST_PAGE;
	}

	/**
	 * 判断当前页是否为最后一页
	 *
	 * @return boolean
	 */
	public boolean getIsLastPage() {
		int totalPage = this.getTotalPage();
		return totalPage == 0 || toPage == totalPage;
	}

	/**
	 * 得到上一页的页数
	 *
	 * @return int 如果当前页没有上一页，返回1
	 */
	public int getPrevPage() {
		int back = toPage - 1;
		return back < 1 ? FIRST_PAGE : back;
	}

	/**
	 * 得到下一页的页数
	 *
	 * @return int 如果当前也没有下一页，返回总页数
	 */
	public int getNextPage() {
		int next = toPage + 1;
		int totalPage = this.getTotalPage();
		return next > totalPage ? totalPage : next;
	}

	/**
	 * 得到第一页的页数
	 *
	 * @return boolean
	 */
	public int getFirstPage() {
		return FIRST_PAGE;
	}

	/**
	 * 得到最后一页的页数
	 *
	 * @return boolean
	 */
	public int getLastPage() {
		int totalPage = this.getTotalPage();
		return totalPage <= 0 ? FIRST_PAGE : totalPage;
	}

	/**
	 * 得到要显示的总页数
	 *
	 * @return int
	 */
	public int getTotalPage() {
		int pageSize = getPageSize();
		return totalItem <= 0 ? 0 : (totalItem + pageSize - 1) / pageSize;
	}

	/**
	 * 得到要检索的起始行数
	 */
	public Integer getStartRow() {
		int totalPage = this.getTotalPage();
		toPage = toPage < 1 ? FIRST_PAGE : (toPage > totalPage ? totalPage: toPage);
		Integer row =0;
		if (totalPage!=0) {
			row = new Integer((toPage - 1) * getPageSize());
		}
		return row;
	}

	public Integer getEndRow() {
		int totalPage = this.getTotalPage();
		toPage = toPage < 1 ? FIRST_PAGE : (toPage > totalPage ? totalPage
				: toPage);
		return new Integer(toPage * getPageSize());
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}
}
