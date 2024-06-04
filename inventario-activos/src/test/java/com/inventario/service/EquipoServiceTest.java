package com.inventario.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.inventario.dto.EquipoDTO;
import com.inventario.exception.RecursoNoEncontradoException;
import com.inventario.model.Equipo;
import com.inventario.repository.EquipoRepository;
import com.inventario.util.Mapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

public class EquipoServiceTest {

    @Mock
    private EquipoRepository equipoRepository;

    @Mock
    private Mapper mapper;

    @InjectMocks
    private EquipoServiceImpl equipoService;

    private Equipo equipo;
    private EquipoDTO equipoDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        equipo = new Equipo();
        equipo.setId(1L);
        equipo.setNombre("Equipo 1");
        equipo.setFechaCompra(LocalDate.now());
        equipo.setValorCompra(1000.0);

        equipoDTO = new EquipoDTO();
        equipoDTO.setId(1L);
        equipoDTO.setNombre("Equipo 1");
        equipoDTO.setFechaCompra(LocalDate.now());
        equipoDTO.setValorCompra(1000.0);
    }

    @Test
    public void testCalcularValorDepreciado() {
        when(equipoRepository.findById(1L)).thenReturn(Optional.of(equipo));
        double valorDepreciado = equipoService.calcularValorDepreciado(1L, 1);
        assertEquals(960.0, valorDepreciado);

        valorDepreciado = equipoService.calcularValorDepreciado(1L, 2);
        assertEquals(921.6, valorDepreciado);
    }

    @Test
    public void testRegistrarEquipo() {
        when(equipoRepository.save(any(Equipo.class))).thenReturn(equipo);
        when(mapper.toEntity(any(EquipoDTO.class))).thenReturn(equipo);
        when(mapper.toDTO(any(Equipo.class))).thenReturn(equipoDTO);

        EquipoDTO result = equipoService.registrarEquipo(equipoDTO);
        assertEquals(equipoDTO, result);
    }

    // Más pruebas para los otros métodos del servicio...
}
