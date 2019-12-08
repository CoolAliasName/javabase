package com.heyh.valid.designpattern.duty.filter;

/**
 * 具体 filter 实现
 */
public class MyFilter2 implements Filter {

    @Override
    public void doFilter(FilterChain chain) {
        System.out.println("MyFilter2...");
        chain.doNextFilter();
    }

}