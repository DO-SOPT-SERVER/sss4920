package org.third.thirdseminar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
	@Test
	void name(){
	}
	private PasswordStrengthMeter meter = new PasswordStrengthMeter();

	private void assertStrength(String password, PasswordStrength expStr){
		PasswordStrength result = meter.meter(password);
		assertEquals(expStr, result);
	}

	@Test
	void meetsAllCreteria_Then_Strong(){
		//코드 작성해야함
		assertStrength("ab12!@AB", PasswordStrength.STRONG);
		assertStrength("abc1!Add", PasswordStrength.STRONG);
	}
	@Test
	@DisplayName("두번째 조건 테스트")
	void meetsOtherCreteria_except_for_Length_Then_Normal(){
		//코드 작성해야함
		assertStrength("ab12!@A", PasswordStrength.NORMAL);
		assertStrength("Ab12!c", PasswordStrength.NORMAL);
	}
	@Test
	@DisplayName("세번째 조건 테스트")
	void meetsOtherCreteria_except_for_number_Then_Normal(){
		//코드 작성해야함
		assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
	}
	@Test
	@DisplayName("네번째 조건 테스트")
	void nullInput_Then_Invalid(){
		//코드 작성해야함
		assertStrength(null, PasswordStrength.INVALID);
	}
	@Test
	@DisplayName("다섯번째 조건 테스트")
	void EmptyInput_Then_Invalid(){
		//코드 작성해야함
		assertStrength("", PasswordStrength.INVALID);
	}

	@Test
	@DisplayName("여섯번째 조건 테스트")
	void meetsOtherCreteria_except_for_Uppercase_Then_Normal(){
		assertStrength("ab12!@df", PasswordStrength.NORMAL);
	} //여기까지 통과시키고 이제 복잡해진 meter 메서드를 메서드 추출을 이용해서 코드를 정리.

	@Test
	@DisplayName("일곱번째 조건 테스트")
	void meetsOnlyLengthCriteria_Then_Weak(){
		assertStrength("abdefghi", PasswordStrength.WEAK);
	}

	@Test
	@DisplayName("여덟번째 조건 테스트")
	void meetsOnlyNumCriteria_Then_Weak(){
		assertStrength("12345", PasswordStrength.WEAK);
	}

	@Test
	@DisplayName("아홉번째 조건 테스트")
	void meetsOnlyUpperCriteria_Then_Weak(){
		assertStrength("ABZEF", PasswordStrength.WEAK);
	}

	@Test
	@DisplayName("열번째 조건 테스트")
	void meetsNoCreteria_Then_Weak(){
		assertStrength("abc", PasswordStrength.WEAK);
	}
}
