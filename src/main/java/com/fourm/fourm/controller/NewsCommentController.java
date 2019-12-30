package com.fourm.fourm.controller;


import com.fourm.fourm.entity.News;
import com.fourm.fourm.entity.NewsComment;
import com.fourm.fourm.entity.NewsReply;
import com.fourm.fourm.repository.CommentReplyRepo;
import com.fourm.fourm.repository.NewsCommentRepo;
import com.fourm.fourm.result.entity.ResultArticleJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/newscomment")
public class NewsCommentController {

    @Autowired
    private NewsCommentRepo newsCommentRepo;
    @Autowired
    private CommentReplyRepo commentReplyRepo;
    //新闻评论
    @GetMapping("/{newsid}")
    public ResultArticleJson getComment(@PathVariable("newsid")long id) {
        return ResultArticleJson.suc(newsCommentRepo.findByNews_NewsId(id));
        //return ResultArticleJson.suc();

    }
    @PostMapping
    public ResultArticleJson saveComment(@RequestBody NewsComment newsComment,@RequestParam("newsid") Long newsId) {
        News news=new News();
        news.setNewsId(newsId);
        newsComment.setNews(news);
        return ResultArticleJson.suc(newsCommentRepo.saveAndFlush(newsComment));
    }
    @DeleteMapping("/{id}")
    public ResultArticleJson deleteComment(@PathVariable("id")long id) {
        return newsCommentRepo.findById(id).map(newsComment -> {
            newsCommentRepo.deleteById(id);
            return ResultArticleJson.suc();
        }).orElse(ResultArticleJson.fail(9404,"不存在的id"));

    }
    //评论的回复
    @GetMapping("/reply/{commentid}")
    public ResultArticleJson getReply(@PathVariable("commentid")long id) {
        return ResultArticleJson.suc(commentReplyRepo.findByComment_NewsCommentId(id));
        //return ResultArticleJson.suc();

    }
    @PostMapping("/reply")
    public ResultArticleJson saveReplyComment(@RequestBody NewsReply newsReply) {
        return ResultArticleJson.suc(commentReplyRepo.saveAndFlush(newsReply));
    }
    @DeleteMapping("/reply/{id}")
    public ResultArticleJson deleteReplyComment(@PathVariable("id")long id) {
        return commentReplyRepo.findById(id).map(newsReply -> {
            commentReplyRepo.deleteById(id);
            return ResultArticleJson.suc();
        }).orElse(ResultArticleJson.fail(9404,"不存在的id"));

    }




}
