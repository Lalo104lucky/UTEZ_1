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
@Table(name = "cliente")
public class ClienteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ape1")
    private String ape1;
    @Column(name = "ape2")
    private String ape2;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "sexo")
    private String sexo;
}
