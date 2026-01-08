package com.thc.spradv2026winter.dto;

import com.thc.spradv2026winter.domain.Permissiondetail;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

public class PermissiondetailDto {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class ToggleReqDto{
        Long permissionId;
        String target;
        Integer func;
        Boolean flag; // 입력 true, 삭제 false
    }

    /**/

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class CreateReqDto{
        Long permissionId;
        String target;
        Integer func;

        public Permissiondetail toEntity(){
            return Permissiondetail.of(getPermissionId(), getTarget(), getFunc());
        }
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto{
        Long permissionId;
        String target;
        Long func;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class DetailResDto extends DefaultDto.DetailResDto {
        Long permissionId;
        String target;
        Long func;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ListReqDto extends DefaultDto.ListReqDto {
        Long permissionId;
        String target;
        Long func;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        Long permissionId;
        String target;
        Long func;
    }
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        Long permissionId;
        String target;
        Long func;
    }
}
