package com.example.socialnetwork.form;

import org.apache.struts.action.ActionForm;

public class PostForm extends ActionForm {
    private String id; // Thêm id để lưu ID bài viết
    private String title;
    private String body;

    public PostForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
