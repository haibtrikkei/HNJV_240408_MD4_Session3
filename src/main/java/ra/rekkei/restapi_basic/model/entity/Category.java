package ra.rekkei.restapi_basic.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import java.util.List;

@Entity
@Table(name = "cateogries")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "category_id")
    private String cateId;
    @Column(name = "category_name",length = 100)
    private String cateName;
    @Column(name = "status")
    private Boolean status;

//    @OneToMany(mappedBy = "cate")
//    @JsonIgnore
//    private List<Product> products;
}
