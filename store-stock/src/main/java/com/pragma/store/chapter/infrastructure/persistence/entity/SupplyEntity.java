package com.pragma.store.chapter.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="supply")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Long dispatcherId;
    private Long providerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatId")
    private SeatEntity seat;

    @OneToMany(mappedBy = "supply", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ProductSupplyEntity> productSupplies;
}
