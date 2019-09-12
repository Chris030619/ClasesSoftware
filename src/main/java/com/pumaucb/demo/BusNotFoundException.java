package com.pumaucb.demo;

class BusNotFoundException extends RuntimeException {

    BusNotFoundException(Long id) {
        super("No se encontro el bus " + id);
    }
}
