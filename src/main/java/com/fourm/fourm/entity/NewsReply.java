package com.fourm.fourm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "news_comment_reply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsReply implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int replyType;

    private int replyId;

    private String toUserName;

    private String fromName;

    @Lob
    @Column(columnDefinition = "text")
    private String replyContent;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "newsCommentId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private NewsComment comment;
}
