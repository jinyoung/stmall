package stmall.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stmall.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/deliveries")
@Transactional
public class DeliveryController {

    @Autowired
    DeliveryRepository deliveryRepository;

    @RequestMapping(
        value = "/deliveries/{id}/complete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Delivery complete(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /delivery/complete  called #####");
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(id);

        optionalDelivery.orElseThrow(() -> new Exception("No Entity Found"));
        Delivery delivery = optionalDelivery.get();
        delivery.complete();

        deliveryRepository.save(delivery);
        return delivery;
    }
}
//>>> Clean Arch / Inbound Adaptor
