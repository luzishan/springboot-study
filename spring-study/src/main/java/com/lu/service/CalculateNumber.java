package com.lu.service;

import org.springframework.stereotype.Service;

/**
 * Calculate实现类
 *
 * @author lzs
 * @version 1.0
 * @date 2020/12/8 11:08
 */
@Service
public class CalculateNumber implements Calculate{

    @Override
    public int add(int i, int j) {
        int res = i + j;
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        return res;
    }

   @Override
    public int mul(int i, int j) {
        int res = i * j;
        return res;
    }

    @Override
    public int dev(int i, int j) {
        try {
            int res = i / j;
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return 0;
    }
}
