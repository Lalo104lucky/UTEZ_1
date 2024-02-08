package mx.edu.utez.Reconstruccion.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.Reconstruccion.model.dao.UsuarioDao;
import mx.edu.utez.Reconstruccion.model.dto.UsuarioDto;
import mx.edu.utez.Reconstruccion.model.entity.UsuarioBean;
import mx.edu.utez.Reconstruccion.service.IUsuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UsuarioImpl implements IUsuario {

    private final UsuarioDao usuarioDao;

    @Transactional
    @Override
    public UsuarioBean save(UsuarioDto usuarioDto){
        UsuarioBean usuario = UsuarioBean.builder()
                .idusuario(usuarioDto.getIdusuario())
                .usuario(usuarioDto.getUsuario())
                .contrasena(generarContra())
                .estado(true)
                .build();

        return usuarioDao.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public UsuarioBean findById(Integer id){
        return usuarioDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(UsuarioBean usuarioBean){
        usuarioDao.delete(usuarioBean);
    }

    @Transactional
    @Override
    public List<UsuarioBean> findAll(){
        return (List<UsuarioBean>) usuarioDao.findAll();
    }

    public String generarContra(){
        String contrasena = "";
        contrasena = UUID.randomUUID().toString().substring(0,8);
        return contrasena;
    }

}
