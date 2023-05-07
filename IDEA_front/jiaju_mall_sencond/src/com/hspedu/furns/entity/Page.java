package com.hspedu.furns.entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/5/5
 * @Description:
 */
public class Page {
    public static final Integer PAGE_DEFAULT_SIZE = 3; // 一个默认值

    private Integer pageNo; // 表示显示当前的页[显示第几页]
    private Integer pageSize; // 每一页显示的家居数量
    private Integer totalCount; // 下面显示的总页数
    private Integer totalItemSize; // 所有家居的数量
    private ArrayList<Furn> furns; // 每一页显示的家居集合, 用k-v比较合理

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

    public ArrayList<Furn> getFurns() {
        return furns;
    }

    public void setFurns(ArrayList<Furn> furns) {
        this.furns = furns;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalItemSize=" + totalItemSize +
                ", furns=" + furns +
                '}';
    }
}
