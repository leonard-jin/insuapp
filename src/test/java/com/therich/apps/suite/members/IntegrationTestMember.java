//package com.therich.apps.suite.members;
//
//import com.therich.apps.Application;
//import com.therich.apps.core.members.usecase.MemberRegisterUseCase;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Created by kh.jin on 2020. 2. 28.//package com.therich.apps.suite.members;
////
////import com.therich.apps.Application;
////import com.therich.apps.core.members.usecase.MemberRegisterUseCase;
////import org.junit.runner.RunWith;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.http.MediaType;
////import org.springframework.test.context.TestPropertySource;
////import org.springframework.test.context.junit4.SpringRunner;
////import org.springframework.test.web.servlet.MockMvc;
////
////import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
////import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
////import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
////import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
////
/////**
//// * Created by kh.jin on 2020. 2. 28.
//// */
////@RunWith(SpringRunner.class)
////@SpringBootTest(value = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
////@AutoConfigureMockMvc
////@TestPropertySource(locations = "classpath:application-integrationtest.yml")
////public class IntegrationTestMember {
////
////    @Autowired
////    private MockMvc mvc;
////
////    @Autowired
////    private MemberRegisterUseCase useCase;
////
////    public void test_멤버생성() {
////        useCase.join(MemberRegisterUseCase.Request.builder().build());
////        mvc.perform(get("/api/employees")
////                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(content()
////                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
////                .andExpect(jsonPath("$[0].name", is("bob")));
////    }
////    }
////}
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(value = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-integrationtest.yml")
//public class IntegrationTestMember {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private MemberRegisterUseCase useCase;
//
//    public void test_멤버생성() {
//        useCase.join(MemberRegisterUseCase.Request.builder().build());
//        mvc.perform(get("/api/employees")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$[0].name", is("bob")));
//    }
//    }
//}
