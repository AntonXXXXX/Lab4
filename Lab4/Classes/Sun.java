package Classes;
import AbstractClasses.StaticEntity;
import Enums.DayPartEnum;
/**
 * Класс солнца наследованный от Статической сущности
 * @author Антон Хрусталев
 * @version 1.0
 */
public class Sun extends StaticEntity {
    public boolean isCovered;
    private float brightness;
    private TimeManager timeManager;
    private DateManager dateManager;

    /**
     * Консструктор солнца с сразу заданной позицией
     * @param position
     */
    public Sun(Vector2 position) {
        super(position);
    }

    /**
     * Перегрузка конструктора с дефолтной позицией
     */
    public Sun() {
        super(new Vector2(-1, 100));
    }

    /**
     * Активируем тайммнеджер
     * @param tm
     */
    public void setTimeManager(TimeManager tm) {
        timeManager = tm;
    }

    /**
     * Активируем дэйтмэнеджер
     * @param dm
     */
    public void setDateManager(DateManager dm) {
        dateManager = dm;
    }

    /**
     * Установка флага перекрытости солнца
     */
    public void cover() {
        isCovered = true;
    }

    /**
     * Снятие флага открытости солнца
     */
    public void uncover() {
        isCovered = false;
    }

    /**
     * Ограничение светимости солнца ночью
     * @return
     */
    public boolean isShining() {
        DayPartEnum.DayPart dayPart = timeManager.getDayPhase();
        return dayPart != DayPartEnum.DayPart.NIGHT && dayPart != DayPartEnum.DayPart.EVENING;
    }

    /**
     * Геттер яркости солнца
     * @return
     */
    public float getBrightness() {
        return brightness;
    }

    /**
     * Почемы бы и нет
     * @return
     */
    public String toString() {
        return "";
    }

    /**
     * Добавляем динамические объекты
     * @param obj
     */
    @Override
    public void addDynamic(Object obj) {
    }
}

