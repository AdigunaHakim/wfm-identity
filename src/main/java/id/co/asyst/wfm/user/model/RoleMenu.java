package id.co.asyst.wfm.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import id.co.asyst.wfm.core.model.BaseModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = RoleMenu.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "last_updated", "hibernateLazyInitializer", "handler"},
        allowGetters = true, ignoreUnknown = true)
public class RoleMenu extends BaseModel
{

    public static final String TABLE_NAME = "SYS_ROLE_MENU";

	private static final long serialVersionUID = -3691200535775509048L;

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    private Menu menu;

    @Column (name = "V", nullable = true, length = 1)
    private String view;

    @Column (name = "E", nullable = true, length = 1)
    private String edit;

    @Column (name = "D", nullable = true, length = 1)
    private String delete;

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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}

