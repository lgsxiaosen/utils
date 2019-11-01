package com.github.lgsxiaosen.utils.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaosen
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 9028045688118686228L;

    private InnerPage page = new InnerPage();
    private List<T> items;
    private Map<String, Object> res;

    public Page() {
    }

    public Page(int currentPage, int pageSize, int totalNum) {
        this.page.setCurrentPage(currentPage);
        this.page.setPageSize(pageSize);
        this.page.setTotalNum(totalNum);
        this.page.setTotalPage((totalNum + pageSize - 1) / pageSize);
        this.page.setStartIndex((currentPage - 1) * pageSize);
        this.page.setIsMore(currentPage >= this.page.getTotalPage() ? 0 : 1);
    }

    public List<T> getItems() {
        if (this.items==null){
            this.items = new ArrayList<>();
        }
        return this.items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Map<String, Object> getRes() {
        if (null==res){
            res = new HashMap<>();
        }
        return res;
    }

    public void setRes(Map<String, Object> res) {
        this.res = res;
    }

    public InnerPage getPage() {
        return this.page;
    }

    public void setPage(InnerPage page) {
        this.page = page;
    }

}
