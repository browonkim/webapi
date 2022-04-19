package browonkim.webapi.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller("/todo")
class TodoController {

    @GetMapping
    fun getTodo() {

    }
}
