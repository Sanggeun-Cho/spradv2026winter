package com.thc.spradv2026winter.controller;

import com.thc.spradv2026winter.dto.DefaultDto;
import com.thc.spradv2026winter.dto.PostingDto;
import com.thc.spradv2026winter.security.PrincipalDetails;
import com.thc.spradv2026winter.service.PostingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/posting")
@RestController
public class PostingRestController {

    final PostingService postingService;

    @PreAuthorize("hasRole('USER')")
    // @PreAuthorize("permitAll()")
    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody PostingDto.CreateReqDto param, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        Long userId = principalDetails.getUser().getId();
        param.setUserId(userId);

        return ResponseEntity.ok(postingService.create(param));
    }

    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody PostingDto.UpdateReqDto param, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        System.out.println("userId = " + userId);

        if(userId == null) {
            // 로그인 안됐으면
            System.out.println("userId is null");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        postingService.update(param, userId);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody PostingDto.UpdateReqDto param, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        System.out.println("userId = " + userId);

        if(userId == null) {
            // 로그인 안됐으면
            System.out.println("userId is null");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        postingService.delete(param, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<PostingDto.DetailResDto> detail(DefaultDto.DetailReqDto param, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        System.out.println("userId = " + userId);

        if(userId == null) {
            // 로그인 안됐으면
            System.out.println("userId is null");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        return ResponseEntity.ok(postingService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<PostingDto.DetailResDto>> list(PostingDto.ListReqDto param) {
        return ResponseEntity.ok(postingService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(PostingDto.PagedListReqDto param) {
        return ResponseEntity.ok(postingService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<PostingDto.DetailResDto>> scrollList(PostingDto.ScrollListReqDto param) {
        return ResponseEntity.ok(postingService.scrollList(param));
    }

}
