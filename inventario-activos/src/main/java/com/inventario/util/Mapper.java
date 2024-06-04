package com.inventario.util;

import com.inventario.dto.EquipoDTO;
import com.inventario.model.Equipo;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Equipo toEntity(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setId(equipoDTO.getId());
        equipo.setNumeroSerie(equipoDTO.getNumeroSerie());
        equipo.setDescripcion(equipoDTO.getDescripcion());
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setFechaCompra(equipoDTO.getFechaCompra());
        equipo.setValorCompra(equipoDTO.getValorCompra());
        return equipo;
    }

    public EquipoDTO toDTO(Equipo equipo) {
        EquipoDTO equipoDTO = new EquipoDTO();
        equipoDTO.setId(equipo.getId());
        equipoDTO.setNumeroSerie(equipo.getNumeroSerie());
        equipoDTO.setDescripcion(equipo.getDescripcion());
        equipoDTO.setNombre(equipo.getNombre());
        equipoDTO.setFechaCompra(equipo.getFechaCompra());
        equipoDTO.setValorCompra(equipo.getValorCompra());
        return equipoDTO;
    }
}
