package ra.rekkei.restapi_basic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer proId;
    @Column(name = "product_name",length = 100)
    private  String proName;
    @Column(name = "producer")
    private String producer;
    @Column(name = "year_making")
    private Integer yearMaking;
    @Column(name = "expireDate")
    private Date expireDate;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category cate;
}
