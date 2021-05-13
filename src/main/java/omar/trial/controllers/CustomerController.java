package omar.trial.controllers;

import omar.trial.entities.Customer;
import omar.trial.entities.CustomerOrders;
import omar.trial.entities.Measurements;
import omar.trial.entities.Products;
import omar.trial.services.CustomerAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CustomerController {

    @Autowired
    CustomerAllService customerService;


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createCustomer")
    String createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer.getCustomerName(), customer.getPhoneNumber());
        return  "Customer Created";
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createProduct")
    String createProduct(@RequestBody Products products){
        customerService.createProduct(products.getProductName());
        return  "Product Created";
    }
    @PostMapping("/createMeasurements")
    String createMeasurements(@RequestBody Measurements measurements){
        customerService.createMeasurement(measurements.getMeasurementName(),measurements.getSymbol());
        return  "Measurements Created";
    }

    @PostMapping("/createOrders")
    String createOrders(@RequestBody CustomerOrders customerOrders){
        customerService.createCustomerOrder(customerOrders.getDescription(),customerOrders.getTotalPayment(),customerOrders.getDeposit(),
                customerOrders.getDayOfCollection(),customerOrders.getCustomer(),customerOrders.getProducts());
        return  "Orders Created";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/fetchAllCustomers")
    public List<Customer> fetchAllCustomers(){
        System.out.println("******************************* Customers");
        return customerService.fetchAllCustomers();

    }

    @GetMapping("/fetchAllMeasurements")
    public List<Measurements> fetchAllMeasurements(){
        System.out.println("******************************* Measuremnets");
        return customerService.fetchAllMeasurements();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/fetchAllProducts")
    public List<Products> fetchAllProducts(){
        System.out.println("******************************* Products");
        return customerService.fetchAllProducts();
    }

    @GetMapping("/fetchAllOrders")
    public List<CustomerOrders> fetchAllOrders(){
        System.out.println("******************************* Orders");
        return customerService.fetchAllCustomerOrders();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("deleteCustomer/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") UUID id) {
        customerService.deleteCustomer(id);
        System.out.println("Customer Deleted!!!");
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<Products> deleteOrder(@PathVariable("id") UUID id) {
        customerService.deleteProduct(id);
        System.out.println("Customer Deleted!!!");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("deleteMeasurement{id}")
    public String deleteMeasurement(@RequestParam UUID id) {
        customerService.deleteMeasurement(id);
        return "Measurements Deleted";
    }
    @DeleteMapping("deleteProduct{id}")
    public String deleteProduct(@RequestParam UUID id) {
        customerService.deleteProduct(id);
        return "Product Deleted";
    }

    @GetMapping(value = "/getCustomer/{id}")
    public Optional<Customer> getUser(@PathVariable UUID id) {
        System.out.println("****************************** cusomer "+customerService.findcustomer(id));
        return customerService.findcustomer(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer){
        System.out.println("customer successfully updated");
        return customerService.updateCustomer(customer); }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateProduct")
    public Products updateProduct(@RequestBody Products products){
        System.out.println("products successfully updated");
        return customerService.updateProduct(products); }

    @PutMapping("/updateMeasurement")
    public Measurements updateMeasurement(@RequestBody Measurements measurements){
        System.out.println("Measurements successfully updated");
        return customerService.updateMeasurements(measurements); }

    @PutMapping("/updateOrders")
    public CustomerOrders updateOrders(@RequestBody CustomerOrders customerOrders){
        System.out.println("customerOrders successfully updated");
        return customerService.updateCustomerOrders(customerOrders); }


}
