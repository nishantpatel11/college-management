package com.college.controller;

import com.college.entity.Video;
import com.college.entity.View;
import com.college.exception.ResourceNotFoundException;
import com.college.repo.ViewRepository;
import com.college.service.VideoService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.VIDEO)
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private ViewRepository viewRepository;

    @PostMapping("/")
    public Video createVideo(Video video) throws ResourceNotFoundException {
        return videoService.createVideo(video);
    }

    @PutMapping("/")
    public Video updateVideo(Video video) throws ResourceNotFoundException {
        return videoService.updateVideo(video);
    }

    @GetMapping("/{id}")
    public Optional<Video> getVideo(@PathVariable ("id") Integer id) throws ResourceNotFoundException {
        return videoService.getVideo(id);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public List<Video> listVideo(){
        return videoService.listVideo();
    }
}
