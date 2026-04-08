package utn_dany.Guia2SpringWeb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class CreateSale {
    private Long productId;
    private Long UserId;
    private Integer quantity;
}
