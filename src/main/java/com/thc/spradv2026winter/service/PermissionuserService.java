package com.thc.spradv2026winter.service;

import com.thc.spradv2026winter.dto.DefaultDto;
import com.thc.spradv2026winter.dto.PermissionuserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionuserService {
    DefaultDto.CreateResDto create(PermissionuserDto.CreateReqDto param, Long reqUserId);
    void update(PermissionuserDto.UpdateReqDto param, Long reqUserId);
    void delete(PermissionuserDto.UpdateReqDto param, Long reqUserId);
    PermissionuserDto.DetailResDto detail(DefaultDto.DetailReqDto param, Long reqUserId);
    List<PermissionuserDto.DetailResDto> list(PermissionuserDto.ListReqDto param, Long reqUserId);
    DefaultDto.PagedListResDto pagedList(PermissionuserDto.PagedListReqDto param, Long reqUserId);
    List<PermissionuserDto.DetailResDto> scrollList(PermissionuserDto.ScrollListReqDto param, Long reqUserId);
}
