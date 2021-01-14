package Classes;
import Enums.DayPartEnum.DayPart;
import Enums.WeekDayEnum;

import java.util.Objects;
/**
 * Контроллер времени
 * @author Антон Хрусталев
 * @version 1.0
 */
public class TimeManager {
    public int hour;
    public int minute;
    public int second;
    private int rawSeconds;

    /**
     * Создаем время: часы, минуты и секунды
     * @param hour
     * @param minute
     * @param second
     */
    public TimeManager(int hour, int minute, int second) {
        this.hour   = hour;
        this.minute = minute;
        this.second = second;

        this.rawSeconds = 0;
    }

    /**
     * Тихонько передвигаем секундную стрелку
     * @param amount
     */
    public void incrementSecond(int amount) {
        rawSeconds += amount;

        minute = rawSeconds % 60;
        hour   = minute % 60;
        second = rawSeconds % 60;
    }

    /**
     * Вычисляем фазу суток
     * @return
     */
    public DayPart getDayPhase() {
       if(hour >= 6 && hour <= 12) return DayPart.MORNING;
       else if(hour <= 17) return DayPart.AFTERNOON;
       return DayPart.NIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeManager)) return false;
        TimeManager that = (TimeManager) o;
        return hour == that.hour &&
                minute == that.minute &&
                second == that.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }

    @Override
    public String toString() {
        return "{TimeManager: hour=" + hour + " minute=" + minute + " second=" + second + "}";
    }
}