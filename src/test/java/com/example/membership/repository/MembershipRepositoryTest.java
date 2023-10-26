package com.example.membership.repository;

import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
// @DataJpaTest: JPA Repository들에 대한 빈들을 등록하여 단위 테스트의 작성을 용이하게 함
// 또한 테스트를 위해서는 테스트 컨텍스트를 잡아주어야 할텐데,
// @DataJpaTest는 내부적으로 @ExtendWith( SpringExtension.class) 어노테이션을 가지고 있어서, 이 어노테이션만 붙여주면 된다.
// @Transactional 어노테이션이 있어서, 테스트의 롤백 등을 위해 별도로 트랜잭션 어노테이션을 추가하지 않아도 된다.
public class MembershipRepositoryTest {

    @Autowired
    private MembershipRepository membershipRepository;

    @Test
    public void 멤버십등록() {
        // given
        final Membership membership = Membership.builder()
                .userId("userId")
                .membershipType(MembershipType.NAVER)
                .point(10000)
                .build();

        // when
        final Membership result = membershipRepository.save(membership);

        // then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getUserId()).isEqualTo("userId");
        assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);
        assertThat(result.getPoint()).isEqualTo(10000);
    }

}

// DataJpaTest annotation =>
//@ExtendWith(SpringExtension.class)
//@OverrideAutoConfiguration(enabled = false)
//@TypeExcludeFilters(DataJpaTypeExcludeFilter.class)
//@Transactional
//@AutoConfigureCache
//@AutoConfigureDataJpa
//@AutoConfigureTestDatabase
//@AutoConfigureTestEntityManager
//@ImportAutoConfiguration
//public @interface DataJpaTest {
//
//}
