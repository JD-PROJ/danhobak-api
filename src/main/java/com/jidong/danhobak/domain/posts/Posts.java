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
@NoArgsConstructor //�⺻������ �ڵ� ����
@Entity //jpa ������̼� : ���̺�� ��ũ�� Ŭ�������� ��Ÿ��
public class Posts {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk ������Ģ
    private Long id;

    @Column(length = 500, nullable = false) //���� ������ص� ������ ������ ���� �� �ʿ�
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
