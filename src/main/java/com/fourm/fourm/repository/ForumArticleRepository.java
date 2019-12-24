package com.fourm.fourm.repository;

import com.fourm.fourm.entity.ForumArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumArticleRepository extends JpaRepository<ForumArticle,Integer> {

    List<ForumArticle> findByUserId(int id);
    List<ForumArticle> findByArticleId(int id);


    <S extends ForumArticle> S saveAndFlush(S entity);
}
