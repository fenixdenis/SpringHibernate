package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.Cache;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User user1 = new User("Denis","Dobriy","denis1987@gmail.com");
      Car car1 = new Car("Volvo",7);
      User user2 = new User("Lakshmi","Narayan","Lac1987@gmail.com");
      Car car2 = new Car("Audy",8);
      user1.setCar(car1);
      car1.setUser(user1);
      user2.setCar(car2);
      car2.setUser(user2);

      userService.add(user1);
      userService.add(user2);
      List<User> userCar  = userService.getUserCar("Audy",8);
      for (User use : userCar){
         System.out.println("First Name = "+use.getFirstName());
         System.out.println();

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+ user.getCarToSring());
         System.out.println();


      context.close();
   }
}}}
