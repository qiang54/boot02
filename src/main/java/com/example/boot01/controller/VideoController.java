package com.example.boot01.controller;


import com.example.boot01.domian.Video;
import com.example.boot01.service.VideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/video")
public class VideoController {

    @GetMapping("test")
    public String  test(){
        return "hello nihao122 ";
    }


    @Autowired
    private VideoService videoService;

    /**
     * 分页接口
     * @param page
     * @param size
     * @return
     */
    @GetMapping("page")
    public Object  findAll(@RequestParam(value = "page",defaultValue = "1") int page,
                           @RequestParam(value = "size",defaultValue = "10") int size){

        PageHelper.startPage(page, size);
        List<Video> videos = videoService.findAll();

        PageInfo<Video> pageInfo = new PageInfo<>(videos);

        return pageInfo;
    }

    @GetMapping("find_by_id")
    public Object  findById(@RequestParam(value = "video_id",required = true) Integer id){
        return videoService.findById(id);
    }


}
