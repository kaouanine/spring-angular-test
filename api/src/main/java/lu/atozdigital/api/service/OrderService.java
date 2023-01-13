package lu.atozdigital.api.service;

import lu.atozdigital.api.entites.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getAllOrders();
    Orders createOrder(Orders order);
    Orders changeOrder(Long id,Orders order);
}
