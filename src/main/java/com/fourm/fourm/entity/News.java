package com.fourm.fourm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "forum_news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;

    @Column(nullable = false)
    private String newsTitle;

    private String newsReprinted;

    @Lob
    @Column(columnDefinition = "text", nullable = false)
    private String newsContent;

    private LocalDate publicTime;

    private String newsPicture;

    private int newsLike;

    private int newsCollect;

    private int newsViewTimes;

    private String newsAuthor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "adminId")
    private Admin admin;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "news")
    private Set<NewsComment> comments;


}
