package co.com.solicitudes.r2dbc.mapper;

import co.com.solicitudes.model.solicitud.Solicitud;
import co.com.solicitudes.r2dbc.entity.SolicitudEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitudEntityMapper {
    SolicitudEntity toEntityFromModel(Solicitud objectModel);
    Solicitud toModelFromEntity(SolicitudEntity objectEntity);

}
