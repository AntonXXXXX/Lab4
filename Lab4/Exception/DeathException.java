package Exception;
import AbstractClasses.Animal;

/**
 * Проверяемое исключение
 */
public class DeathException extends Exception{
    public DeathException (Animal animal) {
        System.out.println(animal + " tired...");
    }
}
