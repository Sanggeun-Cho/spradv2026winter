package com.thc.spradv2026winter.controller;

import com.thc.spradv2026winter.dto.DefaultDto;
import com.thc.spradv2026winter.dto.UserDto;
import com.thc.spradv2026winter.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserRestController {

    final UserService userService;

    @PostMapping("/login") // 토큰 값 헤더에 담아서 주기
    public ResponseEntity<Void> login(@RequestBody UserDto.LoginReqDto param) {
        String refreshToken = userService.login(param).getRefreshToken();

        return ResponseEntity.ok().header("RefreshToken", refreshToken).build();
    }
    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody UserDto.CreateReqDto param) {
        return ResponseEntity.ok(userService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody UserDto.UpdateReqDto param) {
        userService.update(param);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody UserDto.UpdateReqDto param) {
        userService.delete(param);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<UserDto.DetailResDto> detail(DefaultDto.DetailReqDto param) {
        return ResponseEntity.ok(userService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto.DetailResDto>> list(UserDto.ListReqDto param) {
        return ResponseEntity.ok(userService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(UserDto.PagedListReqDto param) {
        return ResponseEntity.ok(userService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<UserDto.DetailResDto>> scrollList(UserDto.ScrollListReqDto param) {
        return ResponseEntity.ok(userService.scrollList(param));
    }

}
