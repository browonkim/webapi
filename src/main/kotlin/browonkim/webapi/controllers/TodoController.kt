package browonkim.webapi.controllers

import browonkim.webapi.members.Todo
import browonkim.webapi.service.TodoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController constructor(val todoService: TodoService) {

    @CrossOrigin(origins = ["*"])
    @GetMapping
    fun getTodo(): ResponseEntity<Iterable<Todo>> {
        return todoService.getTodoElements()
    }

    @CrossOrigin(origins = ["*"])
    @PutMapping
    fun updateTodo(@RequestParam todo: Todo): ResponseEntity<Todo> {
        return todoService.updateTodoElement(todo)
    }

    @CrossOrigin(origins = ["*"])
    @PostMapping
    fun insertTodo(@RequestParam todo: Todo): ResponseEntity<Todo> {
        return todoService.insertTodoElement(todo)
    }

    @CrossOrigin(origins=["*"])
    @DeleteMapping
    fun deleteTodo(todo: Todo): ResponseEntity<Boolean> {
        return todoService.deleteTodoElement(todo)
    }
}
