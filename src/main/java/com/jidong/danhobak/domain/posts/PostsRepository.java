package com.jidong.danhobak.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
 //JpaRepository ����ϸ� �⺻���� CRUD �޼ҵ尡 �ڵ����� ������. @Repository �����ʿ����.

}