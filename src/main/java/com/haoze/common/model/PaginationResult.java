package com.haoze.common.model;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 分页封装信息。
 * @author maxl 2018-05-03。
 */
public class PaginationResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pageNum;//当前页
    private int pageSize;//每页的数量
    private long total;//总记录数
    private int pages;//总页数
    private List<T> list;//结果集
    private boolean isFirstPage = false;//是否为第一页
    private boolean isLastPage = false;//是否为最后一页


    public PaginationResult() {
    }

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PaginationResult(List<T> list) {

        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.list = page;
            this.total = page.getTotal();
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = 1;
            this.list = list;
            this.total = list.size();
        }
        if (list instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    @Override
    public String toString() {
        final StringBuffer buffer = new StringBuffer("PageInfo{");
        buffer.append("pageNum=").append(pageNum);
        buffer.append(", pageSize=").append(pageSize);
        buffer.append(", total=").append(total);
        buffer.append(", pages=").append(pages);
        buffer.append(", list=").append(list);
        buffer.append(", isFirstPage=").append(isFirstPage);
        buffer.append(", isLastPage=").append(isLastPage);
        buffer.append(", navigatepageNums=");
        buffer.append('}');
        return buffer.toString();
    }
}
