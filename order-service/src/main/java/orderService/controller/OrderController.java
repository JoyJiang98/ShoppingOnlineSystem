package orderService.controller;

import orderService.model.Order;
import orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vo.OrderVo;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/addOrder")
    public Boolean addOrder(@RequestBody OrderVo orderVo){
        orderService.save(orderVo);
        return true;
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

