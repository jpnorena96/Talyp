package com.inventario.controller;

import com.inventario.dto.EquipoDTO;
import com.inventario.service.EquipoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EquipoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EquipoService equipoService;

    @InjectMocks
    private EquipoController equipoController;

    private EquipoDTO equipoDTO1;
    private EquipoDTO equipoDTO2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(equipoController).build();

        equipoDTO1 = new EquipoDTO();
        equipoDTO1.setId(1L);
        equipoDTO1.setNombre("Equipo 1");

        equipoDTO2 = new EquipoDTO();
        equipoDTO2.setId(2L);
        equipoDTO2.setNombre("Equipo 2");
    }

    @Test
    public void testRegistrarEquipo() throws Exception {
        when(equipoService.registrarEquipo(any(EquipoDTO.class))).thenReturn(equipoDTO1);

        mockMvc.perform(post("/api/equipos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{"nombre":"Equipo 1"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("Equipo 1"));
    }

    @Test
    public void testObtenerEquipos() throws Exception {
        when(equipoService.obtenerEquipos()).thenReturn(Arrays.asList(equipoDTO1, equipoDTO2));

        mockMvc.perform(get("/api/equipos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Equipo 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].nombre").value("Equipo 2"));
    }

}
