package com.simple.basic.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemoVO {
    private Long mno;
    @Size(min = 5, message = "메모는 최소 5글자 이상이어야 합니다.")
    private String memo;
    @Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message = "전화번호 형식이 일치하지 않습니다.")
    private String phone;
    @Pattern(regexp = "[0-9]{4}$", message = "비밀번호는 4자여야합니다.")
    private String pw;
    private String secret = "n";
}
