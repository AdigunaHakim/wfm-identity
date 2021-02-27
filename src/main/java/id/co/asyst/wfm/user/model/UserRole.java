package id.co.asyst.wfm.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "SYS_USER_ROLE")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler","created_date", "last_updated", },
        allowGetters = true, ignoreUnknown = true)
public class UserRole extends BaseModel
{

	private static final long serialVersionUID = -5827949025205724900L;

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Role role;

   @Column (name = "ACTIVE", nullable = true, length = 1)
    private String active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}

