package com.learning.model;

import java.util.List;
import java.util.Optional;

public class Note {

    private int id;
    private String tagName;
    private int tagId;
    private Optional<Bookmark> bookmarkOptional;

    public List<Bookmark> getBookmarkList() {
        return bookmarkList;
    }

    public void setBookmarkList(List<Bookmark> bookmarkList) {
        this.bookmarkList = bookmarkList;
    }

    private List<Bookmark> bookmarkList;


    public Optional<Bookmark> getBookmarkOptional() {
        return bookmarkOptional;
    }

    public void setBookmarkOptional(Optional<Bookmark> bookmarkOptional) {
        this.bookmarkOptional = bookmarkOptional;
    }

    public Note(int id, String tagName, int tagId) {
        this.id = id;
        this.tagName = tagName;
        this.tagId = tagId;
    }

    public Note(int id, String tagName, int tagId, Optional<Bookmark> myBookmark) {
        this.id = id;
        this.tagName = tagName;
        this.tagId = tagId;
        this.bookmarkOptional = myBookmark;
    }

    public Note(int id, String tagName, int tagId, List<Bookmark> myBookmark) {
        this.id = id;
        this.tagName = tagName;
        this.tagId = tagId;
        this.bookmarkList = myBookmark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", tagId=" + tagId +
                ", bookmarkOptional=" + bookmarkOptional +
                ", bookmarkList=" + bookmarkList +
                '}';
    }
}
