package com.example.boot01.mapper;

import com.example.boot01.domian.Video;
import com.example.boot01.provider.VideoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface VideoMapper {


    @Select("select * from video")
    //@Results({
            //@Result(column = "cover_img",property = "coverImg") })
    List<Video> findAll();


     //@Update("update video set title = #{title} where id = #{id}")

    @UpdateProvider(type = VideoProvider.class, method = "updateVideo")
    int  update(Video video);

    @Select("select * from video where id = #{id}")
    Video findById(int id);

    @Delete("delete from video where id = #{id}")
    int  delete(int id);

    @Insert("INSERT INTO `video` " +
            "( `title`, `summary`, `cover_img`, `view_num`, `price`, `create_time`, `online`, `point`)" +
            "VALUES" +
            "(#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price}, #{createTime}, #{online}, #{point});")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int save(Video video);

}
