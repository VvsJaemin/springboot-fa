package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/**")
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 전처리
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        String url = httpServletRequest.getRequestURI();

        chain.doFilter(httpServletRequest, httpServletResponse);

        //후처리

        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, requestBody : {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());

        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse(); // body 결과 값 필터 처리

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);


    }
}
