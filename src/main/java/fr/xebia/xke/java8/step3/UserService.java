package fr.xebia.xke.java8.step3;

import fr.xebia.xke.java8.data.Role;
import fr.xebia.xke.java8.data.User;
import fr.xebia.xke.java8.other.UserParser;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserService {

    private static final String DEFAULT_FORMATED_ADDRESS = "1 rue de Rivoli\n75001 Paris";
    private List<User> users;

    public UserService() {
        users = UserParser.fromCsv("users.csv");

    }

    public UserService(List<User> users) {
        this.users = users;
    }

    public long countUserWithRole(Role role) {

        return users.stream().filter(u -> u.getRole() == role).count();
    }

    public boolean isLoginAlreadyExist(String login) {

        return users.stream().anyMatch(u -> u.getLogin().equals(login));
    }

    public String retrieveFormatedUserAddressByLogin(String login) {
        
    	return users.stream().filter(u -> u.getLogin().equals(login))
				.findFirst().flatMap(u -> u.getAddress())
				.map(a -> a.formatForEnveloppe())
				.orElse(DEFAULT_FORMATED_ADDRESS);
	}

    /**
     * Return a copy of users list ordered by lastname and firstname
     *
     * @return
     */
    public List<User> findAll() {
        //TODO: replace specific comparator by Comparator static methods and collect with Collectors
        List<User> usersOrdered = new ArrayList<>(users.size());
        usersOrdered.addAll(users);

		Collections.sort(usersOrdered,
				(u1, u2) -> u1.getLastname().equals(u2.getLastname()) ? u1
						.getFirstname().compareTo(u2.getFirstname()) : u1
						.getLastname().compareTo(u2.getLastname()));

        return usersOrdered;
    }

    public Map<Role, List<User>> retrieveActiveUserByRole() {

        return users.stream().filter(u -> !u.isExpired()).collect(Collectors.groupingBy(u -> u.getRole()));
    }

    public Map<String, User> retrieveUserwithRoleByLogin(Role role) {

    	//TODO(is it possible to use "Class::method" somewhere else?)
    	return users.stream().filter(u -> u.getRole() == role).collect(Collectors.toMap(User::getLogin, Function.identity()));
    }

    public String generateAgeStatistic() {
        IntSummaryStatistics iss = users.stream().collect(Collectors.summarizingInt(u -> u.age()));
    	
        return String.format("Number of user : %d\nAge min : %d\nAge max : %d\nAge average : %.2f", iss.getCount(), iss.getMin(), iss.getMax(), iss.getAverage());
    }
}
