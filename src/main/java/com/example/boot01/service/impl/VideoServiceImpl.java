package com.example.boot01.service.impl;

import com.example.boot01.domian.Video;
import com.example.boot01.mapper.VideoMapper;
import com.example.boot01.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> findAll() {
        return videoMapper.findAll();
    }

    @Override
    public Video findById(int id) {
        return videoMapper.findById(id);
    }

    @Override
    public int  update(Video video) {

       return videoMapper.update(video);
    }

    @Override
    public int  delete(int id) {

       return videoMapper.delete(id);
    }

    @Override
    public int save(Video video) {


        int row = videoMapper.save(video);
        System.out.println("新增对象的ID:" + video.getId());
        return row;
    }


}
