package org.third.thirdseminar;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.third.thirdseminar.domain.Member;
import org.third.thirdseminar.domain.Part;
import org.third.thirdseminar.domain.SOPT;
import org.third.thirdseminar.infrastructure.MemberJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MemberJpaRepository memberJpaRepository;

	@Test
	public void memberGetController() throws Exception{

		//mockMvc에게 컨트롤러에 대한 정보를 입력하자.

		mockMvc.perform(
			MockMvcRequestBuilders.get("/api/member/{memberId}",13) //해당 url로 요청을 한다.
				.contentType(MediaType.APPLICATION_JSON)
			) // Json 타입으로 지정
				.andExpect(status().isOk()) // 응답 status를 ok로 테스트
				.andDo(print());// .andExpect(content().string("This will return get URI.")); // 응답값 print
	}

	@Test
	public void memberPostController() throws Exception{

		//mockMvc에게 컨트롤러에 대한 정보를 입력하자.
		String content = objectMapper.writeValueAsString(new MemberCreateRequestTest("윤한","하잉",20, new SOPT(20, Part.SERVER)));

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/member") //해당 url로 요청을 한다.
					.contentType(MediaType.APPLICATION_JSON)
					.content(content)
			) // Json 타입으로 지정
			.andExpect(status().isOk()) // 응답 status를 ok로 테스트
			.andExpect(content().string("")) // 응답값 print
			.andDo(print());
	}

	@Test
	public void memberPatchController() throws Exception{

		//mockMvc에게 컨트롤러에 대한 정보를 입력하자.
		String content = objectMapper.writeValueAsString(new MemberProfileUpdateTest(20,Part.DESIGN));
		Member user = Member.builder()
			.name("test")
			.nickname("하이용")
			.age(20)
			.sopt(new SOPT(20,Part.SERVER))
			.build();

		memberJpaRepository.save(user);



		mockMvc.perform(
				MockMvcRequestBuilders.patch("/api/member/{memberId}",13) //해당 url로 요청을 한다.
					.contentType(MediaType.APPLICATION_JSON)
					.content(content)
			) // Json 타입으로 지정
			.andExpect(status().isOk()) // 응답 status를 ok로 테스트
			.andDo(print());
	}

	@Test
	public void memberDeleteController() throws Exception{

		//mockMvc에게 컨트롤러에 대한 정보를 입력하자.
		Member user = Member.builder()
			.name("test")
			.nickname("하이용")
			.age(20)
			.sopt(new SOPT(20,Part.SERVER))
			.build();

		memberJpaRepository.save(user);



		mockMvc.perform(
				MockMvcRequestBuilders.delete("/api/member/{memberId}",13) //해당 url로 요청을 한다.
					.contentType(MediaType.APPLICATION_JSON)
			) // Json 타입으로 지정
			.andExpect(status().isNoContent()) // 응답 status를 ok로 테스트
			.andDo(print());
	}
}
