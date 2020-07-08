package com.hschoi1104.lab03.dao;

import com.hschoi1104.lab03.dto.UserDTO;

import java.util.List;

public interface UserDAO {
    List<UserDTO> selectUsers(UserDTO param) throws Exception;
}
