package com.spring.boot.util.paginator;

import lombok.Data;

@Data
public class PageItem {
    private int number;
    private boolean current;

    public PageItem(int number, boolean current) {
        this.number = number;
        this.current = current;
    }
}
