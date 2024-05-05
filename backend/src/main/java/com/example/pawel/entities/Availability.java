package com.example.pawel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Availability {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(name="week")
    private Integer week;
    @Enumerated(value = EnumType.STRING)
    @Column(name="monday")
    private Shift monday;
    @Enumerated(value = EnumType.STRING)
    @Column(name="tuesday")
    private Shift tuesday;
    @Enumerated(value = EnumType.STRING)
    @Column(name="wednesday")
    private Shift wednesday;
    @Enumerated(value = EnumType.STRING)
    @Column(name="thursday")
    private Shift thursday;
    @Enumerated(value = EnumType.STRING)
    @Column(name="friday")
    private Shift friday;
    @Enumerated(value = EnumType.STRING)
    @Column(name="saturday")
    private Shift saturday;
    @Enumerated(value = EnumType.STRING)
    @Column(name="sunday")
    private Shift sunday;


}
