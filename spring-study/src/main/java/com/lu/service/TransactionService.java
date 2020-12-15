package com.lu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/15 14:56
 */
@Service
public class TransactionService {

    @Autowired
    private CustomerBuyBookService customerBuyBookService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void testTransaction(){
        customerBuyBookService.updateBookStoreNumber();
        customerBuyBookService.updateCustomerCount();
    }
}
