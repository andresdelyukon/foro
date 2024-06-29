package com.example.demo.controlador;

import com.example.demo.repository.TopicRepository;
import com.example.demo.topico.DatosTopico;
import com.example.demo.topico.Topico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos") //esta madre hace que sirva en la URL que contenga topicos
public class TopicoControlador {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    public void registrarTopico(@RequestBody DatosTopico datosTopico){
        topicRepository.save(new Topico(datosTopico));
    }

    @GetMapping
    public Page<DatosTopico> listadoTopicos(@PageableDefault(size = 10, sort = "fechaCreacion") Pageable pageable){
        return topicRepository.findAll(pageable).map(DatosTopico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody DatosTopico datosTopico){
        Topico topico = topicRepository.getReferenceById(datosTopico.id());
        topico.actualizarDatos(datosTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicRepository.getReferenceById(id);
        topicRepository.delete(topico);

    }
}
