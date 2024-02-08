package mx.edu.utez.Reconstruccion.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.Reconstruccion.model.dto.UsuarioDto;
import mx.edu.utez.Reconstruccion.model.entity.UsuarioBean;
import mx.edu.utez.Reconstruccion.service.impl.UsuarioImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UsuarioController {

    private final UsuarioImpl usuarioService;

    @PostMapping("/usuario")
    public UsuarioDto create (@RequestBody UsuarioDto usuarioDto){
        try{
            UsuarioBean usuarioSave = usuarioService.save(usuarioDto);
            return usuarioDto.builder()
                    .idusuario(usuarioSave.getIdusuario())
                    .usuario(usuarioSave.getUsuario())
                    .contrasena(usuarioSave.getContrasena())
                    .estado(true)
                    .build();
        } catch (DataAccessException dae){
            throw new RuntimeException("No se puede meter el mismo usuario en la base de datos", dae);
        } catch (Exception ex){
            throw new RuntimeException("Ingrese otro usuario", ex);
        }

    }

    @PutMapping("/usuario")
    public UsuarioDto update (@RequestBody UsuarioDto usuarioDto){
        UsuarioBean usuarioUpdate = usuarioService.save(usuarioDto);
        return usuarioDto.builder()
                .idusuario(usuarioUpdate.getIdusuario())
                .usuario(usuarioUpdate.getUsuario())
                .contrasena(usuarioUpdate.getContrasena())
                .estado(true)
                .build();
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            UsuarioBean usuario = usuarioService.findById(id);
            usuarioService.delete(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (DataAccessException dae){
            response.put("mensaje", dae.getMessage());
            response.put("Usuario", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{id}")
    public UsuarioBean showById(@PathVariable Integer id){
        try {
            return usuarioService.findById(id);
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en Base de Datos", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener el Usuario", ex);
        }
    }

    @GetMapping("/usuario")
    public List<UsuarioBean> findAll(){
        try {
            return usuarioService.findAll();
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en Base de Datos", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener el Usuario", ex);
        }
    }
}
