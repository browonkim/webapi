package browonkim.webapi.respositories

import browonkim.webapi.members.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<Todo, Long>{
}
