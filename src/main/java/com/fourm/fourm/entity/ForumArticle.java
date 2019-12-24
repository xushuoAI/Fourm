package com.fourm.fourm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "forum_article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumArticle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer articleId;

    @Column(columnDefinition = "TEXT")
    private String articleContent;
    @Column(length = 11)
    private int userId;

    private LocalDate articlePublishTime;

    @Column(length = 11)
    private int articleLike;
    @Column(length = 11)
    private int articleCollect;
    @Column(length = 255)
    private String articlePhoto;
    @Column(length = 11)
    private int articleCommentTimes;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(LocalDate articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }

    public int getArticleLike() {
        return articleLike;
    }

    public void setArticleLike(int articleLike) {
        this.articleLike = articleLike;
    }

    public int getArticleCollect() {
        return articleCollect;
    }

    public void setArticleCollect(int articleCollect) {
        this.articleCollect = articleCollect;
    }

    public String getArticlePhoto() {
        return articlePhoto;
    }

    public void setArticlePhoto(String articlePhoto) {
        this.articlePhoto = articlePhoto;
    }

    public int getArticleCommentTimes() {
        return articleCommentTimes;
    }

    public void setArticleCommentTimes(int articleCommentTimes) {
        this.articleCommentTimes = articleCommentTimes;
    }
}
