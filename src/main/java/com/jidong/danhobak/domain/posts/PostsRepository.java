package com.jidong.danhobak.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
 //JpaRepository 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨. @Repository 해줄필요없음.

}