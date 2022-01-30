package com.college.service.impl;

import com.college.entity.Video;
import com.college.entity.View;
import com.college.exception.ResourceNotFoundException;
import com.college.repo.VideoRepository;
import com.college.repo.ViewRepository;
import com.college.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ViewRepository viewRepository;

    private static Logger logger =  LoggerFactory.getLogger(VideoServiceImpl.class);

    @Override
    public Video createVideo(Video video) throws ResourceNotFoundException {
        if(video == null)
            return videoRepository.save(video);
        throw new ResourceNotFoundException("No resource found for creation");    }

    @Override
    public Video updateVideo(Video video) throws ResourceNotFoundException {
        if(video == null)
            return videoRepository.save(video);
        throw new ResourceNotFoundException("No resource found for update");
    }

    @Override
    public Optional<Video> getVideo(Integer videoId) throws ResourceNotFoundException {
        Optional<Video> video = videoRepository.findById(videoId);
        if(!video.isEmpty()) {
            viewRepository.save(new View("VIDEO", LocalDateTime.now(), videoId));
            return video;
        }
        throw new ResourceNotFoundException(videoId +" doesn't exist in database");
    }

    @Override
    public List<Video> listVideo() {
        return videoRepository.findAll();
    }

    @Override
    public List<Video> selectedVideos(List<Video> videos) throws ResourceNotFoundException {
        if(!videos.isEmpty())
            return videoRepository.saveAll(videos);
        throw new ResourceNotFoundException("No resource found for update");
    }

    @Override
    public List<Video> findByTitle(String titleName) {
        return videoRepository.findByTitle(titleName);
    }

    @Override
    public List<Video> findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(List<Integer> lessonIds, String title, String tagName) throws ResourceNotFoundException {
        if(!lessonIds.isEmpty())
            return videoRepository.findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(lessonIds,title,tagName);
        throw new ResourceNotFoundException("No resource found for update");
    }

    @Override
    public List<Video> findAllSelectedVideoDetails(List<Integer> videoIds) throws ResourceNotFoundException {
        if(!videoIds.isEmpty())
            return videoRepository.findAllSelectedVideoDetails(videoIds);
        throw new ResourceNotFoundException("No resource found for update");
    }
}
