package browonkim.webapi.members

import javax.persistence.*

@Entity
class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long? = null

    @Column
    var title: String? = null

    @Column
    var detail: String? = null

    @Column
    var date: String? = null

    @Column(nullable = false)
    var state: String = "todo"
}
