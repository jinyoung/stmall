package stmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryConfirmed extends AbstractEvent {

    private Long id;

    public DeliveryConfirmed(Order aggregate) {
        super(aggregate);
    }

    public DeliveryConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
