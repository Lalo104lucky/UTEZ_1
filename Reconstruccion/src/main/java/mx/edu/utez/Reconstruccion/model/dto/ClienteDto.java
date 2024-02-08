package mx.edu.utez.Reconstruccion.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClienteDto {

    private Integer idcliente;
    private String nombre;
    private String ape1;
    private String ape2;
    private String direccion;
    private String telefono;
    private String sexo;
}
