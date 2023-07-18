package com.example.map.repository

import com.example.map.model.Geodata
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GeodataRepository : JpaRepository<Geodata, Long> {
    fun findById(id: Long?): Geodata?
}
