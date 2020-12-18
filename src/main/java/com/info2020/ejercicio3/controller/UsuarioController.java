package com.info2020.ejercicio3.controller;

import com.info2020.ejercicio3.entity.Usuario;
import com.info2020.ejercicio3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v4/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/saludo")
    public String hello(){
        return "hola manola";
    }

    @PostMapping("/crearusuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);

    }

    @PutMapping("/editarusuario/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuario ){



        Usuario usuarioAEditar = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id de usuario no existe " + id));
        usuarioAEditar.setNombre(usuario.getNombre());
        usuarioAEditar.setApellido(usuario.getApellido());
        usuarioAEditar.setPassword(usuario.getPassword());
        usuarioAEditar.setEmail(usuario.getEmail());
        usuarioAEditar.setCiudad(usuario.getCiudad());
        usuarioAEditar.setProvincia(usuario.getProvincia());
        usuarioAEditar.setPais(usuario.getPais());
        usuarioAEditar.setFechausuario(usuario.getFechausuario());
        return new ResponseEntity<>(usuarioRepository.save(usuarioAEditar), HttpStatus.OK);
    }


    @DeleteMapping("/borrarusuario/{id}")
    public ResponseEntity<?> borrarUsuario(@PathVariable ("id") Long id){
        Usuario usuarioABorrar = usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id de usuario no existe " + id));

        usuarioRepository.delete(usuarioABorrar);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/usuarios")
    public List<Usuario> getAllusuario(){
        return usuarioRepository.findAll();
    }
}
