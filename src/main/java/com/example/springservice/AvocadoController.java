package com.example.springservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avocados")
@RequiredArgsConstructor
public class AvocadoController {

    private final AvocadoService service;

    @GetMapping
    public List<ApiAvocado> getAvocados() {
        List<Avocado> avocados = service.getAvocados();
        return avocados.stream()
                .map(avocado -> new ApiAvocado(avocado.id(), avocado.color()))
                .toList();
    }

    @PostMapping
    public ApiAvocado postAvocado(@RequestBody NewAvocado newAvocado) {
        Avocado saved = service.save(newAvocado);
        return new ApiAvocado(saved.id(), saved.color());
    }

}
