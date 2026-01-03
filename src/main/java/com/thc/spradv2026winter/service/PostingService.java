package com.thc.spradv2026winter.service;

import com.thc.spradv2026winter.dto.DefaultDto;
import com.thc.spradv2026winter.dto.PostingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostingService {
    DefaultDto.CreateResDto create(PostingDto.CreateReqDto param);
    void update(PostingDto.UpdateReqDto param, Long userId);
    void delete(PostingDto.UpdateReqDto param, Long userId);
    PostingDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(PostingDto.PagedListReqDto param);
    List<PostingDto.DetailResDto> scrollList(PostingDto.ScrollListReqDto param);
}
