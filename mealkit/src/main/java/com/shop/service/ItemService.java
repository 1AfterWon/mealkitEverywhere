package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.Criteria;
import com.shop.dto.ItemDTO;
import com.shop.dto.OrderDetailDTO;
import com.shop.dto.PageDTO;
import com.shop.dto.response.PageResponseDTO;
import com.shop.frame.MyService;
import com.shop.mapper.CategoryMapper;
import com.shop.mapper.ItemMapper;


@Service
public class ItemService implements MyService<Integer, ItemDTO>{

	@Autowired
	ItemMapper itemMapper;
	
	@Autowired
	CategoryMapper categoryMapper;
	
	@Override
	public void register(ItemDTO itemDto) throws Exception {
		itemMapper.insert(itemDto);
	}

	@Override
	public void remove(Integer itemKey) throws Exception {
		itemMapper.delete(itemKey);
	}

	@Override
	public void modify(ItemDTO itemDto) throws Exception {
		itemMapper.update(itemDto);
	}

	@Override
	public ItemDTO get(Integer itemKey) {
		try {
			return itemMapper.select(itemKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public List<ItemDTO> getall() {
		try {
			return itemMapper.selectall();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<ItemDTO> getItemList(Criteria cri){
		try {
			return itemMapper.getItemList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//모든 상품 세기
	public int countItem(Criteria cri) throws Exception{
		return itemMapper.countItem(cri);
	}
	
	
	//모든 상품 페이지 메이커
	public PageResponseDTO getItemPageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		List<Integer> pageNumList = new ArrayList<>();
		
		try {
			pageMaker = new PageDTO(cri, itemMapper.countItem(cri));
			
			for(int i=pageMaker.getPageStart(); i<=pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		PageResponseDTO itemPageResponseDTO = PageResponseDTO.builder()
				.pageMaker(pageMaker)
				.pageNumList(pageNumList)
				.build();
		
		
		return itemPageResponseDTO;
	}
	
	
	//주문완료 후 item에서 수량 줄이기
	public void cntDown(OrderDetailDTO od){
		try {
			itemMapper.cntDown(od);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<ItemDTO> bestItem() throws Exception{
		return itemMapper.bestItem();
	}
	
	public List<ItemDTO> newItem() throws Exception{
		return itemMapper.newItem();
	}

	@Override
	public List<ItemDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
