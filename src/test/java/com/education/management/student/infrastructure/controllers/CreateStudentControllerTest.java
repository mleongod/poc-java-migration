package com.education.management.student.infrastructure.controllers;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.education.management.EducationManagementApplication;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@ActiveProfiles("integration-test")
@AutoConfigureMockMvc
@SpringBootTest(
    classes = EducationManagementApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT,
    properties = {
        // solve problem with Apple M1
        // https://stackoverflow.com/questions/60074168/java-lang-illegalstateexception-no-server-alpnprocessors-wiremock
        "wiremock.server.httpsPort=-1"
    }
)
public class CreateStudentControllerTest {

  private static final MongoDBContainer MONGODB_CONTAINER = new MongoDBContainer(
      DockerImageName.parse("mongo:4.0.0"))
      .withStartupTimeout(Duration.ofSeconds(10));
  @Autowired
  protected MockMvc mvc;

  @BeforeAll
  public static void beforeAll() {
    MONGODB_CONTAINER.start();
  }

  @AfterAll
  public static void afterAll() {
    MONGODB_CONTAINER.stop();
  }

  @DynamicPropertySource
  private static void registerProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.data.mongodb.uri", MONGODB_CONTAINER::getReplicaSetUrl);
  }

  @Test
  void contextLoads() {
    Assertions.assertTrue(true);
  }


  @Test
  void studentCreatedSuccessfully() throws Exception {
    mvc.perform(
        MockMvcRequestBuilders.
            post("/student")
            .content("{\"name\":\"test\",\"email\":\"email@test.com\",\"age\":30}")
            .contentType(MediaType.APPLICATION_JSON)
    ).andDo(print())
        .andExpect(content().json("{\"name\":\"test\",\"email\":\"email@test.com\",\"age\":30, \"grade\":null, \"section\":null}"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(is(notNullValue())))
        .andExpect(status().isCreated());
  }
}
