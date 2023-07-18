package com.example.map.controller

import com.example.map.model.Geodata
import com.example.map.service.GeodataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/geodata")
class GeodataController {

    @Autowired
    lateinit var geodataService: GeodataService

    @GetMapping
    fun getGeodata(): List<Geodata> {
        return geodataService.list()
    }

    @PostMapping
    fun createGeodata(@RequestBody geodata: Geodata): Geodata {
        return geodataService.save(geodata)
    }

    @PutMapping("/{id}")
    fun updateGeodata(@PathVariable id: Long, @RequestBody geodata: Geodata): Geodata {
        if (geodata.id != id) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de geodata no coincide")
        }

        return geodataService.update(geodata)
    }

    @DeleteMapping("/{id}")
    fun deleteGeodata(@PathVariable id: Long) {
        geodataService.delete(id)
    }
}
