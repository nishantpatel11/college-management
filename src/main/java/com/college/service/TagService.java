package com.college.service;

import com.college.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    Tag createTag(Tag tag);
    Tag updateTag(Tag tag);
    Optional<Tag> getTag(Integer tagId);
    List<Tag> listTag();

}
