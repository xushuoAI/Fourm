package com.fourm.fourm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "news_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsCommentId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "newsId")
    private News news;

    private Long userId;

    @Lob
    @Column(columnDefinition = "text")
    private String newsCommentContent;

    private int toTop;

    private int newsCommentLike;

    private int newsCommentReply;

    private LocalDate newsCommentCreateTime;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comment")
    private Set<NewsReply> replies;

}
