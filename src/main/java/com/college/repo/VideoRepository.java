package com.college.repo;

import com.college.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

    List<Video> findAll();
    Optional<Video> findById(Integer id);

    @Transactional
    @Modifying
    @Query(value ="SELECT v FROM video v  where v.title like '%?1%'", nativeQuery = true)
    List<Video> findByTitle(String titleName);

    @Transactional
    @Modifying
    @Query(value = "SELECT v FROM video v inner join lesson l on v.video_id = l.video_id and v.active = true right join tag t on tag on v.video_id = t.video_id where l.lesson_id in ?1 and l.is_selected = true and v.title like '%?2%' or t.name like '%?3%'", nativeQuery = true)
    List<Video> findAllActiveVideoSelectedLessonAndFilterByVideoAndTagName(List<Integer> lessonIds, String title,String tagName);

    @Transactional
    @Modifying
    @Query(value = "SELECT v FROM video v where v.active = true and v.is_selected = true and v.video_id in ?1", nativeQuery = true)
    List<Video> findAllSelectedVideoDetails(List<Integer> videoIds);

    @Transactional
    @Modifying
    @Query(value = "Select TOP 1 v.* from (select count(ref_id) as most_views from video vi inner join view v on vi.video_id = v.ref_id where v.type ='VIDEO' group by v.ref_id) viewed inner join Video v on v.video_id = viewed.most_views ", nativeQuery=true)
    Video findMaxViewsOfVideos();

}
