package study.study.post.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.NotBlank
import study.study.post.entity.PostEntity
import java.time.LocalDateTime

data class PostDtoRequest(
    val id: Long? = null,

    @field:NotBlank
    @JsonProperty("title")
    private val _title: String?,

    @field:NotBlank
    @JsonProperty("content")
    private val _content: String?,

    private val likes: Long= 0 ,
    private val dislikes: Long = 0,
    private val writer: String = "익명의 사용자",
    private val createDate: LocalDateTime = LocalDateTime.now()
) {
    val title: String
        get() = _title!!.toString()
    val content: String
        get() = _content!!.toString()

    fun toEntity(): PostEntity =
        PostEntity(null, title, content, likes, dislikes, writer, createDate)
}