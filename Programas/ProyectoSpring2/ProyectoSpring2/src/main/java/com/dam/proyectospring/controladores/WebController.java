package com.dam.proyectospring.controladores;

import com.dam.proyectospring.modelos.Piloto;
import com.dam.proyectospring.servicios.PilotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private PilotoServicio pilotoServicio;

    @RequestMapping(value ="/")
    public String index(Model model) {
        List<Piloto> pilotos = pilotoServicio.findAllPilotos();
        model.addAttribute("pilotos", pilotos);
        return "index";
    }
}
