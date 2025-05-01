package study.study.post.controller

import com.fasterxml.jackson.databind.ser.Serializers.Base
import jakarta.validation.Valid
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*
import study.study.common.dto.BaseResponse
import study.study.common.dto.CustomUser
import study.study.post.dto.PostDtoRequest
import study.study.post.entity.PostEntity
import study.study.post.service.PostService

@RequestMapping("/api/post")
@RestController
class PostController (
    private val postService: PostService,
) {
    /**
     * 게시글 작성
     */
    @PostMapping("/")
    fun posting(@RequestBody @Valid postDtoRequest: PostDtoRequest): BaseResponse<Unit> {
        val userId = (SecurityContextHolder.getContext().authentication.principal as CustomUser).userId
        val result = postService.posting(postDtoRequest, userId)
        return BaseResponse(result)
    }
    /**
     *  전체 게시글 가져오기
     */
    @GetMapping("/")
    fun allGetPosts() : BaseResponse<MutableList<PostEntity>> {
        val list = postService.allGetPosts()
        return BaseResponse(data = list)
    }
    /**
     *  특정 게시판 가져오기
     */
    @GetMapping("/{id}")
    fun getPosts(@PathVariable id : Long) : BaseResponse<PostEntity> {
        val result = postService.getPost(id)
        return BaseResponse(data = result)
    }
}