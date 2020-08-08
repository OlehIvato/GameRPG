package spring.service.imp;

import org.junit.Test;
import org.mockito.Mockito;
import spring.model.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class UserServiceImpTest {

    @Test
    public void getOneById() {
        UserServiceImp userServiceImp = Mockito.mock(UserServiceImp.class);
        when(userServiceImp.getOneById(1L)).thenReturn(new User());
        assertEquals(userServiceImp.getOneById(1L), new User());
    }
}