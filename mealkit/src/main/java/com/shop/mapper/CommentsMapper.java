package com.shop.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.CommentsDTO;
import com.shop.frame.MyMapper;
@Repository
@Mapper
public interface CommentsMapper extends MyMapper<Integer, CommentsDTO>{

	//관리자 답변
	public CommentsDTO qnaReply(int boardKey) throws Exception; 
	
	//문의게시판에 나타낼 관리자 답변
	public CommentsDTO getComment(CommentsDTO cmtDTO) throws Exception;
}
