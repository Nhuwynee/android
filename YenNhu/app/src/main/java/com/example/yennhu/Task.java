package com.example.yennhu;

public class Task {
    private String title;
    private String progress;

    public Task(String title, String progress) {
        this.title = title;
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public String getProgress() {
        return progress;
    }
}
