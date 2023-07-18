package com.example.map.controller

import com.example.map.model.User
import com.example.map.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun getUsers(): List<User> {
        return userService.list()
    }

    @PostMapping
    fun createUser(@RequestBody user: User): User? {
        return userService.save(user)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User {
        user.id = id
        return userService.update(user)
    }

    @PatchMapping("/{id}")
    fun updateUserName(@PathVariable id: Long, @RequestBody user: User): User {
        user.id = id
        return userService.updateName(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) {
        userService.delete(id)
    }
}
