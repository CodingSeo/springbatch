package com.batch.springbatch.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Log4j2
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public MemberDto.Info getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PostMapping
    public MemberDto.Info getMember(@Validated @RequestBody MemberDto.Save save) {
        log.info(Thread.currentThread().getId());
        return memberService.saveMember(save);
    }
}
