package id.co.asyst.wfm.user.service;


import id.co.asyst.wfm.core.service.ServiceManager;
import id.co.asyst.wfm.user.model.User;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService<T,ID> extends ServiceManager<T,ID>
{
    Object login(@Valid User user) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
