package omar.trial.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "USERS")
public class Users {
    @Generated
    @Column(name = "ID")
    @Id
    private UUID id;

    @Column(name = "USER_NAME")
    private  String  userName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLES")
    private String roles;

    @Column(name = "ACTIVE")
    private Boolean active;




}
