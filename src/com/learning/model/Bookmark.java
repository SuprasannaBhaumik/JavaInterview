package com.learning.model;

public class Bookmark {

    @Override
    public String toString() {
        return "Bookmark{" +
                "pageNo=" + pageNo +
                ", topic='" + topic + '\'' +
                ", version=" + version +
                ", price=" + price +
                '}';
    }

    public Bookmark(int pageNo, String topic) {
        this.pageNo = pageNo;
        this.topic = topic;
    }

    public Bookmark(int pageNo, String topic, Long version, double price) {
        this.pageNo = pageNo;
        this.topic = topic;
        this.version = version;
        this.price = price;
    }

    private int pageNo;
    private String topic;
    private Long version;
    private double price;

    public int getPageNo() {
        return pageNo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
