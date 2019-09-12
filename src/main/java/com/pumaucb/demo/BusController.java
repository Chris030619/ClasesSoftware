package com.pumaucb.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BusController {

    private final BusRepository repository;

    BusController(BusRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/bus")
    List<Bus> all() {
        return repository.findAll();
    }

    @PostMapping("/bus")
    Bus newBus(@RequestBody Bus newBus) {
        return repository.save(newBus);
    }


    @GetMapping("/bus/{id}")
    Bus one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new BusNotFoundException(id));
    }

    @PutMapping("/bus/{id}")
    Bus replaceEmployee(@RequestBody Bus newBus, @PathVariable Long id) {

        return repository.findById(id)
                .map(bus-> {
                    bus.setModelo(newBus.getModelo());
                    bus.setPlaca(newBus.getPlaca());
                    bus.setCapacidad(newBus.getCapacidad());
                    bus.setNombre_conductor(newBus.getNombre_conductor());
                    return repository.save(bus);
                })
                .orElseGet(() -> {
                    newBus.setId(id);
                    return repository.save(newBus);
                });
    }

    @DeleteMapping("/bus/{id}")
    void deleteBus(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
