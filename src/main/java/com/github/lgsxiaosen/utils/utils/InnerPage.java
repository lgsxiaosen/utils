package com.github.lgsxiaosen.utils.utils;

import java.io.Serializable;

/**
 * @author sen
 * 2019/11/1 15:08
 */
public class InnerPage implements Serializable {

    private static final long serialVersionUID = -3732571224540993610L;

    private int currentPage = 1;

    private int pageSize = 60;

    private int totalNum = 0;

    private int isMore = 0;

    private int totalPage = 0;

    private int startIndex = 0;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getIsMore() {
        return isMore;
    }

    public void setIsMore(int isMore) {
        this.isMore = isMore;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
