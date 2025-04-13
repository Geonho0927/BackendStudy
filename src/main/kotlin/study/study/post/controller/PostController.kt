package study.study.post.controller

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.study.common.dto.BaseResponse
import study.study.post.dto.PostDtoRequest
import study.study.post.service.PostService

@RequestMapping("/api/member")
@RestController
class PostController (
    private val postService: PostService,
) {
    /**
     * 게시글 작성
     */
    fun posting(@RequestBody @Valid postDtoRequest: PostDtoRequest): BaseResponse<String> {
        val result = postService.posting(postDtoRequest)
        return BaseResponse(result)
    }
}