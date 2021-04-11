package com.tistory.devs0n.demo.person

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Person class")
internal class PersonTest {
    @Test
    fun `changeName method changes its name`() {
        // given
        val oldName = "Chris"
        val newName = "Brown"

        val person = Person(oldName)

        // when
        person.rename(newName)

        // then
        assertThat(person.name).isNotEqualTo(oldName)
        assertThat(person.name).isEqualTo(newName)
    }
}