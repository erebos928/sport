package football;

import entities.Nationality;
import entities.Player;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("liga");
        EntityManager em = emf.createEntityManager();
        List<Player> players = em.createQuery("select player from Player player").getResultList();
        //Map<Nationality,List<Player>> bPlayers = players.stream().collect(groupingBy(Player::getNationality));
        double average = players.stream()
                .collect(Collectors.averagingInt(Player::getAge));
        System.out.println(players.size());
    }
}
