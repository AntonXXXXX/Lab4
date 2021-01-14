package Classes;
import AbstractClasses.Pool;

import java.util.Objects;
/**
 * Класс поля облаков унаследованный от абстрактного класса всех полей
 * @author Антон Хрусталев
 * @version 1.0
 */
public class CloudPool extends Pool {
    public int lastCloudId;

    /**
     * Конструктор облачного поля
     */
    CloudPool(){
        super();
    }

    /**
     * Метод возврата облака после перехода к следующему облаку
     * @return
     */
    public Cloud getNextCloud() {
        super.getNext();
        lastCloudId = super.curSelected;
        ((Cloud)super.getAt(lastCloudId)).isActive = true;
        ((Cloud)super.getAt(lastCloudId)).doTask(5);
        return (Cloud)super.getAt(lastCloudId);
    }

    /**
     * Добавление облака
     * @param cloud
     */
    public void addCloud(Cloud cloud) {
        cloud.isActive = false;
        super.addNew(cloud);
    }

    /**
     * Обновление позиции при выполнеии условия
     */
    public void updateAll() {
        boolean allInactive = true;
        Cloud c = ((Cloud)super.getAt(lastCloudId));
        if(c.isTaskDone()) {
            c.isActive = false;
            getNextCloud();
        } else {
            ((Cloud)super.getAt(lastCloudId)).taskStep();
        }
    }

    @Override
    public String toString() {
        return "{CloudPool: numObjects=" + numObjects + " curCloudId=" + lastCloudId + "}";
    }

    public boolean equals(CloudPool another) {
        return hashCode() == another.hasCode();
    }

    public int hasCode() {
        return super.hashCode();
    }
}
