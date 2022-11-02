package com.batch.springbatch.member;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MemberDto {

    @Builder
    @Getter
    @AllArgsConstructor
    public static class Info {
        private Long id;

        private String name;

        private Integer age;

        public static Info of(Member member) {
            return Info.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .age(member.getAge())
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Save {
        @NotEmpty
        private String name;
        @NotNull
        private Integer age;
    }
}
