package lu.atozdigital.api.repositories;

import lu.atozdigital.api.entites.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
