package com.example.map.service

import com.example.map.model.User
import com.example.map.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun list(): List<User> {
        return userRepository.findAll()
    }

    fun save(user: User): User? {
        val validate = user.age?.let { validateAge(it) }

        return if (validate == true) {
            userRepository.save(user)
        } else {
            null
        }
    }

    fun update(user: User): User {
        try {
            userRepository.findById(user.id)
                ?: throw Exception("ID no existe")

            return userRepository.save(user)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(user: User): User {
        try {
            val response = userRepository.findById(user.id)
                ?: throw Exception("ID no existe")
            response.apply {
                this.fullname = user.fullname
            }
            return userRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        try {
            userRepository.findById(id)
                ?: throw Exception("ID no existe")

            userRepository.deleteById(id)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun validateAge(age: Int): Boolean {
        return age > 18
    }
}
