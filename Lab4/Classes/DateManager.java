package Classes;
import Enums.WeekDayEnum.WeekDay;
import Enums.YearSeasonEnum.YearSeason;

import java.util.Objects;
/**
 * Класс контроля дат
 * @author Антон Хрусталев
 * @version 1.0
 */
public class DateManager {
    public int day;
    public int week;
    public int mounth;
    public int year;
    private int weekDay;

    /**
     * Конструктор контроллера времени с заданием месяца и года
     * @param year
     * @param mounth
     */
    public DateManager(int year, int mounth) {
        this.year = year;
        this.mounth = mounth;
        this.day = 12 * (mounth - 1);
        this.weekDay = 1;
        this.week = 1;
    }

    /**
     * Геттер сезона из расчета месяца года
     * @return
     */
    public YearSeason getSeason() {
        if (mounth <= 2 || mounth == 12) return YearSeason.WINTER;
        else if (mounth <= 5) return YearSeason.SPRING;
        else if (mounth <= 8) return YearSeason.SUMMER;
        else if (mounth <= 11) return YearSeason.AUTUMN;

        return YearSeason.AUTUMN; // default
    }

    /**
     * Расчет дня недели
     * @return
     */
    public WeekDay getWeekDay() {
        switch (weekDay) {
            case 1: return WeekDay.SUNDAY;
            case 2: return WeekDay.MONDAY;
            case 3: return WeekDay.TUESDAY;
            case 4: return WeekDay.WEDNESDAY;
            case 5: return WeekDay.THURSDAY;
            case 6: return WeekDay.FRIDAY;
            case 7: return WeekDay.SATURDAY;
        };
        return WeekDay.SUNDAY;
    }

    /**
     * Перелистывание странички календаря
     */
    public void incrementDay() {
        weekDay++;
        weekDay %= 7;
        weekDay++; // to map into [1, 7] range

        day++;
        day %= 365;
        day++; // to map into [1, 365] range

        mounth = day / 31;
        year = (mounth / 12) + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateManager)) return false;
        DateManager that = (DateManager) o;
        return day == that.day &&
                week == that.week &&
                mounth == that.mounth &&
                year == that.year &&
                weekDay == that.weekDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, week, mounth, year, weekDay);
    }

    @Override
    public String toString() {
        return "{DateManager: day=" + day + " week=" + week + " mounth=" + mounth + " year=" + year + " weekDay=" + weekDay + "}";
    }
}