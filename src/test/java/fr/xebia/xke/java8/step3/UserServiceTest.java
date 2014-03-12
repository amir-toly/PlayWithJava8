package fr.xebia.xke.java8.step3;

import fr.xebia.xke.java8.data.Role;
import fr.xebia.xke.java8.data.User;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {

    private UserService userService = new UserService();

    @Test
    public void should_return_count_of_Role() {
        assertThat(userService.countUserWithRole(Role.SALES)).isEqualTo(322);
        assertThat(userService.countUserWithRole(Role.ENGINEER)).isEqualTo(336);
        assertThat(userService.countUserWithRole(Role.TRADER)).isEqualTo(342);
    }

    @Test
    public void should_return_true_if_login_exist() {
        assertThat(userService.isLoginAlreadyExist("rogerbernard")).isTrue();
        assertThat(userService.isLoginAlreadyExist("ivanbeauvais")).isFalse();

    }

    @Test
    public void should_return_formated_address_when_user_with_address_exist() {
        assertThat(userService.retrieveFormatedUserAddressByLogin("rogerbernard")).isEqualTo("10 South Street\nMONTARA 94037");
    }

    @Test
    public void should_return_formated_address_when_user_without_address_exist() {
        assertThat(userService.retrieveFormatedUserAddressByLogin("julielaurent")).isEqualTo("1 rue de Rivoli\n75001 Paris");
    }

    @Test
    public void should_return_throw_exception_when_user_not_exist() {
        assertThat(userService.retrieveFormatedUserAddressByLogin("ivanbeauvais")).isEqualTo("1 rue de Rivoli\n75001 Paris");
    }

    @Test
    public void should_return_list_ordered_by_firstname_and_lastname() {
        //given
        List<User> users = new ArrayList<>();
        users.add(new User("Mme", "Martine", "Mercier"));
        users.add(new User("M.", "Christophe", "Mercier"));
        users.add(new User("Mme", "Pascal", "Dubois"));

        UserService userService = new UserService(users);

        //when
        List<User> usersOrdered = userService.findAll();

        //Then
        assertThat(usersOrdered.toString()).isEqualTo("[User{title='Mme', firstname='Pascal', lastname='Dubois'}, User{title='M.', firstname='Christophe', lastname='Mercier'}, User{title='Mme', firstname='Martine', lastname='Mercier'}]");
    }

    @Test
    public void should_return_active_users_by_role() {
        Map<Role, List<User>> activeUsersByRole = userService.retrieveActiveUserByRole();

        List<User> engineers = activeUsersByRole.get(Role.ENGINEER);
        List<User> traders = activeUsersByRole.get(Role.TRADER);
        List<User> sales = activeUsersByRole.get(Role.SALES);

        assertThat(engineers).hasSize(112);
        assertThat(sales).hasSize(105);
        assertThat(traders).hasSize(128);

        assertThat(engineers).are(activeUser()).are(userWithRole(Role.ENGINEER));
        assertThat(traders).are(activeUser()).are(userWithRole(Role.TRADER));
        assertThat(sales).are(activeUser()).are(userWithRole(Role.SALES));
    }

    @Test
    public void should_return_user_by_login() {
        Map<String, User> usersByLogin = userService.retrieveUserwithRoleByLogin(Role.SALES);

        assertThat(usersByLogin).hasSize(322);
        assertThat(usersByLogin.entrySet()).are(keyIsLoginOfValue());
        assertThat(usersByLogin.values()).are(userWithRole(Role.SALES));

    }

    private Condition<Map.Entry<String, User>> keyIsLoginOfValue() {
        return new Condition<Map.Entry<String, User>>() {
            public boolean matches(Map.Entry<String, User> value) {
                return value.getKey().equals(value.getValue().getLogin());
            }
        };
    }

    private Condition<User> userWithRole(Role role) {
        return new Condition<User>() {
            @Override
            public boolean matches(User user) {
                return user.getRole() == role;
            }
        };
    }

    private Condition<User> activeUser() {
        return new Condition<User>() {
            public boolean matches(User user) {
                return !user.isExpired();
            }
        };
    }
}