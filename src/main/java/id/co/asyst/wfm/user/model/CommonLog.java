package id.co.asyst.wfm.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sys_common_log")
public class CommonLog {

    @Id
    private Long log_id;

    @Column(nullable = true)
    private Date log_date;

    @Column(nullable = true)
    private Long user_id;

    @Column(nullable = true, length = 100)
    private String service_name;

    @Column(nullable = true, length = 100)
    private String operation_name;

    @Column(nullable = true)
    private String request;

    @Column(nullable = true)
    private String response;

    @Column(nullable = true, length = 15)
    private Double procecing_time;

    @Column(nullable = true, length = 5)
    private String response_code;

    @Column(nullable = true)
    private String message;

    @Column(nullable = true)
    private String error_desc;

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public Date getLog_date() {
        return log_date;
    }

    public void setLog_date(Date log_date) {
        this.log_date = log_date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getOperation_name() {
        return operation_name;
    }

    public void setOperation_name(String operation_name) {
        this.operation_name = operation_name;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Double getProcecing_time() {
        return procecing_time;
    }

    public void setProcecing_time(Double procecing_time) {
        this.procecing_time = procecing_time;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError_desc() {
        return error_desc;
    }

    public void setError_desc(String error_desc) {
        this.error_desc = error_desc;
    }
}

