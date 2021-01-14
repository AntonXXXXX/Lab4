package Interfaces;
import Enums.LocationEnum.*;
/**
 * Интерфейс пространства
 * @author Антон Хрусталев
 * @version 1.0
 */
public interface EnvironmentEntity {
    public Location location = Location.SKY;
    public void addDynamic(Object obj);
}
