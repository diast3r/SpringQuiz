package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.Bookmark;

@Mapper
public interface BookmarkMapper {
	public List<Bookmark> selectBookMarkList();
	
	public int insertBookmark(
			@Param("name") String name,
			@Param("url") String url
			);
}