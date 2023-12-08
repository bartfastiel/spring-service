package com.example.springservice;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvocadoServiceTest {

    private final AvocadoRepository repo = mock(AvocadoRepository.class);

    @Test
    void sumOfPurchasePrices() {
        List<Avocado> testdata = List.of(
                new Avocado("1", "brown", BigDecimal.valueOf(2)),
                new Avocado("2", "brown", BigDecimal.valueOf(3))
        );
        when(repo.findAll()).thenReturn(testdata);

        AvocadoService underTest = new AvocadoService(repo);
        BigDecimal actual = underTest.sumOfPurchasePrices();
        BigDecimal expected = BigDecimal.valueOf(5);
        assertEquals(expected, actual);
        verify(repo).findAll();
    }
}