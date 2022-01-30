package com.college.controller;

import com.college.entity.Course;
import com.college.entity.Tag;
import com.college.service.TagService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.TAG)
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/")
    public Tag createTag(Tag tag){
        return tagService.createTag(tag);
    }

    @PutMapping("/")
    public Tag updateTag(Tag tag){
        return tagService.updateTag(tag);
    }

    @GetMapping("/{tagId}")
   public Optional<Tag> getTag(@PathVariable ("tagId") Integer tagId){
        return tagService.getTag(tagId);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public List<Tag> listTag(){
        return tagService.listTag();
    }


}
