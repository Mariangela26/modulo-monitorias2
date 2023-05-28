package com.unisimon.monitorias.databuilder.chapter;

import com.unisimon.monitorias.chapter.domain.model.Seat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SeatTestDataBuilder {

    public static final Long ID = 1l;
    public static final String NAME = "Sede123";
    public static final String ADDRESS = "Avenida 1";

    private Long id;
    private String name;
    private String address;

    public SeatTestDataBuilder(){
        this.id = ID;
        this.name = NAME;
        this.address = ADDRESS;

    }

    public Seat buildSeat(){
        return new Seat(this.id, this.name, this.address);
    }

}
