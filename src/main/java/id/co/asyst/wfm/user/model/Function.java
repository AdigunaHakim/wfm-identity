package id.co.asyst.wfm.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = Function.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class Function extends BaseModel
{

    public static final String TABLE_NAME = "SYS_FUNCTION";

	private static final long serialVersionUID = -4774032212649412301L;

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    private String description;

    @Column (name = "ACTIVE", nullable = true, length = 1)
    private String active;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

}

