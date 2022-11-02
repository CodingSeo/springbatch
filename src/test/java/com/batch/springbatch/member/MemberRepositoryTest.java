package com.batch.springbatch.member;

import com.batch.springbatch.tools.RandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(excludeAutoConfiguration = {TestDatabaseAutoConfiguration.class})
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("save 메서드는 member를 저장 한다")
    public void save() {
        //given
        Member member = Member.builder()
                .age(RandomGenerator.randomInt())
                .name(RandomGenerator.randomString())
                .build();

        //when
        Member save = memberRepository.save(member);

        //then
        assertThat(save.getId()).isNotNull();
    }
}
