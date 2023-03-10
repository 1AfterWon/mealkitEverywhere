package com.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Criteria;
import com.admin.dto.NoticeDTO;
import com.admin.dto.PageDTO;
import com.admin.dto.response.PageResponseDTO;
import com.admin.frame.MyService;
import com.admin.mapper.NoticeMapper;


@Service
public class NoticeService implements MyService<Integer, NoticeDTO>{

	@Autowired
	NoticeMapper noticeMapper;

	@Override
	public void register(NoticeDTO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Integer k) {
		try {
			noticeMapper.delete(k);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void modify(NoticeDTO v){
		try {
			noticeMapper.update(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public NoticeDTO get(Integer k) {
		NoticeDTO result=null;
		try {
			result=noticeMapper.select(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<NoticeDTO> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public List<NoticeDTO> getNoticeList(Criteria cri){
		try {
			return noticeMapper.getNoticeList(cri);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 모든 이벤트 페이지 개수 가져오기
	public int countNotice(Criteria cri) throws Exception{
		return noticeMapper.countNotice(cri);
	}

	// 상품 관리 리스트 페이징
	public PageResponseDTO getNoticePageMaker(Criteria cri) {
		PageDTO pageMaker = null;
		int active = 0;
		List<Integer> pageNumList = new ArrayList<>();

		try {
			pageMaker = new PageDTO(cri, noticeMapper.countNotice(cri));

			for (int i = pageMaker.getPageStart(); i <= pageMaker.getPageEnd(); i++) {
				pageNumList.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if(pageMaker.getCri().getPageNum() == i) { active = 1; }else { active = 0; }
		 */

		PageResponseDTO pageResponseDTO = PageResponseDTO.builder()
				.pageMaker(pageMaker)
				.active(active)
				.pageNumList(pageNumList)
				.build();

		return pageResponseDTO;

	}
	public void registerNotice(NoticeDTO notice) {
		try {
			noticeMapper.registerNotice(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
