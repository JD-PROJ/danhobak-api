package com.jidong.danhobak.config.auth.dto;

import com.jidong.danhobak.domain.user.User;
import java.io.Serializable;
import lombok.Getter;

//SessionUser���� ������ ����� ������ �ʿ�
//User Ŭ������ �״�� ����ϸ� ����ȭ ������ �߻���.
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
