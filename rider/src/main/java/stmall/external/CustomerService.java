
package stmall.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "customer", url = "${api.url.customer}")
 
public interface CustomerService {
    @GetMapping(path="/customers/search/findByGetPhoneNumberById/{id}")
    public Customer getPhoneNumberById(@PathVariableGetPhoneNumberByIdQuery getPhoneNumberByIdQuery);

}



