package uz.pdp.productcrud2.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import uz.pdp.productcrud2.controller.ProductStatusController;
import uz.pdp.productcrud2.repository.ProductRepository;
import uz.pdp.productcrud2.service.ProductStatusService;
import uz.pdp.productcrud2.service.ProductStatusServiceImpl;

public class AppConfig extends ResourceConfig {

    public AppConfig() {

            register(ProductStatusController.class);
            register(new AbstractBinder() {
                @Override
                protected void configure() {
                    bind(ProductStatusServiceImpl.class).to(ProductStatusService.class);
                    bind(ProductRepository.class).to(ProductRepository.class);
                }
            });
            // Now you can expect validation errors to be sent to the
            // client.
            property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

    }


}