package com.college;

import com.college.controller.CourseController;
import com.college.controller.LessonController;
import com.college.controller.SubjectController;
import com.college.entity.Course;
import com.college.entity.Subject;
import com.college.utils.ConstantsUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class SubjectControllerTest extends CollegeManagementApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @MockBean
    private SubjectController subjectController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getArrivals() throws Exception {

        ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
        Subject subject = new Subject();
        subject.setName("Y-Test");
        List<Subject> subjectList = new ArrayList<>();
        given(subjectController.listSubject()).willReturn(r);

        mockMvc.perform(get(ConstantsUtils.BASE_URL + ConstantsUtils.SUBJECT + ConstantsUtils.ALL_LIST)
                      .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getArrivalsById() throws Exception {

        ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
        Optional<Subject> subject = Optional.of(new Subject());
        given(subjectController.getSubject(subject.get().getId())).willReturn(r);

        mockMvc.perform(get(ConstantsUtils.BASE_URL + ConstantsUtils.SUBJECT + ConstantsUtils.ALL_LIST)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}


