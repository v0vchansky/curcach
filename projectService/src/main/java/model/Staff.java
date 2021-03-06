package model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false, length = 64, unique = true)
    private String email;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String position;

    @Column(length = 20)
    private String phone;
}
