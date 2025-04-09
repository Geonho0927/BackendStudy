package study.study.member.dto

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import study.study.common.status.Dormitory
import jakarta.validation.constraints.Pattern
import study.study.common.annotation.ValidEnum
import study.study.member.entity.Member
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class MemberDtoRequest(
    val id: Long?,

    @field:NotBlank
    @JsonProperty("lginId")
    private val _loginId: String?,

    @field:NotBlank
    @field:Pattern(
        regexp = "\"^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#\\\$%^&*])[a-zA-Z0-9!@#\\\$%^&*]{8,20}\\\$",
        message = "영문, 숫자, 특수문자를 포함한 8-20자리로 입력해주세요"
        )
    @JsonProperty("password")
    private val _password: String?,

    @field:NotBlank
    @JsonProperty("name")
    private val _name: String?,

    @field:NotBlank
    @field:ValidEnum(
        enumClass = Dormitory::class,
        message = "GOWOONA, GOWOONB, GOWOONC, GYOUNGSANG11, GYOUNGSANG12, GYOUNGSANG13, GYOUNGSANG14 중 하나를 선택해주세요.")
    @JsonProperty("dormitory")
    private val _dormitory: String?,

    @field:NotBlank
    @field:Email
    @JsonProperty("email")
    private val _email: String?,
) {
    val loginId: String
        get() = _loginId!!
    val password: String
        get() = _password!!
    val name: String
        get() = _name!!
    val dormitory: Dormitory
        get() = Dormitory.valueOf(_dormitory!!)
    val email: String
        get() = _email!!


    fun toEntity(): Member =
        Member(id, loginId, password, name, dormitory, email)
}

data class LoginDto(
    @field:NotBlank
    @JsonProperty("loginId")
    private val _loginId: String?,

    @field:NotBlank
    @JsonProperty("password")
    private val _password: String?,
) {
    val loginId: String
        get() = _loginId!!
    val password: String
        get() = _password!!
}