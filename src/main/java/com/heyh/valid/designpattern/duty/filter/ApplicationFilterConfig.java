package com.heyh.valid.designpattern.duty.filter;

/**
 * Filter 包装类
 */
public class ApplicationFilterConfig {

    private Filter filter;

    public ApplicationFilterConfig(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

}