package mx.edu.utez.Reconstruccion.service;

import mx.edu.utez.Reconstruccion.model.dto.UsuarioDto;
import mx.edu.utez.Reconstruccion.model.entity.UsuarioBean;

import java.util.List;

public interface IUsuario {

    UsuarioBean save(UsuarioDto usuarioDto);

    UsuarioBean findById(Integer id);

    void delete(UsuarioBean usuarioBean);

    List<UsuarioBean> findAll();
}
