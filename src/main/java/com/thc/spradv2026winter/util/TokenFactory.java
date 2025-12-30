package com.thc.spradv2026winter.util;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TokenFactory {
    // 발급 만료 시간 Term
    static int refreshTokenValidityHour = 2;

    // 리프레시 토큰 생성
    public static String createRefreshToken(Long userId) {
        LocalDateTime now = LocalDateTime.now();

        now = now.plusHours(refreshTokenValidityHour);

        String token = null;

        String info = userId + "_" + now;

        try {
            token = AES256Cipher.AES_Encode(null, info);
        } catch (Exception e) {}

        return token;
    }

    // 연습용 Refresh 토큰 복호화
    public static Long validateToken(String token) { // userId만 돌려줄거라 Long
        String info = null;

        try {
            info = AES256Cipher.AES_Decode(null, token); // 복호화

            String[] array_info = info.split("_");
            Long userId = Long.parseLong(array_info[0]);

            LocalDateTime now = LocalDateTime.now();
            String due = array_info[1];
            String nowTime = now.toString();

            // 만료 여부 확인용
            String[] tempArray = {due, nowTime}; // sort를 위한 배열
            Arrays.sort(tempArray); // ASC 기본
            // 현재 시간이 앞으로 와야 만료 아님
            if(nowTime.equals(tempArray[0])) {
                return userId;
            }
        } catch (Exception e) {}

        return null;
    }
}
