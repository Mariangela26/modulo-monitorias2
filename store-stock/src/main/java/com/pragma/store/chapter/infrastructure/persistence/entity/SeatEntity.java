package com.pragma.store.chapter.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="seat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    String address;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SupplyEntity> supplies;
}
