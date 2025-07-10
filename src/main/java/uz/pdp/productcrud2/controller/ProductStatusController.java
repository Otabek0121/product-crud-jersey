package uz.pdp.productcrud2.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import uz.pdp.productcrud2.service.ProductStatusService;
import uz.pdp.productcrud2.entity.ProductStatus;

import java.util.List;

@Path("/product-status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductStatusController {

    @Inject
    private ProductStatusService productStatusService;

    @GET
    public List<ProductStatus> getAll() {
        return productStatusService.findAll();
    }


}
