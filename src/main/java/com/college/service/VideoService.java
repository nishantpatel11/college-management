package com.college.service;

import com.college.entity.Video;
import com.college.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface VideoService {

    Video createVideo(Video video) throws ResourceNotFoundException;
    Video updateVideo(Video video) throws ResourceNotFoundException;
    Optional<Video> getVideo(Integer videoId) throws ResourceNotFoundException;
    List<Video> listVideo();

    List<Video> selectedVideos(List<Video> videos) throws ResourceNotFoundException;
    List<Video> findByTitle(String titleName);
    List<Video> findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(List<Integer> lessonIds, String title,String tagName) throws ResourceNotFoundException;
    List<Video> findAllSelectedVideoDetails(List<Integer> videoIds) throws ResourceNotFoundException;

}
