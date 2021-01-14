package Classes;
import AbstractClasses.StaticEntity;

import java.util.Objects;
/**
 * Класс неба
 * @author Антон Хрусталев
 * @version 1.0
 */
public class Sky extends StaticEntity {
    public CloudPool cloudPool;
    public Sun sun;

    /**
     * Конструктор класса неба с координатами Vector2
     */
    public Sky() {
        super(new Vector2(0, 100));
    }

    /**
     * Перегрузка конструктора класса небо параметром parentSun
     * @param parentSun
     */
    public Sky(Sun parentSun) {
        super(new Vector2(0, 100));
        sun = parentSun;
        cloudPool = new CloudPool();
    }

    /**
     * Производим перерачет состояния облаков
     */
    public void updateClouds() {
        cloudPool.updateAll();
    }

    /**
     * Создаем новый объект облака
     * @param obj
     */
    @Override
    public void addDynamic(Object obj) {
        cloudPool.addNew(obj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sky)) return false;
        Sky sky = (Sky) o;
        return Objects.equals(cloudPool, sky.cloudPool) &&
                Objects.equals(sun, sky.sun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cloudPool, sun);
    }
}
