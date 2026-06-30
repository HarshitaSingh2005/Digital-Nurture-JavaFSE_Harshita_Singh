package EngineeringConcepts.dsa.ecommercesearch.code;

public class ECommerceSearchTest {

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Watch", "Accessories"),
                new Product(104, "Phone", "Electronics"),
                new Product(105, "Headphones", "Electronics")
        };

        int targetId = 104;

        Product linearResult =
                SearchService.linearSearch(products, targetId);

        Product binaryResult =
                SearchService.binarySearch(products, targetId);

        System.out.println("Linear Search Result:");
        System.out.println(linearResult);

        System.out.println();

        System.out.println("Binary Search Result:");
        System.out.println(binaryResult);
    }
}