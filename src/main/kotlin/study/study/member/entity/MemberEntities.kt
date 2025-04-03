package study.study.member.entity

import jakarta.persistence.*
import study.study.common.status.Dormitory
import java.time.LocalDate

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_member_login_id", columnNames = ["loginId"])]
)
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false, length = 30, updatable = false)
    val loginId: String,

    @Column(nullable = false, length = 100)
    val password: String,

    @Column(nullable = false, length = 10)
    val name: String,

    @Column(nullable = false, length = 5)
    @Enumerated(EnumType.STRING)
    val dormitory: Dormitory,

    @Column(nullable = false, length = 30)
    val email: String,
)