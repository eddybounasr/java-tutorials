/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipeetstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.cofares.ljug.Person;

/**
 *
 * @author pascalfares
 */
public class PipeEtStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Initialisation des ensembles de donnée
        List<Person> lp = new ArrayList<>();

        lp.add(new Person("Pascal Fares", 1962, 9, 25, Person.Sex.MALE, "pfares@cofares.net"));
        lp.add(new Person("Pascale1 Fares", 1963, 9, 26, Person.Sex.FEMALE, "pfares@cofares.net"));
        lp.add(new Person("Pascal2 Fares", 1964, 9, 27, Person.Sex.MALE, "pfares@cofares.net"));
        lp.add(new Person("Pascal3 Fares", 1965, 9, 28, Person.Sex.MALE, "pfares@cofares.net"));
        lp.add(new Person("Pascal4 Fares", 1966, 9, 29, Person.Sex.MALE, "pfares@cofares.net"));

        lp.stream().forEach(p -> System.out.println("Qui?" + p));
        System.out.println("----------------------");
        lp.stream()
                .filter(e -> e.getGender() == Person.Sex.MALE)
                .forEach(e -> System.out.println(e.getName()));
        System.out.println("----------------------");
        lp.stream()
                .filter(e -> e.getGender() == Person.Sex.MALE)
                //.map(e -> e.getName())
                .forEach(e -> System.out.println(e));
        System.out.println("----------------------");
        double average
                = lp.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .mapToInt(e -> e.getAge())
                .average()
                .getAsDouble();

        System.out.print("Moyenne d'ages = " + average);
        System.out.println("----------------------");
        int somme
                = lp.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .mapToInt(e -> e.getAge())
                .sum();

        System.out.print("Moyenne d'ages = " + somme);

        Map<Person.Sex, Double> averageAgeByGender = lp
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getGender,
                                Collectors.averagingInt(Person::getAge)));
        
        System.out.println("MAGE H"+averageAgeByGender.get(Person.Sex.MALE));
        System.out.println("MAGE F"+averageAgeByGender.get(Person.Sex.FEMALE));

    }

}