package com.college;

import com.college.controller.CourseController;
import com.college.controller.SubjectController;
import com.college.controller.VideoController;
import com.college.entity.Course;
import com.college.entity.Video;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class VideoControllerTest extends CollegeManagementApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @MockBean
    private VideoController videoController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void getArrivals() throws Exception {

        Video video = new Video();
        video.setTitle("Y-Test");
        List<Video> videoList = new ArrayList<>();
        given(videoController.listVideo()).willReturn(videoList);

        mockMvc.perform(get(ConstantsUtils.BASE_URL + ConstantsUtils.VIDEO + ConstantsUtils.ALL_LIST)
                      .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getArrivalsById() throws Exception {

        Optional<Video> video = Optional.of(new Video());
        given(videoController.getVideo(video.get().getId())).willReturn(video);

        mockMvc.perform(get(ConstantsUtils.BASE_URL + ConstantsUtils.VIDEO + ConstantsUtils.ALL_LIST)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}


