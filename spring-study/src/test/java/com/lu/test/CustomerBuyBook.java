package com.lu.test;

import com.lu.dao.BookMapper;
import com.lu.dao.BookStoreMapper;
import com.lu.dao.CustomerMapper;
import com.lu.domain.Customer;
import com.lu.service.CustomerBuyBookService;
import com.lu.service.TransactionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/14 15:19
 */
public class CustomerBuyBook {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("IOC9.xml");



    @Test
    public void test() throws FileNotFoundException {
        CustomerBuyBookService service = (CustomerBuyBookService)applicationContext.getBean("customerBuyBookService");
        service.buy();
    }

    @Test
    public void testTransaction() {
        TransactionService service = (TransactionService)applicationContext.getBean("transactionService");
        service.testTransaction();
    }

}
