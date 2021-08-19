package com.example.filter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GlobalFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 전처리
		ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
		ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);
		
		chain.doFilter(httpServletRequest, httpServletResponse);
		
		// 후처리
		// req
		String url = httpServletRequest.getRequestURI();
		String reqContent = new String(httpServletRequest.getContentAsByteArray());
		
		log.info("request url : {}, request body : {}", url, reqContent);
		
		// res
		String resContent = new String(httpServletResponse.getContentAsByteArray());
		int httpStatus = httpServletResponse.getStatus();
		
		httpServletResponse.copyBodyToResponse();
		
		log.info("response status : {}, responseBody : {}", httpStatus, resContent);
		
	}


}
