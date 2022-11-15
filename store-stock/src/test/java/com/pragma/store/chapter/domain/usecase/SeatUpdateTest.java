package com.pragma.store.chapter.domain.usecase;

import com.pragma.store.chapter.domain.model.Seat;
import com.pragma.store.chapter.domain.spi.ISeatPersistencePort;
import com.pragma.store.chapter.infrastructure.persistence.adapter.SeatJpaAdapter;
import com.pragma.store.databuilder.chapter.SeatTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
