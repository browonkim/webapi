package browonkim.webapi.commonUtils

fun isStringEmpty(string: String?): Boolean {
    if (string == null) {
        return true
    }
    if (string.trim() == "") {
        return true
    }
    return false
}
