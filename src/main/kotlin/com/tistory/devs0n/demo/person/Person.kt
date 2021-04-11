package com.tistory.devs0n.demo.person

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Person {
    @Id
    @GeneratedValue
    val id: Long? = null

    @Column
    var name: String
        private set

    constructor(name: String) {
        this.name = name
    }

    fun rename(newName: String) {
        this.name = newName
    }
}
