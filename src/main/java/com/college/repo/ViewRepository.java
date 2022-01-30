package com.college.repo;

import com.college.entity.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ViewRepository extends JpaRepository<View, Integer> {

//    @Query(value = "SELECT ref_id from view group by ref_id having type = 'COURSE')")
//    public Integer maxViewCourse();
//
//    @Query(value = "SELECT ref_id from view group by ref_id having type = 'VIDEO')")
//    public Integer maxViewVideo();

}
