package com.thc.spradv2026winter.mapper;

import com.thc.spradv2026winter.dto.PostlikeDto;

import java.util.List;

public interface PostlikeMapper {
	PostlikeDto.DetailResDto detail(Long id);
	List<PostlikeDto.DetailResDto> list(PostlikeDto.ListReqDto param);
	List<PostlikeDto.DetailResDto> pagedList(PostlikeDto.PagedListReqDto param);
	int listCount(PostlikeDto.PagedListReqDto param);
    List<PostlikeDto.DetailResDto> scrollList(PostlikeDto.ScrollListReqDto param);
}