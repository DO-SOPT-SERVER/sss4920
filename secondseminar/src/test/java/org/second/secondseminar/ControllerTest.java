package org.second.secondseminar;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.second.secondseminar.controller.MemberController;
import org.second.secondseminar.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void memberGetController() throws Exception{

		//mockMvc에게 컨트롤러에 대한 정보를 입력하자.

		mockMvc.perform(
			MockMvcRequestBuilders.get("/api/member/{memberId}",1) //해당 url로 요청을 한다.
				.contentType(MediaType.APPLICATION_JSON)
			) // Json 타입으로 지정
				.andExpect(status().isOk()) // 응답 status를 ok로 테스트
				.andExpect(content().string("This will return get URI.")); // 응답값 print
	}
}
