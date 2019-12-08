package com.heyh.valid.designpattern.duty.filter;

/**
 * 过滤器接口
 * 定义了一个方法，用于将责任传递到下一个过滤器
 */
public interface Filter {

    public void doFilter(FilterChain chain);

}
