package study.study.post.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.study.post.entity.PostEntity

interface PostRepository: JpaRepository<PostEntity, Long>