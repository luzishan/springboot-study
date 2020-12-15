package com.lu.service;

import com.lu.dao.BookMapper;
import com.lu.dao.BookStoreMapper;
import com.lu.dao.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/14 15:40
 */
@Service
public class CustomerBuyBookService {


    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookStoreMapper bookStoreMapper;

    @Autowired
    private CustomerMapper customerMapper;

    /*
     * rollbackFor属性：	该属性用于设置需要进行回滚的异常类数组，当方法中抛出指定异常数组中的异常时，则进行事务回滚。
     * 例如 指定单一异常类：@Transactional(rollbackFor=RuntimeException.class)
     * 指定多个异常类：@Transactional(rollbackFor={RuntimeException.class,Exception.class})
     * rollbackForClassName属性：设置需要进行回滚异常类的全类名数组，当方法中抛出指定异常数组中的异常时，则进行事物回滚。
     * 例如 指定单一异常类：@Transaction(rollbackForClassName = {"java.lang.ArithmeticException"}),多个用','隔开
     * noRollbackFor属性：指定遇到时不回滚的异常类型，可以为多个
     * noRollbackForClassName属性：指定遇到时不回滚的异常类的全类名，可以为多个
     * timeout属性：该属性用于设置事务的超时秒数，超过所设置的时间，事物自动回滚。（Spring事务超时 = 事务开始时到最后一个Statement创建时时间 + 最后一个Statement的执行时超时时间（即其queryTimeout））， 默认值为-1，表示永不超时
     * readOnly属性：该属性用于设置当前事务是否是只读事务，设置为true表示只读，false则表示可读写，默认值为false
     * propagation属性：该属性用于设置事务的传播行为 例如@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
     * 1.propagation = Propagation.REQUIRED（如果有事物在运行，当前的方法就在这个事物内运行，否则启动一个新的事物，并在自己的事物内运行）
     * 2.propagation = Propagation.REQUIRES_NEW（当前方法必须启动新事物，并在自己的事物内运行，如果有事物在运行，应将它挂起）
     * 3.propagation = Propagation.SUPPORTS（如果有事物在运行，当前的方法就在这个事物内运行，否则它可以不运行在事物中）
     * 4.propagation = Propagation.NOT_SUPPORTED（当前方法不应该运行在事物中，如果事物在运行，将在运行的事物挂起）
     * 5.propagation = Propagation.MANDATORY（当前方法必须运行在事物内部，如果没有正在运行的事物就抛出异常）
     * 6.propagation = Propagation.NEVER（当前方法不应该运行在事物中，如果有事物在运行就抛出异常）
     * 7.propagation = Propagation.NESTED（如果有事物在运行，当前方法就应该在这个事物的嵌套事物里运行，否则启动一个新事物，并在自己的事物内运行）

     * isolation属性：该属性用于设置底层数据库的事务隔离级别，事务隔离级别用于处理多事务并发的情况，
     * 通常使用数据库的默认隔离级别即可，基本不需要进行设置
     *
     *异常：编译时异常
     *     运行时异常
     * 事物默认只回滚运行时异常
     *(rollbackFor = Exception.class):回滚所有的异常
     *
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void buy() {
        updateBookStoreNumber();
        updateCustomerCount();
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateBookStoreNumber() {
        bookStoreMapper.updateBookStoreNumber(1, 1);
    }

    @Transactional(propagation = Propagation.NESTED)
    public void updateCustomerCount() {
        int price = bookMapper.getBookPriceByBookId(1);
        customerMapper.updateCustomerCount(1, price);


        int i = 10 / 0;


    }
}
