package com.example.transactionaldemo.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "persons")
public class PersonsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String address;
    private String name;
    

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL ,fetch = FetchType.LAZY,orphanRemoval = true)
    @ToString.Exclude
    private List<RolesEntity> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonsEntity that = (PersonsEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1715186907;
    }
}
