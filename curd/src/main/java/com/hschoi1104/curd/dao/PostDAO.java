package com.hschoi1104.curd.dao;

import com.hschoi1104.curd.dto.PostDTO;

public interface PostDAO {
    int newPost(PostDTO param) throws Exception;
}