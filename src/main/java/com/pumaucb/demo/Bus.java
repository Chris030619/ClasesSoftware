package com.pumaucb.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Bus {

    private @Id
    @GeneratedValue
    Long id;
    private String modelo;
    private String placa;
    private String capacidad;
    private String nombre_conductor;

    Bus() {
    }

    Bus(String modelo, String placa, String capacidad, String nombre_conductor) {
        this.modelo = modelo;
        this.placa = placa;
        this.capacidad = capacidad;
        this.nombre_conductor = nombre_conductor;
    }
}