package Exception;



/**
 * Исключение без проверки
 */
public class DeathAgainException extends RuntimeException {
    public DeathAgainException () {
        System.out.println("Pooh died. Finally...");
    }

}
