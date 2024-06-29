package com.example.demo.topico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        @NotNull
        Long id,
        @NotBlank
                          String titulo,
                          @NotBlank
                          @Email
                          String mensaje,
                          @NotBlank
                          String fechaCreacion,
                          @NotBlank
                          String status,
                          @NotBlank
                          String autor,
                          @NotBlank
                          String curso,
                          @NotBlank
                          String respuestas) {
    public DatosTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso(), topico.getRespuestas());
    }
}
