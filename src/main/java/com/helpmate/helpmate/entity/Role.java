package com.helpmate.helpmate.entity;

import com.helpmate.helpmate.entity.enums.RoleType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
}
