package com.example.boot01.provider;

import com.example.boot01.domian.Video;
import org.apache.ibatis.jdbc.SQL;


/**
 * 动态sql
 * 有就更新，没有就不更新
 */
public class VideoProvider {

    public String updateVideo(final Video video){
        return new SQL(){{
            UPDATE("video");

            //条件写法.
            if(video.getTitle()!= null){
                SET("title=#{title}");
            }
            if(video.getSummary()!= null){
                SET("summary=#{summary}");
            }
            if(video.getCoverImg()!= null){
                SET("cover_img=#{cover_img}");
            }
            if(video.getViewNum()!= null){
                SET("view_num=#{view_num}");
            }
            if(video.getPrice()!= null){
                SET("price=#{price}");
            }
            if(video.getCreateTime()!= null){
                SET("create_time=#{create_time}");
            }
            if(video.getOnline()!= null){
                SET("online=#{online}");
            }
            if(video.getPoint()!= null){
                SET("point=#{point}");
            }


            WHERE("id=#{id}");
        }}.toString();
    }
}
