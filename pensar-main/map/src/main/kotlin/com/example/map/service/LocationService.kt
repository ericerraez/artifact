package com.example.map.service

import com.example.map.model.Location
import com.example.map.repository.LocationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

@Service
class LocationService {

    @Autowired
    lateinit var locationRepository: LocationRepository

    fun list(): List<Location> {
        return locationRepository.findAll()
    }

    fun save(location: Location): Location {
        return locationRepository.save(location)
    }

    fun update(location: Location): Location {
        return locationRepository.save(location)
    }

    fun delete(id: Long) {
        try {
            locationRepository.findById(id)
                ?: throw Exception("ID no existe")

            locationRepository.deleteById(id)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}
