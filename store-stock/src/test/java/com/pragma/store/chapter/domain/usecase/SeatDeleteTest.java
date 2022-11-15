package com.pragma.store.chapter.domain.usecase;

import com.pragma.store.chapter.domain.model.Seat;
import com.pragma.store.chapter.domain.spi.ISeatPersistencePort;
import com.pragma.store.databuilder.chapter.SeatTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
