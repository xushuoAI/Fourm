package com.fourm.fourm.service;



import com.fourm.fourm.entity.News;
import com.fourm.fourm.repository.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepo newsRepo;

    public List<News> list() {
        return newsRepo.findAll();
    }
    public News saveNews(News news){
        return newsRepo.saveAndFlush(news);
    }
    public Page<News> showAll(Pageable pageable){
        return newsRepo.findAll(pageable);
    }
    public String deleteNews(Long id){
        return newsRepo.findById(id).map(news -> {
            newsRepo.deleteById(id);
            return "成功删除";
        }).orElse("不存在该新闻id");
    }

}
