package com.yonlog.coding.repository;

import com.yonlog.coding.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
