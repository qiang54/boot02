package com.example.boot01.controller.admin;

import com.example.boot01.domian.Video;
import com.example.boot01.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api/video")
public class VideoAdminController {


    @Autowired
    private VideoService videoService;

    @DeleteMapping("del_by_id")
    public Object   delById(@RequestParam(value = "video_id",required = true)Integer id){
        return videoService.delete(id);
    }


    @PutMapping("update_by_id")
    public Object   update(@RequestBody Video video){

        return videoService.update(video);
    }


    @PostMapping("save")
    public Object save(@RequestBody Video video){

        return videoService.save(video);
    }

}
