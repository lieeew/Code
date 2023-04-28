package com.hspedu.furns.entity;

/**
 * @Author: qxy
 * @Date: 2023/4/26
 * @Description:
 */
public interface Status {
/*
待付款（Pending Payment）
已付款（Payment Received）
准备发货（Preparing for Shipment）
已发货（Shipped）
送达中（In Transit）
已送达（Delivered）
已取消（Cancelled）
已退款（Refunded）
异常订单（Abnormal Order）
等待处理（Awaiting Processing）
 */
    String PENDING_PAYMENT = "待付款";
    String PAYMENT_RECEIVED = "已付款";
    String PREPARING_FOR_SHIPMENT = "准备发货";
    String SHIPPED = "已发货";
    String IN_TRANSIT = "送达中";
    String DELIVERED = "已送达";

}
