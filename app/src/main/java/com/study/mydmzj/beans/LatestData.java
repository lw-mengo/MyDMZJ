package com.study.mydmzj.beans;

public class LatestData {
    /**
     * id : 46724
     * title : 魔物娘
     * islong : 2
     * authors : 绿茶猫
     * types : 欢乐向/四格/萌系
     * cover : https://images.dmzj.com/webpic/4/000mowuniangmanhua1213.jpg
     * status : 连载中
     * last_update_chapter_name : 第91话
     * last_update_chapter_id : 92464
     * last_updatetime : 1577335123
     */

    private int id;
    private String title;
    private int islong;
    private String authors;
    private String types;
    private String cover;
    private String status;
    private String last_update_chapter_name;
    private int last_update_chapter_id;
    private int last_updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIslong() {
        return islong;
    }

    public void setIslong(int islong) {
        this.islong = islong;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLast_update_chapter_name() {
        return last_update_chapter_name;
    }

    public void setLast_update_chapter_name(String last_update_chapter_name) {
        this.last_update_chapter_name = last_update_chapter_name;
    }

    public int getLast_update_chapter_id() {
        return last_update_chapter_id;
    }

    public void setLast_update_chapter_id(int last_update_chapter_id) {
        this.last_update_chapter_id = last_update_chapter_id;
    }

    public int getLast_updatetime() {
        return last_updatetime;
    }

    public void setLast_updatetime(int last_updatetime) {
        this.last_updatetime = last_updatetime;
    }
}
