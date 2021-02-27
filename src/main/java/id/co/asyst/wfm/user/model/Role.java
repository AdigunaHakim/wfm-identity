package id.co.asyst.wfm.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "SYS_ROLE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class Role extends BaseModel
{
	private static final long serialVersionUID = 7730151828796959686L;

	@Id
    @Column(name = "ROLE_CODE")
    private String roleCode;

    @Column(name = "ROLE_DESC", nullable = false, length = 100)
    private String roleDesc;

    @Column (name = "ACTIVE", nullable = true, length = 1)
    private String active;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}

