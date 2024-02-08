package mx.edu.utez.Reconstruccion.model.dao;

import mx.edu.utez.Reconstruccion.model.entity.ClienteBean;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<ClienteBean, Integer> {
}
