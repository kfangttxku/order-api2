package th.ac.ku.order.controller;


import org.springframework.web.bind.annotation.*;
import th.ac.ku.order.data.OrderRepository;
import th.ac.ku.order.model.Orders;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    private OrderRepository orderRepository;

    public OrderRestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Orders> getAll(){
        return orderRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public Orders getOne(@PathVariable int orderId){
        return orderRepository.findById(orderId).get();
    }

    @GetMapping("/order/{orderId}")
    public List<Orders> getAllOrderId(@PathVariable int orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @PostMapping
    public Orders create(@RequestBody Orders customer) {
        Orders record = orderRepository.save(customer);
        orderRepository.flush();
        return record;
    }

    @PutMapping("/{orderId}")
    public Orders update(@PathVariable int orderId, @RequestBody Orders order) {
        Orders record = orderRepository.findById(orderId).get();
        record.setOrderStatus(order.getOrderStatus());
        record.setProductAmount(order.getProductAmount());
        orderRepository.save(record);
        return record;
    }

    @DeleteMapping("/{orderId}")
    public Orders delete(@PathVariable int orderId) {
        Orders record = orderRepository.findById(orderId).get();
        orderRepository.deleteById(orderId);
        return record;
    }
}
