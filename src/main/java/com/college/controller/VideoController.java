package com.college.controller;

import com.college.entity.Video;
import com.college.exception.ResourceNotFoundException;
import com.college.service.VideoService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.VIDEO)
public class VideoController {

    @Autowired
    private VideoService videoService;

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

    @PutMapping(ConstantsUtils.SELECTED_VIDEO)
    public List<Video> selectedVideos(List<Video> videos) throws ResourceNotFoundException {
        return videoService.selectedVideos(videos);
    }

    @GetMapping(ConstantsUtils.TITLE_VIDEO+"/{title}")
    public List<Video> findByTitle(@PathVariable("title") String title) throws ResourceNotFoundException {
        return videoService.findByTitle(title);
    }

    @GetMapping(ConstantsUtils.TITLE_VIDEO+"/{title}")
    public List<Video> findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(@RequestParam Map<String,Object> params) throws ResourceNotFoundException {
        List<Integer> lessonIds = params.get("lessonIds") != null ? (List<Integer>) params.get("lessonIds"): new ArrayList<Integer>();
        String title = params.get("title") != null ? (String) params.get("title"):"";
        String tag = params.get("tag") != null ? (String) params.get("tag"):"";
        return videoService.findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(lessonIds,tag,title);
    }

    @GetMapping(ConstantsUtils.TITLE_VIDEO+"/{videoIds}")
    public List<Video> findAllSelectedVideoDetails(@PathVariable("videoIds") List<Integer> videoIds) throws ResourceNotFoundException {
        return videoService.findAllSelectedVideoDetails(videoIds);
    }
}
