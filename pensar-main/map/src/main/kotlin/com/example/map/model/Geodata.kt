package com.example.map.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

@Entity
@Table(name="geodata")
class Geodata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message = "Campo obligatorio")
    var nombre: String? = null

    var fecha_hora: java.sql.Timestamp? = null

    var atributo_adicional: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var user: User? = null

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    var location: Location? = null
}
