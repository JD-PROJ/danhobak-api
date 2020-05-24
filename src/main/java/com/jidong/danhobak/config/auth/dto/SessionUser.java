package com.jidong.danhobak.config.auth.dto;

import com.jidong.danhobak.domain.user.User;
import java.io.Serializable;
import lombok.Getter;

//SessionUser에는 인증된 사용자 정보만 필요
//User 클래스를 그대로 사용하면 직렬화 오류가 발생함.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
