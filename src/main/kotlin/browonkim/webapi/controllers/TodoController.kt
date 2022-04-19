package browonkim.webapi.controllers

import browonkim.webapi.members.Todo
import browonkim.webapi.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TodoController constructor(val todoService: TodoService) {

    @CrossOrigin(origins = ["*"])
    @GetMapping("/todo")
    fun getTodo(): ResponseEntity<Iterable<Todo>> {
        return todoService.getTodoElement()
    }
}
