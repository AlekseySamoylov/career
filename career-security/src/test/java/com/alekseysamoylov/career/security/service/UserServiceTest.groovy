package com.alekseysamoylov.career.security.service

import com.alekseysamoylov.career.security.entity.User
import com.alekseysamoylov.career.security.repository.UserRepository
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceTest extends Specification {

    def "Should not throw IllegalArgumentException"() {
        setup:
        def userName = 'Ivan'
        def user = new User(id: 1, name: userName)
        def userRepositoryMock = Spy(UserRepository)
        userRepositoryMock.findOneByName(userName) >> user
        def userService = new UserService(userRepositoryMock)

        when:
        userService.processUser(userName)

        then:
        notThrown(IllegalArgumentException)
    }

    def "Should throw IllegalArgumentException"() {
        setup:
        def userName = 'Ivan'
        def userRepositoryMock = Spy(UserRepository)
        userRepositoryMock.findOneByName(userName) >> null
        def userService = new UserService(userRepositoryMock)

        when:
        userService.processUser(userName)

        then:
        thrown(IllegalArgumentException)
    }
}
