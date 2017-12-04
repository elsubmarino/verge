package org.theverge.util;

public class Criteria {
	private int page;
	private int perPageNum;
	private String searchType;
	private String keyword;
	private String searchCategory;

	public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0){
			this.page=1;
			return;
		}
		this.page = page;
	}

	
	//method for MyBatis SQL Mapper
	public int getPerPageNum() {
		return this.perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0||perPageNum>100){
			this.perPageNum=10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	//method For MyBatis SQL Mapper-
	public int getPageStart(){
		return (this.page-1)*perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page="+page+", "+"perPageNum="+perPageNum+"]";
	}

	
	

}
