package lu.atozdigital.api.controller;

import lu.atozdigital.api.dto.ArticleDTO;
import lu.atozdigital.api.dto.OrderDTO;
import lu.atozdigital.api.entites.Orders;
import lu.atozdigital.api.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ModelMapper modelMapper;
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public List<OrderDTO> getAllOrders(){
    return orderService.getAllOrders().stream().map(order ->modelMapper.map(order, OrderDTO.class))
            .collect(Collectors.toList());
    }
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        try {



            Orders requestOrder = modelMapper.map(orderDTO, Orders.class);


            Orders order = orderService.createOrder(requestOrder);
            OrderDTO resOrder = modelMapper.map(order, OrderDTO.class);
            return ResponseEntity.ok().body(resOrder);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }


    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO>  changeOrder(@PathVariable Long id,@RequestBody OrderDTO orderDTO){

        try {
            Orders requestOrder = modelMapper.map(orderDTO, Orders.class);

            Orders order=orderService.changeOrder(id,requestOrder);
            OrderDTO resOrder=modelMapper.map(order,OrderDTO.class);
            return ResponseEntity.ok().body(resOrder);


        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        }



    }


}
