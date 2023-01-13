package lu.atozdigital.api.service;

import lu.atozdigital.api.entites.Orders;
import lu.atozdigital.api.repositories.OrderRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders createOrder(Orders order) {

        UUID randomUUID = UUID.randomUUID();

        order.setReference(randomUUID.toString().replaceAll("-", "").substring(0,10).toUpperCase());
        order.setDate(new Date());

        return orderRepository.save(order);
    }

    @Override
    public Orders changeOrder(Long id, Orders newOrder) {
        Orders order=orderRepository.getById(id);
        System.out.print(newOrder.getArticle());
        order.setArticle(newOrder.getArticle());
        return orderRepository.save(order);
    }


}
