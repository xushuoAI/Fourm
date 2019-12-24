package com.fourm.fourm.service;


import com.fourm.fourm.entity.ForumArticle;
import com.fourm.fourm.repository.ForumArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumService {
    @Autowired
    private ForumArticleRepository forumRepository;

    public List<ForumArticle> list() {
        return forumRepository.findAll();
    }

    public List<ForumArticle> findArticleByUserID(int id){
        return forumRepository.findByUserId(id);
    }

    public List<ForumArticle> findArticleByArticleId(int id){
        return forumRepository.findByArticleId(id);
    }

    public ForumArticle saveArticle(ForumArticle forumArticle){
        return forumRepository.saveAndFlush(forumArticle);
    }

}
