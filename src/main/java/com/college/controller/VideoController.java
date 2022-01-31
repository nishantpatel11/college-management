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
    public ResponseEntity<Video> updateVideo(@RequestBody Video video) throws ResourceNotFoundException {
        return new ResponseEntity<Video> (videoService.updateVideo(video), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Video>> getVideo(@PathVariable ("id") Integer id) throws ResourceNotFoundException {
        return new ResponseEntity <Optional<Video>>(videoService.getVideo(id), HttpStatus.OK);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public ResponseEntity<List<Video>> listVideo(){
        return new ResponseEntity <List<Video>> (videoService.listVideo(), HttpStatus.OK);
    }

    @PutMapping(ConstantsUtils.SELECTED_VIDEO)
    public ResponseEntity<List<Video>> selectedVideos(@RequestBody List<Video> videos) throws ResourceNotFoundException {
        return new ResponseEntity<List<Video>> (videoService.selectedVideos(videos), HttpStatus.OK);
    }

    @GetMapping(ConstantsUtils.TITLE_VIDEO+"/{title}")
    public ResponseEntity<List<Video>> findByTitle(@PathVariable("title") String title) throws ResourceNotFoundException {
        return new ResponseEntity<List<Video>> (videoService.findByTitle(title), HttpStatus.OK);
    }

    @PostMapping(ConstantsUtils.FILTER_VIDEO)
    public ResponseEntity<List<Video>> findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(@RequestBody Map<String,Object> params) throws ResourceNotFoundException {
        List<Integer> lessonIds = params.get("lessonIds") != null ? (List<Integer>) params.get("lessonIds"): new ArrayList<Integer>();
        String title = params.get("title") != null ? (String) params.get("title"):"";
        String tag = params.get("tag") != null ? (String) params.get("tag"):"";
        return new ResponseEntity<List<Video>> (videoService.findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(lessonIds,tag,title), HttpStatus.OK);
    }

    @PostMapping(ConstantsUtils.SELECTED_VIDEO_DETAILS)
    public ResponseEntity<List<Video>> findAllSelectedVideoDetails(@RequestBody List<Integer> videoIds) throws ResourceNotFoundException {
        return new ResponseEntity<List<Video>> (videoService.findAllSelectedVideoDetails(videoIds), HttpStatus.OK);
    }
}
