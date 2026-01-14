package com.thc.spradv2026winter.mapper;

import com.thc.spradv2026winter.dto.PermissionDto;

import java.util.List;

public interface PermissionMapper {
	List<String> access(Long reqUserId);
	int ispermitted(PermissionDto.IspermittedReqDto param);
	/**/
	PermissionDto.DetailResDto detail(Long id);
	List<PermissionDto.DetailResDto> list(PermissionDto.ListReqDto param);
	List<PermissionDto.DetailResDto> pagedList(PermissionDto.PagedListReqDto param);
	int listCount(PermissionDto.PagedListReqDto param);
    List<PermissionDto.DetailResDto> scrollList(PermissionDto.ScrollListReqDto param);
}