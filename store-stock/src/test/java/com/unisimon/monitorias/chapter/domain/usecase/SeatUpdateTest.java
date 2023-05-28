package com.unisimon.monitorias.chapter.domain.usecase;

import com.unisimon.monitorias.chapter.domain.model.Seat;
import com.unisimon.monitorias.chapter.domain.spi.ISeatPersistencePort;
import com.unisimon.monitorias.databuilder.chapter.SeatTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SeatUpdateTest {

    @InjectMocks
    private SeatUseCase seatUseCase;

    @Mock
    private ISeatPersistencePort seatPersistencePort;


    @Test
    public void testUpdateSeat(){

        Seat seatUpdate = new SeatTestDataBuilder().buildSeat();
        seatUpdate.setId(1l);
        seatUpdate.setName("sede");
        seatUpdate.setAddress("Avenida1");
        Mockito.when(seatPersistencePort.getSeat(seatUpdate.getId())).thenReturn(seatUpdate);

        seatUseCase.updateSeat(seatUpdate);
        Seat seatReceived;
        seatReceived= seatUseCase.getSeat(1l);

        Assertions.assertEquals(seatUpdate.getName(), seatReceived.getName());
    }
}
