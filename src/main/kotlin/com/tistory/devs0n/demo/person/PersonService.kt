package com.tistory.devs0n.demo.person

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class PersonService(
    private val personRepository: PersonRepository,
) {
    @Transactional(readOnly = true)
    fun getPerson(personId: Long): Person {
        return this.personRepository.findById(personId)
            .orElseThrow { IllegalArgumentException("Person not found") }
    }

    fun createPerson(name: String): Person {
        return this.personRepository.save(Person(name))
    }

    fun renamePerson(personId: Long, newName: String): Person {
        val person = this.getPerson(personId)
        person.rename(newName)
        return person
    }
}
