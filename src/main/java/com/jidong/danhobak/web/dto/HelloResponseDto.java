package com.jidong.danhobak.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor // ������ ��� final �ʵ尡 ���Ե� �����ڸ� ��������.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
