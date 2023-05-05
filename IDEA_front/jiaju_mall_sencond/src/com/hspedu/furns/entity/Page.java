package com.hspedu.furns.entity;

import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public class Page {
    public static final Integer PAGE_DEFAULT_SIZE = 3; // 一个默认值
    private Integer pageSize; // 每一页显示的家居数量
    private Integer totalCount; // 下面显示的总页数
    private Integer totalItemSize; // 所有家居的数量
    private HashMap<Integer,PageItems> pageItems; // 每一页显示的家居集合, 用k-v比较合理

    public Page() {
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalItemSize() {
        return totalItemSize;
    }

    public void setTotalItemSize(Integer totalItemSize) {
        this.totalItemSize = totalItemSize;
    }

    public HashMap<Integer, PageItems> getPageItems() {
        return pageItems;
    }

    public void setPageItems(HashMap<Integer, PageItems> pageItems) {
        this.pageItems = pageItems;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalItemSize=" + totalItemSize +
                ", pageItems=" + pageItems +
                '}';
    }
}
