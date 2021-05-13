package omar.trial.services;

import omar.trial.entities.Customer;
import omar.trial.entities.CustomerOrders;
import omar.trial.entities.Measurements;
import omar.trial.entities.Products;
import omar.trial.repositories.CustomerAll;
import omar.trial.repositories.jpa.CusomerOrdersInterfaceJPA;
import omar.trial.repositories.jpa.CustomerInterfaceJPA;
import omar.trial.repositories.jpa.MeasurementsInterfaceJPA;
import omar.trial.repositories.jpa.ProductInterfaceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerAllService implements CustomerAll {

    @Autowired
    CustomerInterfaceJPA customerInterfaceJPA;
    @Autowired
    MeasurementsInterfaceJPA measurementsInterfaceJPA;
    @Autowired
    ProductInterfaceJPA productInterfaceJPA;
    @Autowired
    CusomerOrdersInterfaceJPA cusomerOrdersInterfaceJPA;


    @Override
    public String createCustomer(String customerName, String phoneNumber) {
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setPhoneNumber(phoneNumber);

        customerInterfaceJPA.save(customer);

        System.out.println("*************************   "+customer.getCustomerName());

        return "Customer Created!!!";
    }

    @Override
    public String createMeasurement(String measurementName, String symbol) {
        Measurements measurements = new Measurements();
        measurements.setMeasurementName(measurementName);
        measurements.setSymbol(symbol);

        measurementsInterfaceJPA.save(measurements);
        return "Measurements Created";
    }

    @Override
    public String createProduct(String productName) {
        Products products = new Products();
        products.setProductName(productName);
        productInterfaceJPA.save(products);

        return "Product Created";
    }

    @Override
    public String createCustomerOrder(String description, int totalPayment, int deposit, Date dayOfCollection, Customer customer,Products products) {

        Products products1 = this.findProduct(products.getId()).get();

        Customer customer1 = this.findcustomer(customer.getId()).get();
        if (customer1==null){
            return "Customer is non existent";
        }
        if (products1==null){
            return "Product does not exist";
        }
        CustomerOrders customerOrders = new CustomerOrders();
        customerOrders.setDeposit(deposit);
        customerOrders.setDayOfCollection(dayOfCollection);
        customerOrders.setDescription(description);
        customerOrders.setTotalPayment(totalPayment);
        customerOrders.setCustomer(customer1);
        customerOrders.setProducts(products1);
        customerOrders.setBalance(customerOrders.getTotalPayment() - customerOrders.getDeposit());
        cusomerOrdersInterfaceJPA.save(customerOrders);

        return "Customer Order Created";
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return customerInterfaceJPA.findAll();
    }
    @Override
    public List<CustomerOrders> fetchAllCustomerOrders() {
        return cusomerOrdersInterfaceJPA.findAll();
    }
    @Override
    public List<Measurements> fetchAllMeasurements() {
        return measurementsInterfaceJPA.findAll();
    }
    @Override
    public List<Products> fetchAllProducts() {
        return productInterfaceJPA.findAll();
    }

    @Override
    public String deleteCustomer(UUID id) {
        customerInterfaceJPA.deleteById(id);

        return "Customer Deleted!!";
    }

    @Override
    public String deleteOrder(UUID id) {
        cusomerOrdersInterfaceJPA.deleteById(id);
        return "Order Deleted";
    }

    @Override
    public String deleteMeasurement(UUID id) {
        measurementsInterfaceJPA.deleteById(id);
        return "Measurement deleted";
    }

    @Override
    public String deleteProduct(UUID id) {
        productInterfaceJPA.deleteById(id);
        return "Product Deleted";
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customer1 = findcustomer(customer.getId()).get();
        customer1.setCustomerName(customer.getCustomerName());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        return customerInterfaceJPA.save(customer1);
    }

    @Override
    public Products updateProduct(Products products) {
        Products products1 = findProduct(products.getId()).get();
        products1.setProductName(products.getProductName());
        return productInterfaceJPA.save(products1);
    }

    @Override
    public Measurements updateMeasurements(Measurements measurements) {
        return measurementsInterfaceJPA.save(measurements);
    }

    @Override
    public CustomerOrders updateCustomerOrders(CustomerOrders customerOrders) {
        return cusomerOrdersInterfaceJPA.save(customerOrders);
    }

    @Override
    public Optional<Customer> findcustomer(UUID id){
        Optional<Customer> customer= null;
        customer=customerInterfaceJPA.findById(id);
        return customer;
    }

    @Override
    public Optional<Products> findProduct(UUID id){
        Optional<Products> products= null;
        products=productInterfaceJPA.findById(id);
        return products;
    }


}
