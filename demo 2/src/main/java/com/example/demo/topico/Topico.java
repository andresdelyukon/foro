package com.example.demo.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table (name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    String titulo;
    String mensaje;
    String fechaCreacion;
    String status;
    String autor;
    String curso;
    String respuestas; //posiblemente sea una lista esta cosa

    public Topico(DatosTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = datosTopico.fechaCreacion();
        this.status = datosTopico.status();
        this.autor = datosTopico.autor();
        this.curso = datosTopico.curso();
        this.respuestas = datosTopico.respuestas();
    }

    public void actualizarDatos(DatosTopico datosTopico) {
        if(datosTopico.titulo() != null){
            this.titulo = datosTopico.titulo();
        }

        if(datosTopico.mensaje() != null){
            this.mensaje = datosTopico.mensaje();
        }

    }


    //trata de usar lombok para que todos los setter, getter y demas queden como deben de @Data
}
