package AbstractClasses;
import Classes.Vector2;
import Interfaces.EnvironmentEntity;
/**
 * Родительский класс статических сущностей
 * @author Антон Хрусталев
 * @version 1.0
 */
public abstract class StaticEntity implements EnvironmentEntity {
    private Vector2 position;

    /**
     * Геттер позиции
     * @return
     */
    public Vector2 getPosition() {
        return this.position;
    }

    /**
     * Конструктор этой сущности с позицией
     * @param position
     */
    public StaticEntity(Vector2 position) {
        this.position = position;
    }
}
