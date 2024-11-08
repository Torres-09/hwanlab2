package com.hwanlab2.controller;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hwanlab2.service.LabService;

@WebMvcTest(controllers = LabController.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class LabControllerTest {
	@Autowired
	private WebApplicationContext context;
	@MockBean
	private LabService labService;

	private MockMvc mockMvc;

	@BeforeEach
	public void setUp(RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
			.apply(documentationConfiguration(restDocumentation))
			.build();
	}

	@Test
	@DisplayName("bye를 결과로 반환합니다.")
	void bye를_결과로_반환하는_테스트() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/bye")
				.param("greeting", "hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("bye"))
			.andDo(document("bye",
				queryParameters(
					parameterWithName("greeting").description("인사말 메시지")
				),
				responseBody()
			));
	}
}