package org.robert.pollum.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @Column
    UUID id;
    
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
