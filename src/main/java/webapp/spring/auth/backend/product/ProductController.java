package webapp.spring.auth.backend.product;


import webapp.spring.auth.backend.product.customerproduct.CustomerProductResponse;
import webapp.spring.auth.backend.security.auth.filter.AuthFilterController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Tag(name = "ProductApi", description = "Finds available products")
@RestController
@RequestMapping("/api")
public class ProductController extends AuthFilterController {

    @Autowired
    ProductService productService;

    @Operation(summary = "Available products (Need authentication)", description = "Gets available products to administration",
            security = {
                    @SecurityRequirement(name = "Bearer")})
    @GetMapping(path = "/products/admin")
    @PreAuthorize("hasRole('ADMIN') and #this.this.preAuthorizeFilter(principal.getCustomerCode)")
    public ResponseEntity<List<CustomerProductResponse>> getProductsAdmin() {
        return ResponseEntity.ok(productService.getAvailableProducts());
    }

    @Operation(summary = "Available products (Need authentication)", description = "Gets available products by tenant customers",
            security = {
                    @SecurityRequirement(name = "Bearer")})
    @GetMapping(path = "/products/{customerCode}")
    @Parameter(name = "customerCode", example = "1", description = "Example customers: 1 (Customer 01), 2 (Customer 02). To get all available customers request: /api/customers")
    @PreAuthorize("(principal.getCustomerCode == #customerCode and (hasRole('ADMIN') or hasRole('MODERATOR')  or hasRole('USER') )) or #this.this.preAuthorizeFilter(principal.getCustomerCode)")
    public ResponseEntity<List<ProductResponse>> getProducts(
            @PathVariable("customerCode") Long customerCode
    ) {
        return ResponseEntity.ok(productService.getAvailableProducts(customerCode));
    }

}
