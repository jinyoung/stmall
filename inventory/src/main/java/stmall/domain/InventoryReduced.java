package stmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import stmall.domain.*;
import stmall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InventoryReduced extends AbstractEvent {

    private Long id;

    public InventoryReduced(Inventory aggregate) {
        super(aggregate);
    }

    public InventoryReduced() {
        super();
    }
}
//>>> DDD / Domain Event
