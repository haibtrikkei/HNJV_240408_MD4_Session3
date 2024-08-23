package ra.rekkei.restapi_basic.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {
    @NotBlank(message = "Product name is empty!")
    private  String proName;
    @NotBlank(message = "Product name is empty!")
    private String producer;
    @NotNull(message = "Year making is empty")
    private Integer yearMaking;
    @NotNull(message = "Expire date is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date is not valid!")
    private Date expireDate;
    @NotNull(message = "Category id is empty")
    private String cateId;
}
