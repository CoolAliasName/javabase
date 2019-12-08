package com.heyh.valid.designpattern.duty.filter;

import java.util.Arrays;

/**
 * 过滤器链
 * 内存通过 数组 存放过滤器
 */
public class ApplicationFilterChain implements FilterChain {

    private ApplicationFilterConfig[] filters = new ApplicationFilterConfig[0];
    private int pos = 0; // 维持过滤器中的当前位置
    private int n = 0; // 过滤器链中的过滤器数量

    @Override
    public void doNextFilter() {
        internalDoFilter();
    }

    private void internalDoFilter() {
        if (pos < n) {
            ApplicationFilterConfig filterConfig = filters[pos++];
            Filter filter = filterConfig.getFilter();
            filter.doFilter(this);
            return;
        }
    }

    // 添加过滤器
    void addFilter(ApplicationFilterConfig filterConfig) {
        // 数组扩容
        grow(n + 1); // 新容量为旧容量 +1
        // 将过滤器放入数组中
        filters[n++] = filterConfig;
    }

    /**
     * 扩容
     */
    public void grow(int newCapacity) {
        // 拷贝扩容，新建一个长度为 n 的数组，循环遍历旧数组将元素放入到新数组对应的位置，完成后返回新数组
        filters = Arrays.copyOf(filters, newCapacity);
    }

}