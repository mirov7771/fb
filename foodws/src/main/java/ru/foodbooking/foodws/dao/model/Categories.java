package ru.foodbooking.foodws.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "FB_CATEGORIES")
@Getter @Setter @NoArgsConstructor
public class Categories implements Serializable {

    private static final long serialVersionUID = 773490650559746268L;

    @Id
    @Column(name = "CTGRID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ctgrId;
    @Column(name = "POINTID")
    private Long pointId;
    @Column(name = "CTGRBRIEF")
    private String ctgrBrief;
    @Column(name = "CTGRNAME")
    private String ctgrName;
    @Column(name = "CTGRLOGO")
    private String ctgrLogo;
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "ctgrId",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Products> productsList;

}