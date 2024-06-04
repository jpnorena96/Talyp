package com.inventario.controller;

import com.inventario.dto.EquipoDTO;
import com.inventario.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @PostMapping
    public EquipoDTO registrarEquipo(@RequestBody EquipoDTO equipoDTO) {
        return equipoService.registrarEquipo(equipoDTO);
    }

    @GetMapping
    public List<EquipoDTO> obtenerEquipos() {
        return equipoService.obtenerEquipos();
    }

    @GetMapping("/{id}")
    public EquipoDTO obtenerEquipo(@PathVariable Long id) {
        return equipoService.obtenerEquipoPorId(id);
    }

    @PutMapping("/{id}")
    public EquipoDTO actualizarEquipo(@PathVariable Long id, @RequestBody EquipoDTO equipoDTO) {
        return equipoService.actualizarEquipo(id, equipoDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarEquipo(@PathVariable Long id) {
        equipoService.eliminarEquipo(id);
    }

    @GetMapping("/depreciacion/{id}/{anios}")
    public double calcularValorDepreciado(@PathVariable Long id, @PathVariable int anios) {
        return equipoService.calcularValorDepreciado(id, anios);
    }
}
