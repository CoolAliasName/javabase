package com.heyh.valid.designpattern.duty.filter;

public class Client {
    public static void main(String[] args) {
        // 三个过滤器实例
        Filter filter1 = new MyFilter1();
        Filter filter2 = new MyFilter2();
        Filter filter3 = new MyFilter3();

        // 创建一个 过滤器链 实例
        ApplicationFilterChain filterChain = new ApplicationFilterChain();

        // 将 filter 实例封装成统一的包装类 ApplicationFilterConfig
        ApplicationFilterConfig filterConfig1 = new ApplicationFilterConfig(filter1);
        ApplicationFilterConfig filterConfig2 = new ApplicationFilterConfig(filter2);
        ApplicationFilterConfig filterConfig3 = new ApplicationFilterConfig(filter3);

        filterChain.addFilter(filterConfig1);
        filterChain.addFilter(filterConfig2);
        filterChain.addFilter(filterConfig3);

        filterChain.doNextFilter();
    }
}