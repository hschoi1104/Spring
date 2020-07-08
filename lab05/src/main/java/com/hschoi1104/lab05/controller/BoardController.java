package com.hschoi1104.lab05.controller;

import com.hschoi1104.lab05.dao.BoardDAO;
import com.hschoi1104.lab05.dto.BoardDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@MapperScan(basePackages = "com.hschoi1104.lab05.dao")

public class BoardController {

    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping(value="/board",method = RequestMethod.POST)
    public ResponseEntity<BoardDTO> postBoard(BoardDTO board) throws Exception{
        if((board.getAuthor() == null)||(board.getContents()==null)||(board.getPassword()==null)||(board.getTitle()==null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        boardDAO.newBoard(board);
        return new ResponseEntity<>(board,HttpStatus.OK);
    }

    @RequestMapping(value = "/board/{seq}", method = RequestMethod.GET)
    public ResponseEntity<BoardDTO> getBoard(@PathVariable("seq") final int seq) throws Exception {
        BoardDTO param = new BoardDTO();
        param.setSeq(seq);

        boardDAO.addBoardReadCount(param);

        BoardDTO board = boardDAO.getBoard(param);

        if (board == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "/board/{seq}", method = RequestMethod.PUT)
    public ResponseEntity<BoardDTO> putBoard(@PathVariable("seq") final int seq,BoardDTO param) throws Exception{
        if((param.getAuthor() == null)||(param.getContents()==null)||(param.getPassword()==null)||(param.getTitle()==null)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        param.setSeq(seq);
        BoardDTO board = boardDAO.getBoard(param);
        if(board == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        board.setTitle(param.getTitle());
        board.setContents(param.getContents());
        board.setAuthor(param.getAuthor());
        boardDAO.editBoard(board);

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @RequestMapping(value = "/board/{seq}",method = RequestMethod.DELETE)
    public ResponseEntity<BoardDTO> deletedBoard(@PathVariable("seq") final int seq, BoardDTO param) throws Exception{
        if(param.getPassword()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        param.setSeq(seq);
        BoardDTO board = boardDAO.getBoard(param);
        if(board == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        board.setDeleted("Y");
        boardDAO.editBoard(board);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
