package com.example.map.service

import com.example.map.model.Geodata
import com.example.map.repository.GeodataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class GeodataService {

    @Autowired
    lateinit var geodataRepository: GeodataRepository

    fun list(): List<Geodata> {
        return geodataRepository.findAll()
    }

    fun save(geodata: Geodata): Geodata {
        return geodataRepository.save(geodata)
    }

    fun update(geodata: Geodata): Geodata {
        try {
            geodataRepository.findById(geodata.id)
                ?: throw Exception("ID no existe")

            return geodataRepository.save(geodata)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        try {
            geodataRepository.findById(id)
                ?: throw Exception("ID no existe")

            geodataRepository.deleteById(id)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}
