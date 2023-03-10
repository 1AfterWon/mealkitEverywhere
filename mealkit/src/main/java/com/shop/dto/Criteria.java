
  package com.shop.dto;
  
  
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
  
@Setter
@Getter
@ToString
  //페이지 번호, 개수, 스킵을 세팅하기 위한 클래스
  public class Criteria {
  
	  //현재 페이지 번호 
	  private int pageNum;
  
	  //한 페이지에 출력할 데이터 개수 
	  private int amount;
	  
	  //페이지 스킵
	  private int skip;
	  
	  //검색 키워드 
	  private String keyword;
	  
	  //검색 타입 
	  private String type;

	  //정렬 기준
	  private String orderCri;
	  
	  //차순
	  private String ascDesc;
	  
	  //카테고리 번호
	  private int categoryKey;
	  
	  //상품 번호
	  private int itemKey;
	  
	  
	  private int custKey;
	  
	  
	  //디폴트값을 설정하는 기본 생성자 
	  public Criteria() { 
		 this.pageNum = 1;
		 this.amount = 12; 
	  }
	  
	  
	  public Criteria(int pageNum, int amount) { 
		  this.pageNum = pageNum; 
		  this.amount = amount;
		  this.skip = (pageNum - 1) * amount;
	  }
  
	  //검색 타입 데이터 배열 변환
	  public String[] getTypeArr() {
		  return type == null ? new String[] {} : type.split("");
	  };
	  
	  //페이지 번호(pageNum)을 받았을 때 페이지 번호 세팅과 스킵 세팅
	  public void setPageNum(int pageNum) {
		  this.pageNum = pageNum;
		  this.skip = (pageNum -1 ) * this.amount;
	  }
	  
	  //데이터 개수(amount)를 받았을 때 데이터 개수 세팅과 스킵 세팅
	  public void setAmount(int amount) {
		  this.amount = amount;
		  this.skip = (this.pageNum - 1) * amount;
	  }
	  
	  
  }
 