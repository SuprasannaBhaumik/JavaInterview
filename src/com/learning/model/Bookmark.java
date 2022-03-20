package com.learning.model;

public class Bookmark {

    public Bookmark(int pageNo, String topic) {
        this.pageNo = pageNo;
        this.topic = topic;
    }

    private int pageNo;
    private String topic;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
