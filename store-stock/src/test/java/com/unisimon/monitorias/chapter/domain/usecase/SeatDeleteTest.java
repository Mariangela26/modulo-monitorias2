package com.unisimon.monitorias.chapter.domain.usecase;

import com.unisimon.monitorias.chapter.domain.model.Seat;
import com.unisimon.monitorias.chapter.domain.spi.ISeatPersistencePort;
import com.unisimon.monitorias.databuilder.chapter.SeatTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SeatDeleteTest {

    @InjectMocks
    private SeatUseCase seatUseCase;

    @Mock
    private ISeatPersistencePort seatPersistencePort;

    @Test
    public void testDeleteSeat(){

        Seat seatDelete = new SeatTestDataBuilder().buildSeat();
        seatDelete.setId(1l);
        seatUseCase.deleteSeat(1l);

        Assertions.assertEquals(null,seatUseCase.getSeat(1l) );


    }
}
