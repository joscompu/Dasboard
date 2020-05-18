package com.spring.boot.util.paginator;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageRender<T> {
    private String url;
    private Page<T> page;
    private int totalPages;
    private int numberElementPage;
    private int pageCurrent;
    private List<PageItem> pages;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.pages = new ArrayList<PageItem>();
        numberElementPage = page.getSize();
        totalPages = page.getTotalPages();
        pageCurrent = page.getNumber() + 1;

        int since, until;
        if (totalPages <= numberElementPage) {
            since = 1;
            until = totalPages;
        } else {
            if (pageCurrent <= numberElementPage / 2) {
                since = 1;
                until = numberElementPage;
            } else if (pageCurrent >= totalPages - numberElementPage / 2) {
                since = totalPages - numberElementPage + 1;
                until = numberElementPage;
            } else {
                since = pageCurrent - numberElementPage / 2;
                until = numberElementPage;
            }

        }

        for (int i = 0; i < until; i++) {
            pages.add(new PageItem(since + i, pageCurrent == since + i));
        }
    }

    public boolean isFirst() {
        return page.isFirst();
    }

    public boolean isLast() {
        return page.isLast();
    }

    public boolean isHasNext() {
        return page.hasNext();
    }

    public boolean isHasPrevious() {
        return page.hasPrevious();
    }
}
