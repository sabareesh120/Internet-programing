
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OrderClient {
    
    public static void main(String[] args) {
        // Creating a new order
        Order order = new Order();
        // Set the order details
        // ...
        Response response = ClientBuilder.newClient()
                .target("http://localhost:8080/orders/create")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(order));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        
        // Updating an existing order
        Order updatedOrder = new Order();
        // Set the updated order details
        // ...
        response = ClientBuilder.newClient()
                .target("http://localhost:8080/orders/update/123")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(updatedOrder));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        
        // Creating a new product
        Product product = new Product();
        // Set the product details
        // ...
        response = ClientBuilder.newClient()
                .target("http://localhost:8080/orders/product/create")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(product));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        
        // Updating an existing product
        Product updatedProduct = new Product();
        // Set the updated product details
        // ...
        response = ClientBuilder.newClient()
                .target("http://localhost:8080/orders/product/update/123")
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(updatedProduct));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}
