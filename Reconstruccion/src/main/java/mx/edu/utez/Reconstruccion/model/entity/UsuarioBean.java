package mx.edu.utez.Reconstruccion.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name = "usuario")
public class UsuarioBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    @Column(name = "usuario", unique = true)
    private String usuario;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "estado")
    private boolean estado;
}
