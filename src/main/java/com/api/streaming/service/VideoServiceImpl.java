package com.api.streaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.api.streaming.ResponseData;
import com.api.streaming.exceptions.InvalidPAth;
import com.api.streaming.exceptions.NotFound;
import com.api.streaming.exceptions.ErrorSave;
import com.api.streaming.model.VideoModel;
import com.api.streaming.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoServiceInterface {

    private VideoRepository repository;

    public VideoServiceImpl(VideoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseData salvarVideo(MultipartFile file) throws Exception {
        String NomeDoArquivo = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (NomeDoArquivo.contains("..")) {
                throw new InvalidPAth();
            }

            VideoModel video = new VideoModel(
                    NomeDoArquivo,
                    file.getBytes(),
                    file.getContentType());

            var resultado = repository.save(video);

            var downloadURL = "http://localhost:8080/file/" + resultado.getId();
            return new ResponseData(
                    NomeDoArquivo,
                    downloadURL,
                    file.getContentType(),
                    file.getSize());

        } catch (Exception e) {
            throw new ErrorSave();
        }
    }

    @Override
    public VideoModel obterVideo(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(
                        () -> new NotFound());
    }

    @Override
    public List<Object> obterTodos() {
        return repository.obterTodos();
    }

}
