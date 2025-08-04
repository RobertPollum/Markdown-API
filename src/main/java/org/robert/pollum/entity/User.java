package org.robert.pollum.entity;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User extends PanacheEntityBase {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    
    @Column
    @NotNull
    String firstName;

    @Column
    @NotNull
    String lastName;

    @Column
    @Email
    String email;
}
