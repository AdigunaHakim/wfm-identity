package id.co.asyst.wfm.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = RoleFunction.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class RoleFunction extends BaseModel
{

    public static final String TABLE_NAME = "SYS_ROLE_FUNCTION";

	private static final long serialVersionUID = 1148121595937744767L;

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    private  Function function;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}

