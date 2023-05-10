package com.hspedu.furns.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ClassName: Order
 * Package: com.hspedu.furns.entity
 *
 * @Author: leikooo
 * @Creat: 2023/5/7 - 14:48
 * @Description:
 */
public class Order {
    private String id;
    private Date creatTime;
    private BigDecimal price;
    private Integer status;
    private Integer memberId;

    public Order() {
    }

    public Order(String id, Date creatTime, BigDecimal price, Integer status, Integer memberId) {
        this.id = id;
        this.creatTime = creatTime;
        this.price = price;
        this.status = status;
        this.memberId = memberId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", creatTime=" + creatTime +
                ", price=" + price +
                ", status=" + status +
                ", memberId=" + memberId +
                '}';
    }
}
