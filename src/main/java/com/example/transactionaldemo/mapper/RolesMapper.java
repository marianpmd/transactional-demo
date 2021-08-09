package com.example.transactionaldemo.mapper;

import com.example.transactionaldemo.DTO.RolesDTO;
import com.example.transactionaldemo.entity.RolesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.management.relation.Role;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RolesMapper {
    RolesDTO entityToDto(RolesEntity entity);

    RolesEntity dtoToEntity(RolesDTO dto);

    List<RolesDTO> entitiesToDto(List<RolesEntity> entities);
    List<RolesEntity> dtosToEntity(List<RolesDTO> dtos);
}
