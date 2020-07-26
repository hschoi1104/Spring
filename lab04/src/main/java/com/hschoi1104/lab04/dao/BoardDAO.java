package com.hschoi1104.lab04.dao;


import com.hschoi1104.lab04.dto.BoardDTO;

public interface BoardDAO {
    int newBoard(BoardDTO param) throws Exception;

    BoardDTO getBoard(BoardDTO param) throws Exception;

    int editBoard(BoardDTO param) throws Exception;
}
