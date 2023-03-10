package com.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.shop.dto.Criteria;
import com.shop.dto.ItemDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.frame.MyMapper;

@Repository
@Mapper
public interface ItemMapper extends MyMapper<Integer, ItemDTO>{
	
	//상품 리스트 조회
	public List<ItemDTO> getItemList(Criteria cri) throws Exception;
	
	//상품 갯수 카운트
	public int countItem(Criteria cri) throws Exception;
	
	//주문 완료 후 수량을 줄여주는 기능
	public void cntDown(OrderDetailDTO od) throws Exception;
	
	public List<ItemDTO> bestItem();
	
	public List<ItemDTO> newItem();
}
