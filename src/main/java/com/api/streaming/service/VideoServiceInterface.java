package com.api.streaming.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.api.streaming.ResponseData;
import com.api.streaming.model.VideoModel;

public interface VideoServiceInterface {
    ResponseData salvarVideo(MultipartFile file) throws Exception;
    VideoModel obterVideo(Long id) throws Exception;
    List<Object> obterTodos();
}
