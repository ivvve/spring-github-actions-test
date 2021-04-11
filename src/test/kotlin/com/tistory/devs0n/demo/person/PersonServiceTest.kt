package com.tistory.devs0n.demo.person

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class PersonServiceTest {
    @Autowired
    lateinit var personService: PersonService
    lateinit var existingPerson: Person

    @BeforeEach
    fun setUp() {
        existingPerson = personService.createPerson("Chris")
    }

    @Test
    fun getPerson() {
        val person = personService.getPerson(existingPerson.id!!)
        assertThat(person.id).isEqualTo(existingPerson.id)
        assertThat(person.name).isEqualTo(existingPerson.name)
    }

    @Test
    fun createPerson() {
        val person = personService.createPerson("Brown")
        assertThat(person.name).isEqualTo("Brown")
    }

    @Test
    fun renamePerson() {
        val person = personService.renamePerson(existingPerson.id!!, "Brown")
        assertThat(person.id).isEqualTo(existingPerson.id)
        assertThat(person.name).isEqualTo("Brown")
    }
}
