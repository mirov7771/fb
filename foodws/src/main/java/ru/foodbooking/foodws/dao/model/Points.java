package ru.foodbooking.foodws.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "FB_POINTS")
@Getter @Setter @NoArgsConstructor
public class Points implements Serializable {

    private static final long serialVersionUID = 587189478058181192L;

    @Id
    @Column(name = "POINTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;
    @Column(name = "POINTBRIEF")
    private String pointBrief;
    @Column(name = "POINTNAME")
    private String pointName;
    @Column(name = "POINTADDRESS")
    private String pointAddress;
    @Column(name = "POINTLOGO")
    private String pointLogo;

    @OneToMany(mappedBy = "pointId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Categories> categoriesList;
}
