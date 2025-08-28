package co.com.solicitudes.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table("tipo_prestamo")
public class TipoPrestamoEntity {

    @Id
    private Long id;

    private String nombre;

    private String descripcion;

}
