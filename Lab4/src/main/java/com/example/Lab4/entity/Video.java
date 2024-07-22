package com.example.Lab4.entity;

public class Video {
    private String id;
    private String title;
    private String description;
    private Boolean active;
    private String poster;

    public Video() {
    }

    public Video(String id, String title, String description, Boolean active, String poster) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.active = active;
        this.poster = poster;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", poster='" + poster + '\'' +
                '}';
    }
}
