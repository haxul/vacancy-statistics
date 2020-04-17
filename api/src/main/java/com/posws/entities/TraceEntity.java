package com.posws.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "traces")
@Data
public class TraceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date date;

    @Column(name = "position", length = 100)
    private String position;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "count")
    private String count;
}
