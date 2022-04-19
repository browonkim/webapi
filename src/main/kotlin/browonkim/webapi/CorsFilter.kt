package browonkim.webapi

import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CorsFilter : Filter {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        response as HttpServletResponse
        response.setHeader("Access-Control-Allow-Origin", "*")
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS")
        response.setHeader("Access-Control-Max-Age", "3600")
        response.setHeader(
            "Access-Control-Allow-Headers",
            "X-Requested-With, Authorization, Origin, Content-Type, Version, encType, Range"
        )
        response.setHeader(
            "Access-Control-Expose-Headers",
            "X-Requested-With, Authorization, Origin, Content-Type,  Accept-Ranges, Content-Encoding, Content-Length, Content-Range, Content-Disposition"
        )
        response.setHeader("Cache-Control", "no-cache")
        response.setHeader("Pragma", "no-cache")
        response.setDateHeader("Expires", -1)
        response.setHeader("X-Frame-Options", "SAMEORIGIN")
        response.setHeader("X-Content-Type-Options", "nosniff")
        response.setHeader("X-XSS-Protection", "1;mode=block")

        request as HttpServletRequest
        if (request.method == "OPTIONS") {
            response.status = HttpServletResponse.SC_OK
        } else {
            chain?.doFilter(request, response)
        }
    }
}
