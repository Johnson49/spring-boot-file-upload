package com.api.streaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.streaming.model.VideoModel;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<VideoModel, Long> {
   
    @Query(nativeQuery = true, value="SELECT id, nome, tipo_do_arquivo FROM video")
    List<Object> obterTodos();
}
