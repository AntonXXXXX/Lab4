package Classes;
import java.util.Objects;
import AbstractClasses.TaskedEntity;
import static java.lang.Math.abs;
/**
 * Класс облаков наследованный от сущьности с заданием
 * @author Антон Хрусталев
 * @version 1.0
 */
public class Cloud extends TaskedEntity {
    public float opacity;
    public boolean isActive;

    private Sky parentSky;
    private Sun parentSun;
    private int taskDuration;
    private int doingTaskTime;

    /**
     * Конструктор облака
     * @param parentSky
     * @param parentSun
     */
    public Cloud(Sky parentSky, Sun parentSun) {
        setParentSky(parentSky);
        setParentSun(parentSun);
    }

    /**
     * Задаем то небо, на котором находится облако
     * @param sky
     */
    public void setParentSky(Sky sky) {
        parentSky = sky;
    }

    /**
     * Задаем то солнце, с которым взаимодействует облако
     * @param sun
     */
    public void setParentSun(Sun sun) {
        parentSun = sun;
    }

    /**
     * Выполняем задание, предназначенное для облака
     * @param time
     */
    @Override
    public void doTask(int time) {
        if (!isActive) return;
        if (isTaskDone()) {
            taskDuration = time;
            doingTaskTime = 0;
            setSpeed(new Vector2(1, 0));
        }
        taskStep();
    }

    /**
     * Проверяем выполненность задания
     * @return
     */
    @Override
    public boolean isTaskDone() {
        return doingTaskTime >= taskDuration;
    }

    /**
     * Выполнение задания (изменение позиции на небе и сравнение положения относительно солнца)
     */
    @Override
    public void taskStep() {
        if (!isTaskDone()) {
            updatePosition();
            if (getPosition().x == 10 || getPosition().x == 0) {
                Vector2 speed = getSpeed();
                setSpeed(new Vector2(-speed.x, speed.y));
                updatePosition();
            }
            if (abs(getPosition().x - parentSun.getPosition().x) <= 2) {
                parentSun.cover();
            } else {
                parentSun.uncover();
            }
            doingTaskTime++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cloud)) return false;
        Cloud cloud = (Cloud) o;
        return Float.compare(cloud.opacity, opacity) == 0 &&
                getPosition() == cloud.getPosition() &&
                taskDuration == cloud.taskDuration &&
                doingTaskTime == cloud.doingTaskTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(opacity, parentSky, parentSun, getPosition(), taskDuration, doingTaskTime);
    }

    @Override
    public String toString() {
        return "{Cloud: active=" + isActive + "}";
    }
}
