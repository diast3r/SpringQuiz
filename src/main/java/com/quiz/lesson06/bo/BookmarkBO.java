package com.quiz.lesson06.bo;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public List<Bookmark> getBookMarkList() {
		return bookmarkMapper.selectBookMarkList(); 
	}
	
	public int addBookmark(String name, String url) {
		return bookmarkMapper.insertBookmark(name, url);
	}
}
