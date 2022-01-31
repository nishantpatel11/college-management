package com.college.controller;

import com.college.entity.Tag;
import com.college.entity.User;
import com.college.service.TagService;
import com.college.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestControllerAdvice
@RequestMapping(ConstantsUtils.BASE_URL + ConstantsUtils.TAG)
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        return new  ResponseEntity<Tag> (tagService.createTag(tag),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag){
        return new ResponseEntity<Tag>(tagService.updateTag(tag), HttpStatus.OK);
    }

    @GetMapping("/{tagId}")
   public ResponseEntity<Optional<Tag>> getTag(@PathVariable ("tagId") Integer tagId){
        return new ResponseEntity<Optional<Tag>> (tagService.getTag(tagId), HttpStatus.OK);
    }

    @GetMapping(ConstantsUtils.ALL_LIST)
    public ResponseEntity<List<Tag>> listTag(){
        return new ResponseEntity<List<Tag>> (tagService.listTag(), HttpStatus.OK);
    }


}
