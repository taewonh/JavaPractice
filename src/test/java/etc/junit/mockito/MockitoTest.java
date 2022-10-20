package etc.junit.mockito;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

/*
* 모킹을 사용함을 명시적으로 알림
* 해당 어노테이션으로 인해 MockitoAnnotations.openMocks를 사용하지 않아도 됨
* */
@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
    private Member member;

    @BeforeEach
    public void setUp() {
        /*
        * 어노테이션 기반으로 모킹했음을 알림
        * 상단 MockitoExtension으로 인해 필요는 없음
        * */
        MockitoAnnotations.openMocks(this);
        given(member.getId()).willReturn(10);
    }

    @Test
    @DisplayName("실제값 7이 아닌 10을 Return 하는 MockMember 테스트")
    void mockTest() {
        assertThat(member.getId()).isEqualTo(10);
    }
}
