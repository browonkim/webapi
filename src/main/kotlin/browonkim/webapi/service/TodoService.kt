package browonkim.webapi.service

import browonkim.webapi.commonUtils.isStringEmpty
import browonkim.webapi.members.Todo
import browonkim.webapi.respositories.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TodoService constructor(val todoRepository: TodoRepository) {
    @Transactional
    fun getTodoElements(): ResponseEntity<Iterable<Todo>> {
        return ResponseEntity(todoRepository.findAll(), HttpStatus.OK)
    }

    @Transactional
    fun insertTodoElement(todo: Todo): ResponseEntity<Todo> {
        if (todo.id != null) {
            throw Exception()
        }
        return ResponseEntity(todoRepository.save(todo), HttpStatus.OK)
    }

    @Transactional
    fun deleteTodoElement(todo: Todo): ResponseEntity<Boolean> {
        todoRepository.delete(todo)
        return ResponseEntity(true, HttpStatus.OK)
    }

    @Transactional
    fun updateTodoElement(todo: Todo): ResponseEntity<Todo> {
        if (todo.id == null) {
            throw Exception()
        }
        if (validateTodo(todo)) {
            throw Exception()
        }
        return ResponseEntity(todoRepository.save(todo), HttpStatus.OK)
    }

    fun validateTodo(todo: Todo): Boolean {
        if (isStringEmpty(todo.detail) && isStringEmpty(todo.title)) {
            return false
        }
        return true
    }
}
