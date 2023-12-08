package com.example.springservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AvocadoService {

    private final AvocadoRepository avocadoRepository;

    public List<Avocado> getAvocados() {
        return avocadoRepository.findAll();
    }

    public Avocado save(NewAvocado newAvocado) {
        Avocado avocado = new Avocado(UUID.randomUUID().toString(), newAvocado.color(), null);
        return avocadoRepository.save(avocado);
    }

    public BigDecimal sumOfPurchasePrices() {
        return BigDecimal.valueOf(5);
    }
}
