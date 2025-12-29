package com.thc.spradv2026winter.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Enumeration;

public class DefaultInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // 컨트롤러 진입 전에 호출되는 메서드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("preHandle / request [{}]", request);

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            // logger.info("[HEADER] " + headerName + " : " + headerValue);
        }

        Enumeration<String> attributeNames = request.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            String attributeValue = request.getAttribute(attributeName).toString();
            // logger.info("[ATTRIBUTE] " + attributeName + " = " + attributeValue);
        }

        String userId = request.getHeader("userId");

        request.setAttribute("userId", userId);

        Collection<String> resHeaderNames = response.getHeaderNames();
        for(String each : resHeaderNames){
            String resHeaderValue = response.getHeader(each);
            logger.info("[HEADER RES] " + each + " : " + resHeaderValue);
        }

        return true; // 무조건 true 리턴
    }

    // 컨트롤러 실행 후에 호출되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("postHandle / request [{}]", request);

        Collection<String> resHeaderNames = response.getHeaderNames();
        for(String each : resHeaderNames){
            String resHeaderValue = response.getHeader(each);
            logger.info("[HEADER RES] " + each + " : " + resHeaderValue);
        }
    }

    // 모든 것을 마친 후 실행되는 메서드
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("afterCompletion / request [{}]", request);

        Collection<String> resHeaderNames = response.getHeaderNames();

        for(String each : resHeaderNames){
            String resHeaderValue = response.getHeader(each);
            logger.info("[HEADER RES] " + each + " : " + resHeaderValue);
        }
    }
}
