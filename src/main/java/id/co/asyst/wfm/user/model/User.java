package id.co.asyst.wfm.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = User.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class User extends BaseModel
{

    public static final String TABLE_NAME = "SYS_USER";

	private static final long serialVersionUID = 4244747268665605088L;

    @Id
    @Column (name = "USERNAME", nullable = false, unique = true, length = 50)
    private String username;

    @Column (name = "EMPLOYEE_ID", nullable = false, length = 255)
    private String employeeId;

    @Column (name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column (name = "FULLNAME", nullable = false, length = 255)
    private String fullname;

    @Column (name = "IS_LOGIN", length = 1, nullable = true)
    private String isLogin;

    @Column(name = "LAST_LOGIN", nullable = true)
    private Date lastLogin;

    @Column (name = "ACTIVE", nullable = true, length = 1)
    private String active;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}



