

public class Order {

    private int orderId;

    private int productId;

    private int quantity;

    // getters and setters

}

// Product class

public class Product {

    private int productId;

    private String name;

    private double price;

    // getters and setters

}

// OrderService class

@Path("/orders")

public class OrderService {

    @POST

    @Path("/placeOrder")

    @Consumes(MediaType.APPLICATION_JSON)

    public Response placeOrder(Order order) {

        // update the order and product tables

        // return a response indicating success or failure

    }

    @GET

    @Path("/getProducts")

    @Produces(MediaType.APPLICATION_JSON)

    public List<Product> getProducts() {

        // query the product table and return the results

    }

}

// Client code

Client client = ClientBuilder.newClient();

WebTarget target = client.target("http://localhost:8080/myapp/orders/placeOrder");

Order order = new Order();

order.setProductId(1);

order.setQuantity(2);

Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(order, MediaType.APPLICATION_JSON_TYPE));

