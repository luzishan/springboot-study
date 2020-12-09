package com.lu.controller;

import com.lu.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/3 14:54
 */
@Controller
public class CarController {


    //@Qualifier("carService01")
    @Autowired(required = false)
    private CarService carService;

    public void carSave(){
        System.out.println("carController调用carService。。。");
        carService.carSave();
    }
}
