package com.example.transactionaldemo.service;

import com.example.transactionaldemo.DTO.PersonsDTO;
import com.example.transactionaldemo.DTO.RolesDTO;
import com.example.transactionaldemo.entity.PersonsEntity;
import com.example.transactionaldemo.entity.RolesEntity;
import com.example.transactionaldemo.mapper.PersonsMapper;
import com.example.transactionaldemo.mapper.RolesMapper;
import com.example.transactionaldemo.repository.PersonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonsService {
    private final PersonsRepository personsRepository;
    private final RolesMapper rolesMapper;
    private final PersonsMapper personsMapper;


    @Transactional(readOnly = true)
    public List<PersonsDTO> findAll() {
        List<PersonsEntity> all = personsRepository.findAll();
        return personsMapper.entitiesToDto(all);
    }

    @Transactional
    public PersonsDTO update(PersonsDTO personsDTO) {
        PersonsEntity personsEntity = personsRepository.findById(personsDTO.getId())
                .orElseThrow();

        personsDTO.getRoles().forEach(elem->{
            if (elem.getName() == null){
                throw new IllegalStateException("Null name not allowed");
            }
        });

        personsEntity.setName(personsDTO.getName());
        personsEntity.setAddress(personsDTO.getAddress());

        List<RolesEntity> roles = getRoles(personsEntity);

        /*    personsDTO.getRoles().get(0).setName(null); //coming from client*/

        roles.clear();

        roles.addAll(rolesMapper.dtosToEntity(personsDTO.getRoles()));
        roles.forEach(role -> role.setPerson(personsEntity));

        PersonsEntity save = personsRepository.save(personsEntity);

        return personsMapper.entityToDto(save);
    }

    private List<RolesEntity> getRoles(PersonsEntity personsEntity) {
        return personsEntity.getRoles();
    }
}
