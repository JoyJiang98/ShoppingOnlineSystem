package categoryService.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer level;

    @Column(name = "parent_id") private Long parentId;

    @Column(name = "order_number")
    private Long orderNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    @OrderBy(value = "orderNumber ASC")
    private List<Category> childs;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
    @OrderBy(value = "orderNumber ASC")
    private List<Category> children;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Category parent;


    @NotNull @Size(min = 2, max = 20) private String name;


    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "img")
    private String img;

    @Column(name = "detail")
    private String detail;

    public Category() {
    }

    public Category(Integer level, Long parentId, List<Category> childs, String name, Long orderNumber,
                    BigDecimal price, String img, String detail) {
        this.level = level;
        this.parentId = parentId;
        this.childs = childs;
        this.name = name;
        this.orderNumber = orderNumber;
        this.price = price;
        this.img = img;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Category> getChilds() {
        return childs;
    }

    public void setChilds(List<Category> childs) {
        this.childs = childs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override public String toString() {
        return "Category{" + "id=" + id + ", level=" + level + ", parentId=" + parentId + ", childs=" + childs
                + ", name='" + name + '\'' + ", orderNumber=" + orderNumber + ", price=" + price + ", img='" + img
                + '\'' + ", detail='" + detail + '\'' + '}';
    }
}
