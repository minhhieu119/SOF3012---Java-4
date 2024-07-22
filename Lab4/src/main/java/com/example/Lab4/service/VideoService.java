package com.example.Lab4.service;

import com.example.Lab4.entity.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoService {
    List<Video> list = new ArrayList<>();

    public VideoService() {
        list.add(new Video("wAR74sdst43W", "Hài tết 2024", "Hài đặc biệt", true, "https://i.ytimg.com/vi/6Oca97QrLXY/sddefault.jpg"));
        list.add(new Video("wAR74sdst227s", "2 ngày 1 đêm", "Chương trình truyền hình thực tế đạt top 1 trending.", false, "https://i.ytimg.com/vi/ezh7rQaDoJ4/maxresdefault.jpg"));
    }

    public List<Video> getList() {
        return list;
    }

    public void add (Video vd){
        list.add(vd);
    }

    public Video getVideoByIndex (int index){
        return list.get(index);
    }

    public Video getVideoById(String id) {
        for (Video v : list){
            if (v.getId().equalsIgnoreCase(id)){
                return v;
            }
        } return null;
    }

    public void update (int index, Video v){
        list.set(index, v);
    }
}
