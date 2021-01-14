package AbstractClasses;
import Classes.Vector2;
import Interfaces.DynamicEntity;
/**
 * Родительский класс динамических сущностей
 * @author Антон Хрусталев
 * @version 1.0
 */
public abstract class TaskedEntity implements DynamicEntity {
    private Vector2 position;
    private Vector2 speed;

    public abstract void doTask(int time);
    public abstract boolean isTaskDone();
    public abstract void taskStep();

    /**
     * Конструктор этой сущьности
     */
    public TaskedEntity() {
        position = new Vector2(0, 0);
        speed    = new Vector2(0, 0);
    }

    /**
     * Геттер позиции
     * @return
     */
    @Override
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Геттер скорости
     * @return
     */
    @Override
    public Vector2 getSpeed() {
        return speed;
    }

    /**
     * Метод обновдения позиции (исходя из скорости)
     */
    @Override
    public void updatePosition() {
        this.position.add(this.speed);
    }

    /**
     * Сеттер скорости
     * @param newSpeed
     */
    @Override
    public void setSpeed(Vector2 newSpeed) {
        speed = newSpeed;
    }
}
