package com.thc.spradv2026winter.mapper;

import com.thc.spradv2026winter.dto.UserDto;

import java.util.List;

public interface UserMapper {
	UserDto.DetailResDto detail(Long id);
	List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
	List<UserDto.DetailResDto> pagedList(UserDto.PagedListReqDto param);
	int listCount(UserDto.PagedListReqDto param);
    List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param);
}