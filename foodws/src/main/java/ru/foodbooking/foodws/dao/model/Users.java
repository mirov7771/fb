package ru.foodbooking.foodws.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FB_USERS")
@Getter @Setter @NoArgsConstructor
public class Users implements Serializable {

    private static final long serialVersionUID = 3323932161830118300L;

    @Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "USERPHONE")
    private String userPhone;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "DEVICEID")
    private String deviceId;

}
