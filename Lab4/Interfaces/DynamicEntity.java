package Interfaces;
import Classes.Vector2;
/**
 * Интерфейс статика
 * @author Антон Хрусталев
 * @version 1.0
 */
public interface DynamicEntity {
    public Vector2 getPosition();
    public Vector2 getSpeed();
    public void updatePosition();
    public void setSpeed(Vector2 speed);
}