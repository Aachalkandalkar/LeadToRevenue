

## **Name : Product Management API**
### Framwork : SpringBoot
### Language : Java

## Application Properties

spring.datasource.driver-class-name = com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/leadtorev?createDatabaseIfNotExist=true
spring.datasource.username = root
spring.datasource.password = root
spring.jpa.show-sql = true
spring.jpa.database-platform = org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto = update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql = true
spring.jpa.properties.hibernate.show_sql = true
spring.jpa.properties.hibernate.hbm2ddl.auto = update

### Controller Package

This Package Handles the HTTP Request from the client. It contains the Three classes

* AttributeController
* AvailabilityController
* CategoryController
* ProductController
* RatingController

These models have mainly CRUD Operation Request

**1.@GetMapping**: The @GetMapping annotation is used to map HTTP GET requests to a specific method in the controller class. It is used to retrieve or fetch data from the server. It can be applied to a class or a specific method. In the example, @GetMapping is used on the getAllComment method to map a GET request to the /productId endpoint, which retrieves a list of all Product.

#### Get Product by ID
**GET** `/product/{productId}`
Retrieves the product with the specified ID.

**2.@PostMapping** :  
i.The @PostMapping annotation is used to map HTTP POST requests to a specific method in the controller class.  
ii.It is used to submit or create new data on the server.   
iii.It can be applied to a class or a specific method.

#### Create Product

**POST** `/product/create`
Creates a new product.

**Request Body:**
```json
{
  "productName": "string",
  "description": "string",
  "price": 0.0,
  "categories": [
    {
      "name": "string"
    }
  ],
  "attributes": [
    {
      "name": "string",
      "value": "string"
    }
  ],
  "availability": {
    "inStock": true,
    "quantity": 0
  },
  "rating": [
    {
      "userId": 0,
      "rating": 0,
      "comment": "string"
    }
  ]
}
```


**3.@PutMapping**:  
i.The @PutMapping annotation is used to map HTTP PUT requests to a specific method in the controller class.  
ii.It is used to update or modify existing data on the server.  
iii.It can be applied to a class or a specific method.

#### Update Product

**PUT** `/product/{productId}`
Updates the product with the specified ID.

**4.@DeleteMapping** :  
i.The @DeleteMapping annotation is used to map HTTP DELETE requests to a specific method in the controller class.  
ii.It is used to delete or remove data from the server.  
iii.It can be applied to a class or a specific method.

#### Delete Product

**DELETE** `/product/{productId}`
Deletes the product with the specified ID.

### Service Package
This is a Java Spring Boot service class that contains methods for performing CRUD (Create, Read, Update, Delete) operations on job objects. It is annotated with @Service, which is a Spring stereotype annotation indicating that this class is a service. This package also consist of Three classes.

* AttributeService
* AvailabilityService
* CategoryService
* ProductService
* RatingService

### Repository Package
This package consist of interfaces. Which defines a set of methods that can be used to interact with the underlying database. The interface extends the JpaRepository interface and specifies the Job entity and the data type of its primary key Integer. The interface contains several custom finder methods that use the naming convention of Spring Data JPA to automatically generate the queries. In summary, this code implements a simple REST ful API for managing Job objects with endpoints for performing CRUD operations.

* IAttributeRepo
* IAvailabilityRepo
* ICategoryRepo
* IProductRepo
* IRatingRepo

### Model package

Model package Consist of three classes

* Attribute
* Availability
* Category
* Product
* Rating




All below annotations are applied on each class above:

1.@Entity: Indicates that this class is a JPA entity and should be mapped to a database table.  
2.@Table: Specifies the name of the database table to which this entity is mapped.  
3.@Id: Indicates that the id field is the primary key of the entity.  
4.@GeneratedValue: Specifies the strategy for generating values for the primary key. In this case, it uses GenerationType.IDENTITY.


### Error Handling

This package is specially used to handle Error Exception.

1.ResourceNotFoundException


