package com.college.service.impl;

import com.college.entity.Tag;
import com.college.repo.TagRepository;
import com.college.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;
    private static Logger logger =  LoggerFactory.getLogger(TagServiceImpl.class);

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Optional<Tag> getTag(Integer tagId) {
        return tagRepository.findById(tagId);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }
}
