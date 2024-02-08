package mx.edu.utez.Reconstruccion.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.Reconstruccion.model.dto.ClienteDto;
import mx.edu.utez.Reconstruccion.model.entity.ClienteBean;
import mx.edu.utez.Reconstruccion.service.impl.ClienteImpl;
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
public class ClienteController {

    private final ClienteImpl clienteService;

    @PostMapping("/cliente")
    public ClienteDto create (@RequestBody ClienteDto clienteDto){
        ClienteBean clienteSave = clienteService.save(clienteDto);
        return clienteDto.builder()
                .idcliente(clienteSave.getIdcliente())
                .nombre(clienteSave.getNombre())
                .ape1(clienteSave.getApe1())
                .ape2(clienteSave.getApe2())
                .direccion(clienteSave.getDireccion())
                .telefono(clienteSave.getTelefono())
                .sexo(clienteSave.getSexo())
                .build();
    }

    @PutMapping("/cliente")
    public ClienteDto update (@RequestBody ClienteDto clienteDto){
        ClienteBean clienteUpdate = clienteService.save(clienteDto);
        return clienteDto.builder()
                .idcliente(clienteUpdate.getIdcliente())
                .nombre(clienteUpdate.getNombre())
                .ape1(clienteUpdate.getApe1())
                .ape2(clienteUpdate.getApe2())
                .direccion(clienteUpdate.getDireccion())
                .telefono(clienteUpdate.getTelefono())
                .sexo(clienteUpdate.getSexo())
                .build();
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            ClienteBean cliente = clienteService.findById(id);
            clienteService.delete(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (DataAccessException dae){
            response.put("mensaje", dae.getMessage());
            response.put("Cliente", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cliente/{id}")
    public ClienteBean showById(@PathVariable Integer id){
        try {
            return clienteService.findById(id);
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en Base de Datos", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener el cliente", ex);
        }
    }

    @GetMapping("/cliente")
    public List<ClienteBean> findAll(){
        try {
            return clienteService.findAll();
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en Base de Datos", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener el cliente", ex);
        }
    }
}
