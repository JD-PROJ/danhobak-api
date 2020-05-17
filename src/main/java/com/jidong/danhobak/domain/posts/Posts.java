package com.jidong.danhobak.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본생성자 자동 생성
@Entity //jpa 어노테이션 : 테이블과 링크된 클래스임을 나타냄
public class Posts {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성규칙
    private Long id;

    @Column(length = 500, nullable = false) //굳이 선언안해도 되지만 조건을 변경 때 필요
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
