package learn.kotlin.unit.test

import learn.kotlin.unit.test.model.Person
import learn.kotlin.unit.test.repository.PersonRepository
import learn.kotlin.unit.test.service.PersonService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(value = [MockitoExtension::class])
class PersonServiceTest {

    @Mock
    lateinit var personRepository: PersonRepository

    private lateinit var personService: PersonService

    @BeforeEach
    fun beforeEach() {
        personService = PersonService(personRepository)
    }

    @Test
    fun testPersonIdIsNotValid() {
        assertThrows<IllegalArgumentException> {
            personService.get("")
        }
    }

    @Test
    fun testPersonNotFound() {
        assertThrows<Exception> {
            personService.get("Not Found")
        }
    }

    @Test
    fun testGetPersonSuccess() {
        Mockito.`when`(personRepository.selectById("ihsan")).thenReturn(Person("ihsan", "Ihsan Nurul Habib"))

        val person = personService.get("ihsan")
        assertEquals("ihsan", person.id)
        assertEquals("Ihsan Nurul Habib", person.name)
    }

    @Test
    fun testRegisterPersonNameIsBlank() {
        assertThrows<IllegalArgumentException> {
            personService.get("")
        }
    }

    @Test
    fun testRegisterSuccess() {
        val person = personService.register("Amelia")

        assertEquals("Amelia", person.name)
        assertNotNull(person.id)

        Mockito.verify(personRepository, Mockito.times(1)).insert(Person(person.id, person.name))
    }
}