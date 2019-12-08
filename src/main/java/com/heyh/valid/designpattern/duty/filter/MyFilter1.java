package com.heyh.valid.designpattern.duty.filter;

/**
 * 具体 filter 实现
 */
public class MyFilter1 implements Filter {

    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("MyFilter1...");
        chain.doNextFilter();
    }

}