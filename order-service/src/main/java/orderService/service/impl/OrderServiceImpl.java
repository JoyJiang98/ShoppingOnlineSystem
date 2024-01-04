package orderService.service.impl;


import orderService.model.Order;
import orderService.model.OrderCategory;
import orderService.repository.OrderCategoryRepository;
import orderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import orderService.service.OrderService;
import vo.OrderVo;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderCategoryRepository orderCategoryRepository;

    @Override public boolean save(OrderVo orderVo) {
        Order order = new Order();
        order.setDatetime(new Date());
        order.setState(0);
        order.setUserId(orderVo.getUserId());
        order.setSummoney(orderVo.getSummoney());

        Order order1 = orderRepository.save(order);

        OrderCategory orderCategory = new OrderCategory();
        orderCategory.setCategoryId(orderVo.getCategoryId());
        orderCategory.setCreateTime(new Date());
        orderCategory.setOrderId(order1.getId());
        //TODO 默认设置为 1
        orderCategory.setNum(1);
        orderCategoryRepository.save(orderCategory);
        return true;
    }


    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

}
