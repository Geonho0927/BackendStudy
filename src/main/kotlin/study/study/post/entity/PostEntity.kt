package study.study.post.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class PostEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 30, updatable = true)
    val title: String,

    @Column(nullable = false, length = 500, updatable = true)
    val content: String,

    @Column(nullable = false, updatable = true)
    val likes: Long,

    @Column(nullable = false, updatable = true)
    val dislikes: Long,

    @Column(nullable = false, length = 10, updatable = false)
    val writer: String,

    @Column(nullable = false, length = 30, updatable = false)
    val createDate: LocalDateTime
)