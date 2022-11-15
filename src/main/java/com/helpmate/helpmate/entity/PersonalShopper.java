package com.helpmate.helpmate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class PersonalShopper extends User{

    @OneToMany
    private List<Order> orderList;
    @OneToOne
    private Location location;
}
