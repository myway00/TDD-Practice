package com.example.membership.repository;

import com.example.membership.entity.Membership;
import com.example.membership.entity.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository 타입의 빈을 등록하기 위해서는 @Repository 어노테이션을 붙여주어야 한다.
// 그러나, JpaRepository 하위에 @Repository가 이미 붙어있으므로 @Repository를 붙여주지 않아도 된다.
public interface MembershipRepository extends JpaRepository<Membership, Long> {

    Membership findByUserIdAndMembershipType(final String userId, final MembershipType membershipType);

}