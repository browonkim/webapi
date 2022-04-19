package browonkim.webapi.controllers

import browonkim.webapi.members.Todo
import browonkim.webapi.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController constructor(val todoService: TodoService) {

    @CrossOrigin
    @GetMapping
    fun getTodo(): ResponseEntity<Iterable<Todo>> {
        return todoService.getTodoElements()
    }

    @CrossOrigin
    @PutMapping
    fun updateTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        return todoService.updateTodoElement(todo)
    }

    @CrossOrigin
    @PostMapping
    fun insertTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        return todoService.insertTodoElement(todo)
    }

    @CrossOrigin
    @DeleteMapping
    fun deleteTodo(@RequestBody todo: Todo): ResponseEntity<Boolean> {
        return todoService.deleteTodoElement(todo)
    }
}
