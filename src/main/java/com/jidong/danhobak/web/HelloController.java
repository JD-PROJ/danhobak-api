package com.jidong.danhobak.web;

import com.jidong.danhobak.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // ��Ʈ�ѷ��� JSON�� ��ȯ�ϴ� ��Ʈ�ѷ��� ����� ��. ResponseBody�� �޼ҵ帶�� ������ �ʿ� x
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello jijidong";
    }

    @GetMapping("hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
