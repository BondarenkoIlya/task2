package com.epam.ilya.domain.entities;

import com.epam.ilya.domain.converters.LocalDateConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "news")
public class News extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 7450697954427244532L;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "creation_date")
    @Convert(converter = LocalDateConverter.class)
    private LocalDate date;

    @Column(name = "brief")
    private String brief;

    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                "author='" + author + '\'' +
                ", date=" + date + '\'' +
                ", content='" + content + '\'' +
                ", brief='" + brief + '\'' +
                '}';
    }
}