package com.github.lgsxiaosen.utils.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaosen
 * @date 2019/1/23 18:32
 * @description
 */
public class Page<T> {
    private Page<T>.InnerPage page;
    private List<T> items;
    private Map<String, Object> res;

    public Page() {
    }

    public Page(Integer currentPage, Integer pageSize, Integer totalNum) {
        this.page = new Page.InnerPage();
        this.page.currentPage = currentPage;
        this.page.pageSize = pageSize;
        this.page.totalNum = totalNum;
        this.page.totalPage = (this.page.totalNum + this.page.pageSize - 1) / this.page.pageSize;
        this.page.startIndex = (this.page.currentPage - 1) * this.page.pageSize;
        this.page.isMore = this.page.currentPage >= this.page.totalPage ? 0 : 1;
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

    public Page<T>.InnerPage getPage() {
        return this.page;
    }

    public void setPage(Page<T>.InnerPage page) {
        this.page = page;
    }

    public class InnerPage {
        private Integer currentPage = 1;
        private Integer pageSize = 60;
        private Integer totalNum;
        private Integer isMore;
        private Integer totalPage;
        private Integer startIndex;

        public InnerPage() {
        }

        public Integer getCurrentPage() {
            return this.currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getTotalNum() {
            return this.totalNum;
        }

        public void setTotalNum(Integer totalNum) {
            this.totalNum = totalNum;
        }

        public Integer getIsMore() {
            return this.isMore;
        }

        public void setIsMore(Integer isMore) {
            this.isMore = isMore;
        }

        public Integer getTotalPage() {
            return this.totalPage;
        }

        public void setTotalPage(Integer totalPage) {
            this.totalPage = totalPage;
        }

        public Integer getStartIndex() {
            return this.startIndex;
        }

        public void setStartIndex(Integer startIndex) {
            this.startIndex = startIndex;
        }
    }
}
