package uz.pdp.productcrud2.paylod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.productcrud2.utils.MessageConstants;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStatusReqDTO {

    @NotNull(message = MessageConstants.PRODUCT_STATUS_CANNOT_BE_NULL)
    @NotBlank(message = MessageConstants.PRODUCT_STATUS_CANNOT_BE_BLANK)
    private String name;

}
