package ru.foodbooking.foodws.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FB_CODES")
@Getter @Setter @NoArgsConstructor
public class Codes implements Serializable {

    private static final long serialVersionUID = 2444120344853487437L;

    @Id
    @Column(name = "CLIENTPHONE")
    private String clientPhone;
    @Column(name = "CODE")
    private String code;
    @Column(name = "COUNTS")
    private Integer counts;

    public Codes(String clientPhone, String code, Integer counts){
        this.clientPhone = clientPhone;
        this.code = code;
        this.counts = counts;
    }

}
