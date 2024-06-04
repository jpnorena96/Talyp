package com.inventario.service;

import com.inventario.dto.EquipoDTO;
import com.inventario.exception.RecursoNoEncontradoException;
import com.inventario.model.Equipo;
import com.inventario.repository.EquipoRepository;
import com.inventario.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public EquipoDTO registrarEquipo(EquipoDTO equipoDTO) {
        Equipo equipo = mapper.toEntity(equipoDTO);
        equipo = equipoRepository.save(equipo);
        return mapper.toDTO(equipo);
    }

    @Override
    public List<EquipoDTO> obtenerEquipos() {
        return equipoRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipoDTO obtenerEquipoPorId(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Equipo no encontrado con id: " + id));
        return mapper.toDTO(equipo);
    }

    @Override
    public EquipoDTO actualizarEquipo(Long id, EquipoDTO equipoDTO) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Equipo no encontrado con id: " + id));

        equipo.setNumeroSerie(equipoDTO.getNumeroSerie());
        equipo.setDescripcion(equipoDTO.getDescripcion());
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setFechaCompra(equipoDTO.getFechaCompra());
        equipo.setValorCompra(equipoDTO.getValorCompra());

        equipo = equipoRepository.save(equipo);
        return mapper.toDTO(equipo);
    }

    @Override
    public void eliminarEquipo(Long id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Equipo no encontrado con id: " + id));
        equipoRepository.delete(equipo);
    }

    @Override
    public double calcularValorDepreciado(Long id, int anios) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Equipo no encontrado con id: " + id));
        double valorDepreciado = equipo.getValorCompra();
        for (int i = 0; i < anios; i++) {
            valorDepreciado *= 0.96;
        }
        return valorDepreciado;
    }
}
