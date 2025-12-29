package com.thc.spradv2026winter.service.impl;

import com.thc.spradv2026winter.domain.Posting;
import com.thc.spradv2026winter.dto.DefaultDto;
import com.thc.spradv2026winter.dto.PostimgDto;
import com.thc.spradv2026winter.dto.PostingDto;
import com.thc.spradv2026winter.mapper.PostingMapper;
import com.thc.spradv2026winter.repository.PostingRepository;
import com.thc.spradv2026winter.service.PostimgService;
import com.thc.spradv2026winter.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostingServiceImpl implements PostingService {

    final PostingRepository postingRepository;
    final PostingMapper postingMapper;
    final PostimgService postimgService;

    @Override
    public DefaultDto.CreateResDto create(PostingDto.CreateReqDto param) {

        if(param.getImgs() != null && !param.getImgs().isEmpty()){
            param.setImg(param.getImgs().get(0));
        }

        DefaultDto.CreateResDto res = postingRepository.save(param.toEntity()).toCreateResDto();

        for(String img : param.getImgs()){
            postimgService.create(PostimgDto.CreateReqDto.builder().postingId(res.getId()).img(img).build());
        }

        return res;
    }

    @Override
    public void update(PostingDto.UpdateReqDto param) {
        Posting posting = postingRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        posting.update(param);
        postingRepository.save(posting);
    }

    @Override
    public void delete(PostingDto.UpdateReqDto param) {
        update(PostingDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public PostingDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        PostingDto.DetailResDto res = postingMapper.detail(param.getId());
        System.out.println("res??? : " + res);
        res.setImgs(postimgService.list(PostimgDto.ListReqDto.builder().deleted(false).postingId(res.getId()).build()));
        return res;
    }

    @Override
    public PostingDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }

    public List<PostingDto.DetailResDto> addlist(List<PostingDto.DetailResDto> list) {
        List<PostingDto.DetailResDto> newList = new ArrayList<>();
        for (PostingDto.DetailResDto posting : list) {
            newList.add(get(DefaultDto.DetailReqDto.builder().id(posting.getId()).build()));
        }
        return newList;
    }

    @Override
    public List<PostingDto.DetailResDto> list(PostingDto.ListReqDto param) {
        List<PostingDto.DetailResDto> list = new ArrayList<>();
        List<PostingDto.DetailResDto> postings = postingMapper.list(param);
        return addlist(postings);
    }
    @Override
    public DefaultDto.PagedListResDto pagedList(PostingDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(postingMapper.listCount(param));
        res.setList(addlist(postingMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<PostingDto.DetailResDto> scrollList(PostingDto.ScrollListReqDto param) {
        return addlist(postingMapper.scrollList(param));
    }
}
