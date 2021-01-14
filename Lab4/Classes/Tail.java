package Classes;
import AbstractClasses.StaticEntity;
/**
 * Класс хвоста (статическая сущность)
 * @author Антон Хрусталев
 * @version 1.0
 */
public class Tail extends StaticEntity {
    /**
     * Конструктор хвоста с координатами
     * @param x
     */
    public Tail(int x) {
        super(new Vector2(x, 0));
    }

    /**
     * Дефолтная позиция
     */
    Tail() {
        super(new Vector2(0, 0));
    }

    /**
     * Переопределяем как того требует интерфейс
     * @param obj
     */
    @Override
    public void addDynamic(Object obj) {
    }

    @Override
    public String toString() {
        return "{Tail: pos=" + getPosition() + "}";
    }
}
