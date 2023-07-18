package com.example.map.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@Entity
@Table(name="location")
class Location {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message = "Campo obligatorio")
    var fullname: String? = null

    @NotNull(message = "Campo obligatorio")
    @Column(precision = 9, scale = 6)
    var latitude: BigDecimal? = null

    @NotNull(message = "Campo obligatorio")
    @Column(precision = 9, scale = 6)
    var longitude: BigDecimal? = null

    var description: String? = null
}
