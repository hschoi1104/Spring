package com.hschoi1104.curd.controller;


import com.hschoi1104.curd.dao.PostDAO;
import com.hschoi1104.curd.dto.PostDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@MapperScan(basePackages = "com.hschoi1104.curd.dao")
public class PostController {

    @Autowired
    private PostDAO postDAO;

    @RequestMapping(value="/post",method= RequestMethod.POST)
    public PostDTO createPost(PostDTO post) throws Exception{
        postDAO.newPost(post);
        return post;
    }
}
