package com.example.pawel.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;
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

    @Column(name = "week")
    private Integer week;

    @ElementCollection
    @CollectionTable(name = "day_availability", joinColumns = @JoinColumn(name = "availability_id"))
    private List<DayAvailability> days;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DayAvailability {
        private String day;
        @Enumerated(EnumType.STRING)
        private Shift shift;
        private LocalDate date;
    }
}
