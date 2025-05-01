package study.study.post.service

import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import study.study.common.exception.InvalidInputException
import study.study.member.repository.MemberRepository
import study.study.post.dto.PostDtoRequest
import study.study.post.entity.PostEntity
import study.study.post.repository.PostRepository

@Transactional
@Service
class PostService(
    private val postRepository: PostRepository,
    private val memberRepository: MemberRepository
) {
    /**
     * 게시글 작성
     */
    fun posting(postDtoRequest: PostDtoRequest, userId: Long): String {
        val member = memberRepository.findByIdOrNull(userId)
            ?: throw InvalidInputException("해당하는 유저가 없습니다.")

        val post = postDtoRequest.toEntity(member.name)
        postRepository.save(post)
        return "게시글 작성 완료"
    }
    /**
     *  전체 게시글 가져오기
     */
    fun allGetPosts() : MutableList<PostEntity> {
        return postRepository.findAll()
    }
    /**
     *  특정 게시판 가져오기
     */
    fun getPost(postId: Long) : PostEntity {
        val post = postRepository.findByIdOrNull(postId)
            ?: throw InvalidInputException("게시글 번호 : $postId 존재하지 않는 게시글 입니다.")
        return post
    }
}