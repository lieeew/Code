package com.hspedu.furns.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: qxy
 * @Date: 2023/4/26
 * @Description:
 */
public class Order {

    private String id;
    private Date dateTime;
    private BigDecimal price;
    private String status;
    private Integer memberId;

    public Order() {
    }

    public Order(String id, Date dateTime, BigDecimal price, String status, Integer memberId) {
        this.id = id;
        this.dateTime = dateTime;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}
