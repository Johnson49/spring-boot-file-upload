package com.api.streaming.controller;

import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.streaming.ResponseData;
import com.api.streaming.service.VideoServiceImpl;

@RequestMapping("/file")
@RestController
public class VideoController {
    private VideoServiceImpl service;

    public VideoController(VideoServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseData> upload(@RequestParam("file") MultipartFile file) throws Exception {
        var result = service.salvarVideo(file);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Object>> obterTodos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> obterVideo(@PathVariable Long id) throws Exception {
        var video = service.obterVideo(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(video.getTipoDoArquivo()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "file; filename=\"" + video.getNome()
                                + "\"")
                .body(new ByteArrayResource(video.getDados()));
    }
}
