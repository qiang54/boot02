package com.example.boot01.service;

import com.example.boot01.domian.Video;

import java.util.List;

public interface VideoService {

    List<Video> findAll();

    Video findById(int id);

    int update(Video video);

    int  delete(int id);

    int save(Video video);
}
