package com.hspedu.furns.entity;

import java.util.List;

/**
 * @Author: qxy
 * @Date: 2023/4/18
 * @Description:
 */
public class Page<T> {
    // 因为每一页显示多少记录, 其他地方也可以使用
    public static final Integer PAGE_SIZE = 3;
    // 表示显示当前的页[显示第几页]
    private Integer pageNo;
    // 表示每页显示几条记录
    private Integer pageSize =  PAGE_SIZE;
    // 表示总共有多少页, 是计算得出的
    private Integer pageTotalCount;
    // 表示一共有几条记录, 可以在数据库中找到
    private Integer totalRow;
    // 当前页面要显示的Furn数据
    // 这个数据可以冲DB中取出数据
    private List<T> items;
    // 分页导航显示的数据
    private String url;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageTotalCount, Integer totalRow, List<T> items, String url) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.totalRow = totalRow;
        this.items = items;
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public Integer getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Integer totalRow) {
        this.totalRow = totalRow;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}