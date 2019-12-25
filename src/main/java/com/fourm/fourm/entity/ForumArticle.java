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




}
