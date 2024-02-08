package mx.edu.utez.Reconstruccion.model.dao;

import mx.edu.utez.Reconstruccion.model.entity.UsuarioBean;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<UsuarioBean, Integer> {
}
