package com.thc.spradv2026winter.service;

import com.thc.spradv2026winter.dto.DefaultDto;
import com.thc.spradv2026winter.dto.PostingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostingService {
    DefaultDto.CreateResDto create(PostingDto.CreateReqDto param, Long reqUserId);
    void update(PostingDto.UpdateReqDto param, Long reqUserId);
    void delete(PostingDto.UpdateReqDto param, Long reqUserId);
    PostingDto.DetailResDto detail(DefaultDto.DetailReqDto param, Long reqUserId);
    List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param, Long reqUserId);
    DefaultDto.PagedListResDto pagedList(PostingDto.PagedListReqDto param, Long reqUserId);
    List<PostingDto.DetailResDto> scrollList(PostingDto.ScrollListReqDto param, Long reqUserId);
}
