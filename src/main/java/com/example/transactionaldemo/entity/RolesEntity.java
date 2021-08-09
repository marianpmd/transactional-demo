package com.example.transactionaldemo.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private Double salary;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private PersonsEntity person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RolesEntity that = (RolesEntity) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 622155445;
    }
}
