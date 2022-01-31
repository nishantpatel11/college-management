package com.college.controller;

import com.college.entity.Video;
import com.college.exception.ResourceNotFoundException;
import com.college.service.VideoService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.VIDEO)
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/")
    public ResponseEntity<Video> createVideo(@RequestBody Video video) throws ResourceNotFoundException {
        return new ResponseEntity<Video>(videoService.createVideo(video), HttpStatus.OK);
    }

    @PutMapping("/")
    public Video updateVideo(@RequestBody Video video) throws ResourceNotFoundException {
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

    @PutMapping(ConstantsUtils.SELECTED_VIDEO)
    public List<Video> selectedVideos(@RequestBody List<Video> videos) throws ResourceNotFoundException {
        return videoService.selectedVideos(videos);
    }

    @GetMapping(ConstantsUtils.TITLE_VIDEO+"/{title}")
    public List<Video> findByTitle(@PathVariable("title") String title) throws ResourceNotFoundException {
        return videoService.findByTitle(title);
    }

    @PostMapping(ConstantsUtils.FILTER_VIDEO)
    public List<Video> findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(@RequestBody Map<String,Object> params) throws ResourceNotFoundException {
        List<Integer> lessonIds = params.get("lessonIds") != null ? (List<Integer>) params.get("lessonIds"): new ArrayList<Integer>();
        String title = params.get("title") != null ? (String) params.get("title"):"";
        String tag = params.get("tag") != null ? (String) params.get("tag"):"";
        return videoService.findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(lessonIds,tag,title);
    }

    @PostMapping(ConstantsUtils.SELECTED_VIDEO_DETAILS)
    public List<Video> findAllSelectedVideoDetails(@RequestBody List<Integer> videoIds) throws ResourceNotFoundException {
        return videoService.findAllSelectedVideoDetails(videoIds);
    }
}
