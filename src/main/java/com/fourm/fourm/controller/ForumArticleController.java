package com.fourm.fourm.controller;


import com.fourm.fourm.entity.ForumArticle;

import com.fourm.fourm.result.entity.ResultArticleJson;
import com.fourm.fourm.service.ForumService;
import com.fourm.fourm.util.UploadImg;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/forumArticle")
public class ForumArticleController {
    @Autowired
    private ForumService forumService;
    //查看所有帖子
    @GetMapping("/article")
    public ResultArticleJson showForumArticleList() {
        List<ForumArticle> list=forumService.list();
        return  ResultArticleJson.suc(list);

    }
    //通过帖子ID查找帖子
    @GetMapping("/article/articleId/{articleId}")
    public ResultArticleJson showArticleByArticleId(@PathVariable(value = "articleId")int id){
        List<ForumArticle> list=forumService.findArticleByArticleId(id);
        if (list.isEmpty()){
            return ResultArticleJson.notFound(list);
        }else{
            return ResultArticleJson.suc(list);
        }
    }
    //通过用户ID查找帖子
    @GetMapping("/article/userId/{userId}")
    public ResultArticleJson showArticleByUserID(@PathVariable(value = "userId")int id){
        List<ForumArticle> list=forumService.findArticleByUserID(id);
        if (list.isEmpty()){
            return ResultArticleJson.notFound(list);
        }else{
            return ResultArticleJson.suc(list);
        }

    }
    //帖子保存
    @PostMapping("/article/save")
    public ResultArticleJson SaveArticle(@RequestBody ForumArticle forumArticle){

        //System.out.println(forumArticle.getArticlePhoto());
        String articleImgUrl= UploadImg.uploadBase64Image(forumArticle.getArticlePhoto());
        forumArticle.setArticlePhoto(articleImgUrl);
        forumService.saveArticle(forumArticle);
        return ResultArticleJson.suc(forumArticle);
    }

    @RequestMapping("/hello")
    public ResultArticleJson sayHello(){
        return ResultArticleJson.fail();
    }


}
