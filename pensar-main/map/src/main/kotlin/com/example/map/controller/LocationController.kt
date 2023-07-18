package com.example.map.controller

import com.example.map.model.Location
import com.example.map.service.LocationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/locations")
class LocationController {

    @Autowired
    lateinit var locationService: LocationService

    @GetMapping
    fun getLocations(): List<Location> {
        return locationService.list()
    }

    @PostMapping
    fun createLocation(@RequestBody location: Location): Location {
        return locationService.save(location)
    }

    @PutMapping("/{id}")
    fun updateLocation(@PathVariable id: Long, @RequestBody location: Location): Location {
        if (location.id != id) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de ubicación no coincide")
        }

        return locationService.update(location)
    }

    @DeleteMapping("/{id}")
    fun deleteLocation(@PathVariable id: Long) {
        locationService.delete(id)
    }
}
