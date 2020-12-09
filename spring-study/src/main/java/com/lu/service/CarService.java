package com.lu.service;

import com.lu.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/3 15:08
 */
@Service
public class CarService {

    //@Autowired
    private CarDao carDao;

    public void carSave(){
        System.out.println("carService调用了carDao....");
        //carDao.carSave();
    }

    @Autowired
    public void carSave2(CarDao carDao){
        this.carDao = carDao;
    }
}
