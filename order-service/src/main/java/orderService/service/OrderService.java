package orderService.service;


import orderService.model.Order;
import vo.OrderVo;

public interface OrderService {
    boolean save(OrderVo orderVo);
    Order getOrderById(Long orderId);
}
