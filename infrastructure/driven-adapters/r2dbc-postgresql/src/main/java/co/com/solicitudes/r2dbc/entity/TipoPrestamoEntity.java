package co.com.solicitudes.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table("tipo_prestamo")
public class TipoPrestamoEntity {

    @Id
    private Long idTipoPrestamo;

    private String nombre;

    private BigDecimal montoMinimo;

    private BigDecimal montoMaximo;

    private String tasaInteres;

    private Integer validacionAutomatica;




}
