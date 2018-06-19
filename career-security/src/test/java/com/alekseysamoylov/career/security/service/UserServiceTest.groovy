package com.alekseysamoylov.career.security.service

import com.alekseysamoylov.career.security.entity.User
import com.alekseysamoylov.career.security.repository.UserRepository
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

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

    def "Should summarize values simple"() {
        setup:
        def userService = new UserService();

        when:
        def result = userService.sum(1, 1)

        then:
        result == 2
    }

    def "Should summarize values"() {
        setup:
        def userService = new UserService();

        expect:
        result == userService.sum(firstArg, lastArg)

        where:
        firstArg << [1, 2, 3]
        lastArg << [1, 2, 3]
        result << [2, 4, 6]
    }

    @Unroll("first: #firstArg plus last: #lastArg equals #result")
    def "Should summarize values with table"() {
        setup:
        def userService = new UserService();

        expect:
        result == userService.sum(firstArg, lastArg)

        where:
        firstArg | lastArg || result
        1        | 1       || 2
        2        | 2       || 4
        3        | 3       || 6
        5        | 3       || 0
    }
}
