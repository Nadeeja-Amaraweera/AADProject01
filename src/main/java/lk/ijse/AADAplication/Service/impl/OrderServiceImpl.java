package lk.ijse.AADAplication.Service.impl;

import lk.ijse.AADAplication.Repository.CustomerRepository;
import lk.ijse.AADAplication.Repository.OrderRepository;
import lk.ijse.AADAplication.Service.OrderService;
import lk.ijse.AADAplication.dto.SaveOrderDTO;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveOrder(SaveOrderDTO saveOrderDTO) {

    }
}
