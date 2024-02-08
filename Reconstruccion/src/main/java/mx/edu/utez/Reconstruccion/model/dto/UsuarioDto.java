package mx.edu.utez.Reconstruccion.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioDto {

    private Integer idusuario;
    private String usuario;
    private String contrasena;
    private boolean estado;
}
