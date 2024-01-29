package com.jing.springcloudtest.service.impl;

import com.jing.springcloudtest.dao.PaymentDao;


import com.jing.springcloudtest.entities.Payment;
import com.jing.springcloudtest.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
