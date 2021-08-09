package com.example.transactionaldemo.mapper;

import com.example.transactionaldemo.DTO.PersonsDTO;
import com.example.transactionaldemo.entity.PersonsEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonsMapper {
    PersonsDTO entityToDto(PersonsEntity entity);

    PersonsEntity dtoToEntity(PersonsDTO dto);

    List<PersonsDTO> entitiesToDto(List<PersonsEntity> entities);
}
