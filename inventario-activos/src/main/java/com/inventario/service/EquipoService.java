package com.inventario.service;

import com.inventario.dto.EquipoDTO;

import java.util.List;

public interface EquipoService {
    EquipoDTO registrarEquipo(EquipoDTO equipoDTO);
    List<EquipoDTO> obtenerEquipos();
    EquipoDTO obtenerEquipoPorId(Long id);
    EquipoDTO actualizarEquipo(Long id, EquipoDTO equipoDTO);
    void eliminarEquipo(Long id);
    double calcularValorDepreciado(Long id, int anios);
}
