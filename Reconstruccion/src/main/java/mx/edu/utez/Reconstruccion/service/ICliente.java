package mx.edu.utez.Reconstruccion.service;

import mx.edu.utez.Reconstruccion.model.dto.ClienteDto;
import mx.edu.utez.Reconstruccion.model.entity.ClienteBean;

import java.util.List;

public interface ICliente {

    ClienteBean save(ClienteDto clienteDto);

    ClienteBean findById(Integer id);

    void delete(ClienteBean clienteBean);

    List<ClienteBean> findAll();
}
