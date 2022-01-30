package com.college;

import com.college.controller.CourseController;
import com.college.controller.SubjectController;
import com.college.controller.UserController;
import com.college.entity.Course;
import com.college.entity.User;
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


public class UserControllerTest extends CollegeManagementApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @MockBean
    private UserController userController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void getArrivals() throws Exception {

        User user = new User();
        user.setName("U-Test");
        List<User> userList = new ArrayList<>();
        given(userController.listUser()).willReturn(userList);

        mockMvc.perform(get(ConstantsUtils.BASE_URL + ConstantsUtils.USER + ConstantsUtils.ALL_LIST)
                      .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getArrivalsById() throws Exception {

        Optional<User> user = Optional.of(new User());
        given(userController.getUser(user.get().getUserId())).willReturn(user);

        mockMvc.perform(get(ConstantsUtils.BASE_URL + ConstantsUtils.USER + ConstantsUtils.ALL_LIST)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}


