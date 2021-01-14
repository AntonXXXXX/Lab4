package Classes;
import AbstractClasses.Animal;

import java.util.Objects;
/**
 * Класс медведя наследованный от животного
 * @author Антон Хрусталев
 * @version 1.0
 */
public class Bear extends Animal {
    private int taskDuration;
    private int doingTaskTime;
    private Sky parentSky;
    private Tail targetTail;
    private Tree targetTree;
    private String name;

    /**
     * Конструктор медведя
     * @param name
     * @param mainSky
     * @param targetTail
     */
    public Bear(String name, Sky mainSky, Tail targetTail) {
        this.name = name;
        this.taskDuration = -1;
        setMainSky(mainSky);
        setTargetTail(targetTail);
    }

    /**
     * Перегрузка конструтора медведя (но надо задать потом хвост и небо)
     */
    public Bear() {
        isAlive = true;
    }

    /**
     * Сеттер неба
     * @param mainSky
     */
    public void setMainSky(Sky mainSky) {
        parentSky = mainSky;
    }

    /**
     * Сеттер хвоста
     * @param target
     */
    public void setTargetTail(Tail target) {
        targetTail = target;
    }

    /**
     * Задаем дерево, с которым пересекается медведь
     * @param target
     */
    public void setTargetTree(Tree target) {
        targetTree = target;
    }

    /**
     * Попытка найти хвост
     * @return
     */
    public boolean tryFindTail() {
        doTask(-1);
        return isTaskDone();
    }

    /**
     * Выполнение задания (движение с проверкой выполнения условия)
     * @param time
     */
    @Override
    public void doTask(int time) {
        setSpeed(new Vector2(1, 0));
        if (isTaskDone()) {
            taskDuration = time;
            doingTaskTime = 0;
        }
        taskStep();
    }

    /**
     * Флаг состояния выполнения задания
     * @return
     */
    @Override
    public boolean isTaskDone() {
        if (taskDuration == -1) {
            return super.getPosition().x == targetTail.getPosition().x;
        }
        return doingTaskTime >= taskDuration;
    }

    /**
     * Флаг обнаружения дерева
     * @return
     */
    public boolean isTreeFound() {
        return super.getPosition().x == targetTree.getPosition().x;
    }

    /**
     * Перемещаем медведя на следующую итерацию поиска
     */
    @Override
    public void taskStep() {
        if(!isTaskDone()) {
            if(parentSky.sun.isShining()) {
                updatePosition();
            }
        }
    }

    @Override
    public String toString() {
        return "{Bear: name=\"" + name + "\" pos=" + getPosition().toString() + " isAlive=" + isAlive + "}";
    }

    public boolean equals(Bear another) {
        return this.name.equals(another.name) && this.getPosition() == another.getPosition();
    }

    public int hasCode() {
        return Objects.hash(this.getPosition(), this.name);
    }
}