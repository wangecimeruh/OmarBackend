package omar.trial.repositories;

import omar.trial.entities.Customer;
import omar.trial.entities.CustomerOrders;
import omar.trial.entities.Measurements;
import omar.trial.entities.Products;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerAll {
    String createCustomer(String customerName, String phoneNumber);
    String createMeasurement(String measurementName, String symbol);
    String createProduct(String productName);
    String createCustomerOrder(String description, int totalPayment, int deposit, Date dayOfCollectione ,Customer customer, Products products);
    List<Customer> fetchAllCustomers();
    List<CustomerOrders> fetchAllCustomerOrders();
    List<Measurements> fetchAllMeasurements();
    List<Products> fetchAllProducts();
    String deleteCustomer(UUID id);
    String deleteOrder(UUID id);
    String deleteMeasurement(UUID id);
    String deleteProduct(UUID id);
    Customer updateCustomer(Customer customer);
    Products updateProduct(Products products);
    Measurements updateMeasurements(Measurements measurements);
    CustomerOrders updateCustomerOrders(CustomerOrders customerOrders);
    Optional<Customer> findcustomer(UUID id);
    Optional<Products> findProduct(UUID id);






}
