package com.college.repo;

import com.college.entity.Course;
import com.college.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAll();
    Optional<Course> findById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "SELECT c FROM course c inner join subject s on s.course_id = c.course_id and c.active = true where s.subject_id in ?1", nativeQuery=true)
    List<Course> findAllActiveCourseBySubject(List<Integer> subjectIds);

    @Transactional
    @Modifying
    @Query(value = "SELECT c FROM lesson l inner join course c on c.lesson_id = l.lesson_id and l.active = true where c.course_id in ?1 and c.is_selected = true", nativeQuery=true)
    List<Course> findSelectedCourseforAllActiveLessons(List<Integer> courseIds);

    @Transactional
    @Modifying
    @Query(value = "Select TOP 1 c.* from (select count(ref_id) as most_views from course c inner join view v on c.course_id = v.ref_id where v.type ='COURSE' group by ref_id) viewed inner join course c on c.course_id = viewed.most_views " +
            "select c.name, max(v.ref_id) from course c inner join view v on c.course_id = v.ref_id where v.type ='COURSE' group by ref_id , c.name", nativeQuery=true)
    Course findMaxViewsOfCourses();

}
