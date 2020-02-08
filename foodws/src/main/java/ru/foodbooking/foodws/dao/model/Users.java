package ru.foodbooking.foodws.dao.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FB_USERS")
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
