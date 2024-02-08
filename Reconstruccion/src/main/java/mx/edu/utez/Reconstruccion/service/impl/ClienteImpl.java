package mx.edu.utez.Reconstruccion.service.impl;

import lombok.AllArgsConstructor;
import mx.edu.utez.Reconstruccion.model.dao.ClienteDao;
import mx.edu.utez.Reconstruccion.model.dto.ClienteDto;
import mx.edu.utez.Reconstruccion.model.entity.ClienteBean;
import mx.edu.utez.Reconstruccion.service.ICliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteImpl implements ICliente {

    private final ClienteDao clienteDao;

    @Transactional
    @Override
    public ClienteBean save(ClienteDto clienteDto){
        ClienteBean cliente = ClienteBean.builder()
                .idcliente(clienteDto.getIdcliente())
                .nombre(clienteDto.getNombre())
                .ape1(clienteDto.getApe1())
                .ape2(clienteDto.getApe2())
                .direccion(clienteDto.getDireccion())
                .telefono(clienteDto.getTelefono())
                .sexo(clienteDto.getSexo())
                .build();
        return clienteDao.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public ClienteBean findById(Integer id){
        return clienteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(ClienteBean clienteBean){
        clienteDao.delete(clienteBean);
    }

    @Transactional
    @Override
    public List<ClienteBean> findAll(){
        return (List<ClienteBean>) clienteDao.findAll();
    }
}
