package id.co.asyst.wfm.user.service;

import id.co.asyst.wfm.core.service.BaseServiceManager;
import id.co.asyst.wfm.user.model.User;
import id.co.asyst.wfm.user.model.UserRole;
import id.co.asyst.wfm.user.repository.UserRepository;
import id.co.asyst.wfm.user.repository.UserRoleRepository;
import id.co.asyst.wfm.user.utils.EncodePassword;
import id.co.asyst.wfm.user.utils.LoginStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

@Service
public class UserServiceImpl extends BaseServiceManager<User,String> implements UserService<User,String>
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Collection<User> findAll() {
        return (Collection<User>) userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public LoginStatus login(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        LoginStatus state = new LoginStatus();
        User userLog = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (userLog != null){
            UserRole userRole = userRoleRepository.findByUser(userLog);
            if (userRole != null){
                state.setUsername(userLog.getUsername());
                state.setEmployeeId(userLog.getEmployeeId());
                state.setRoleCode(userRole.getRole().getRoleCode());
                state.setRoleDesc(userRole.getRole().getRoleDesc());
                state.setActive("Y");
                state.setStatus("Success");
            }
            else{
                state.setUsername(userLog.getUsername());
                state.setEmployeeId(userLog.getEmployeeId());
                state.setRoleCode(null);
                state.setRoleDesc(null);
                state.setActive("Y");
                state.setStatus("Failed");
            }
        }
        else{
            userLog = userRepository.findByEmployeeIdAndPassword(user.getUsername(), user.getPassword());
            if (userLog != null){
                UserRole userRole = userRoleRepository.findByUser(userLog);
                if (userRole != null){
                    state.setUsername(userLog.getUsername());
                    state.setEmployeeId(userLog.getEmployeeId());
                    state.setRoleCode(userRole.getRole().getRoleCode());
                    state.setRoleDesc(userRole.getRole().getRoleDesc());
                    state.setActive("Y");
                    state.setStatus("Success");
                }
                else{
                    state.setUsername(userLog.getUsername());
                    state.setEmployeeId(userLog.getEmployeeId());
                    state.setRoleCode(null);
                    state.setRoleDesc(null);
                    state.setActive("Y");
                    state.setStatus("Failed");
                }
            }
            else{
                state.setUsername(null);
                state.setEmployeeId(null);
                state.setRoleCode(null);
                state.setRoleDesc(null);
                state.setActive(null);
                state.setStatus("Failed");
            }
        }

        return state;
    }
}
