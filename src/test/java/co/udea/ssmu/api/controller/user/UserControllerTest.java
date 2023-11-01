/*package co.udea.ssmu.api.controller.user;

import co.udea.ssmu.api.model.jpa.dto.user.UserDTO;
import co.udea.ssmu.api.model.jpa.model.role.Role;
import co.udea.ssmu.api.services.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @Spy
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void saveTest() throws Exception {

        String emailFelipe = "email";
        String passwordFelipe = "password";
        String passwordFelipeEncode = "$2a$10$L9Ds81Jom54PEytzkjYIkeBqYekFa5zJvxPxpo2Ce0mmqSbKL9Zhm";
        Role roleAdmin = new Role(1L,"Admin", null);

        List<Role> rolesFelipe = List.of(roleAdmin);

        UserDTO userDTOFelipe = new UserDTO(emailFelipe, passwordFelipe, rolesFelipe);

        UserDTO userDTOFelipePasswordEncode = new UserDTO(emailFelipe, passwordFelipeEncode, rolesFelipe);

        String userDTOJSON = new ObjectMapper()
                .writeValueAsString(userDTOFelipe);

        Mockito.when(userService.save(Mockito.any(UserDTO.class)))
                .thenReturn(userDTOFelipePasswordEncode);

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
                        .content(userDTOJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(Matchers.is(emailFelipe)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value(Matchers.is(passwordFelipeEncode)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roles[0].name").value(Matchers.is("Admin")))
                .andDo(MockMvcResultHandlers.print());

        Mockito.verify(userService)
                .save(Mockito.any(UserDTO.class));

    }
}
*/