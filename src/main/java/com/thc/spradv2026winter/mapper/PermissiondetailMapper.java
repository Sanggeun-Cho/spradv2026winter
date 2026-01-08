package com.thc.spradv2026winter.mapper;

import com.thc.spradv2026winter.dto.PermissiondetailDto;

import java.util.List;

public interface PermissiondetailMapper {
	PermissiondetailDto.DetailResDto detail(Long id);
	List<PermissiondetailDto.DetailResDto> list(PermissiondetailDto.ListReqDto param);
	List<PermissiondetailDto.DetailResDto> pagedList(PermissiondetailDto.PagedListReqDto param);
	int listCount(PermissiondetailDto.PagedListReqDto param);
    List<PermissiondetailDto.DetailResDto> scrollList(PermissiondetailDto.ScrollListReqDto param);
}