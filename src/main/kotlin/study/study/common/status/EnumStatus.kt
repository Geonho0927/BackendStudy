package study.study.common.status

enum class Dormitory(val desc: String) {
    GOWOONA("고운A"),
    GOWOONB("고운B"),
    GOWOONC("고운C"),
    GYOUNGSANG11("경상11"),
    GYOUNGSANG12("경상12"),
    GYOUNGSANG13("경상13"),
    GYOUNGSANG14("경상14"),
}

enum class ResultCode(val msg: String) {
    SUCCESS("정상 처리 되었습니다."),
    ERROR("에러가 발생했습니다."),
}