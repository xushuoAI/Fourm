package com.fourm.fourm.repository;

import com.fourm.fourm.entity.News;
import com.fourm.fourm.entity.NewsComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsCommentRepo extends JpaRepository<NewsComment,Long> {

    public List<NewsComment> findByNews_NewsId(long newsId);
    @Override
    <S extends NewsComment> S saveAndFlush(S entity);
}
