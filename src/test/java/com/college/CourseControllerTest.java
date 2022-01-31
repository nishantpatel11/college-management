package com.college;

import com.college.controller.CourseController;
import com.college.entity.Course;
import com.college.utils.ConstantsUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CourseControllerTest extends CollegeManagementApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @MockBean
    private CourseController courseController;

    @Test
    public void getArrivals() throws Exception {

        Course course = new Course();
        course.setName("Y-Test");
        List<Course> courseList = new ArrayList<>();
//        given(courseController.listCourse()).willReturn(courseList);

        mockMvc.perform(get(ConstantsUtils.BASE_URL + ConstantsUtils.COURSE + ConstantsUtils.ALL_LIST)
                      .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getArrivalsById() throws Exception {

        Optional<Course> course = Optional.of(new Course());
//        given(courseController.getCourse(course.get().getId())).willReturn(course);

        mockMvc.perform(get(ConstantsUtils.BASE_URL + ConstantsUtils.COURSE + ConstantsUtils.ALL_LIST)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}


