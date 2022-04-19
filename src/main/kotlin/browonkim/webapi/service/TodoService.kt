package browonkim.webapi.service

import browonkim.webapi.members.Todo
import browonkim.webapi.respositories.TodoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TodoService constructor(val todoRepository: TodoRepository) {
    @Transactional
    fun getTodoElement(): ResponseEntity<Iterable<Todo>> {
        return ResponseEntity(todoRepository.findAll(), HttpStatus.OK)
    }
}
