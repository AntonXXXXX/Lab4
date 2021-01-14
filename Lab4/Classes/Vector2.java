package Classes;
import java.util.Objects;
/**
 * Класс позиции (добавлен что бы было проще)
 * @author Антон Хрусталев
 * @version 1.0
 */
public class Vector2 {
    public int x;
    public int y;

    /**
     * Конструктор координаты
     * @param x
     * @param y
     */
    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * вычисление текущей позиции в обьеденении с другой позицией
     * @param another
     */
    public void add(Vector2 another) {
        this.x += another.x;
        this.y += another.y;
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public boolean equals(Vector2 another) {
        return this.x == another.x && this.y == another.y;
    }

    public int hasCode() {
        return Objects.hash(this.x, this.y);
    }
}
