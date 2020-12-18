package com.info2020.ejercicio3.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioid;
    private String autor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechacomentario;
    @Length(min = 3, max = 200)
    private String comentario;

    public Long getComentarioid() {
        return comentarioid;
    }

    public void setComentarioid(Long comentarioid) {
        this.comentarioid = comentarioid;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechacomentario() {
        return fechacomentario;
    }

    public void setFechacomentario(Date fechacomentario) {
        this.fechacomentario = fechacomentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
