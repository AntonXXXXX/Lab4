package AbstractClasses;
import java.util.ArrayList;
import java.util.Random;
/**
 * Родительский класс всех классов полей
 * @author Антон Хрусталев
 * @version 1.0
 */
public abstract class Pool {
    public int curSelected;
    public int numObjects;
    private int objectsLimit;
    private ArrayList<Object> objects;

    /**
     * Конструктор поля с лимитом объектов
     * @param limit
     */
    public Pool(int limit) {
        setLimit(limit);
    }

    /**
     * Перегрузка конструктора поля с уже заданным лимитом
     */
    public Pool() {
        objects = new ArrayList<Object>();
        objectsLimit = 100;
    }

    /**
     * Возврат обьекта с индексом
     * @param i
     * @return
     */
    public Object getAt(int i) {
        return objects.get(i);
    }

    /**
     * Переход к следующему объекту
     * @return
     */
    public Object getNext() {
        if (objects.size() == 0) return null;
        numObjects = objects.size() - 1;
        curSelected = new Random().nextInt(numObjects);
        return objects.get(curSelected);
    }

    /**
     * Добавление нового объекта
     * @param object
     */
    public void  addNew(Object object) {
        if (objects.size() >= objectsLimit) return;

        objects.add(object);
        numObjects = objects.size();
    }

    /**
     * Сеттер лимита количества объектов
     * @param limit
     */
    public void setLimit(int limit) {
        this.objectsLimit = limit;
    }

    public int hasCode() {
        return objects.hashCode();
    }
}