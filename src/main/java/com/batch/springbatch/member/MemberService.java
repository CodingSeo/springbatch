package com.batch.springbatch.member;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDto.Info getMember(Long id) {
        return memberRepository.findById(id)
                .map(MemberDto.Info::of)
                .orElseThrow(() -> new RuntimeException("test"));
    }

    @Timed("test")
    @Async(value = "asyncTaskExecutor")
    public MemberDto.Info saveMember(MemberDto.Save saveDto) {
        log.info(Thread.currentThread().getId());
        Member save = memberRepository.save(Member.builder()
                .name(saveDto.getName())
                .age(saveDto.getAge())
                .build()
        );
        return MemberDto.Info.of(save);
    }
}
