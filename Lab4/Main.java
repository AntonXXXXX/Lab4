//И Винни-Пух отправился на поиски хвоста. Он вышел в путь чудесным весенним утром.
//Маленькие прозрачные облачка весело играли на синем небе.
//Они то набегали на солнышко, словно хотели его закрыть, то поскорее убегали, чтобы дать и другим побаловаться.
//А солнце весело светило, не обращая на них никакого внимания, и сосна,
//которая носила свои иголки круглый год не снимая, казалась старой и потрёпанной рядом с берёзками,
//надевшими новые зелёные кружева. Винни шагал мимо сосен и ёлок, шагал по склонам,
//заросшим можжевельником и репейником, шагал по крутым берегам ручьёв и речек,
//шагал среди груд камней и снова среди зарослей. И вот наконец, усталый и голодный, он вошёл в Дремучий Лес,
//потому что именно там, в Дремучем Лесу, жила Сова. Сова жила в великолепном замке «Каштаны».
//Да, это был не дом, а настоящий замок.

import Classes.*;
import Exception.*;
import java.util.Random;
/**
 * Клас истории
 * @author Антон Хрусталев
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        TimeManager timeManager = new TimeManager(3, 2, 0); //создаем время
        DateManager dateManager = new DateManager(2020, 12); //создаем дату

        Sun mainSun = new Sun(); //создаем солнце
        Sky mainSky = new Sky(mainSun); //создаем небо с привязанным к нему солнцем

        mainSky.addDynamic(new Cloud(mainSky, mainSun)); //добавляем облако на небо
        mainSky.addDynamic(new Cloud(mainSky, mainSun)); //и еще раз

        mainSun.setTimeManager(timeManager); //привязываем изменение времени для солнца
        mainSun.setDateManager(dateManager); //привязываем изменение даты для солнца

        Tail lostTail = new Tail(new Random().nextInt(5)+5); //создаем хвост в рандомном месте

        Bear pooh = new Bear("Pooh", mainSky, lostTail); //создаем медведя и привязываем его к месту и задаче


        Tree PineTree = new Tree("Old PineTree bearing needles");
        Tree Birch = new Tree("Birches filled with green lace ");
        Tree Fir = new Tree("Old");
        PineTree.setTreeType("PineTree");
        Birch.setTreeType("Birch");
        Fir.setTreeType("Fir");

        Tree Juniper = new Tree("on Slope");
        Tree Burdock = new Tree("on Slope");
        Juniper.setTreeType("Juniper");
        Burdock.setTreeType("Burdock");

        boolean RevivalFlag = false;
        while(!pooh.tryFindTail()) //если мишка еще жив и не нашел хвост, то
        {
            /**
             * Проверяем наличие проверяемого исключения
             */
            try {
                if (pooh.isAlive) {
                    timeManager.incrementSecond(60 * 60); //прошел час
                    if (timeManager.second == 0 && timeManager.hour == 0) { //прошел день
                        dateManager.incrementDay();
                        System.out.println("And another day passed away, but " + pooh + " still haven't found the lost tail");
                    }
                    mainSky.updateClouds();

                    /**
                     * Вложенный нестатический класс
                     */
                    class Passer {
                        Passer(Tree tree) {
                            pooh.setTargetTree(tree);
                            if (pooh.isTreeFound()) {
                                System.out.println("Pooh passed by " + tree);
                            }
                        }
                    }

                    Passer pineTree = new Passer(PineTree);
                    Passer birch = new Passer(Birch);
                    Passer fir = new Passer(Fir);
                    Passer burdock = new Passer(Burdock);
                    Passer juniper = new Passer(Juniper);
                    System.out.println("Hmmm... The Sun is " + (mainSun.isCovered ? "covered" : "not covered") + " today");
                    pooh.damage(8);
                } else {
                    throw new DeathException(pooh);
                }
            } catch (DeathException d) { //если словили, то
                System.out.println("We try to revival him...");
                if(RevivalFlag == false) {
                    pooh.heal(15);
                    RevivalFlag = true;
                    System.out.println("And we did!!!");
                }
                else { //если пух уже воскресал, то
                    System.out.println("But he died... I'd like to die, too, but I have to pass the lab...");
                    throw new DeathAgainException(); //запускаем непроверяеое исключение
                }
            }
        }
        /**
         * Анонимный класс дом
         */
        Interfaces.Building house = new Interfaces.Building() {
            @Override
            public void habitability() {
                System.out.println("He came to building. It's not a house. Habitability=Fslse");
            }
        };

        /**
         * Анонимный класс замок
         */
        Interfaces.Building castle = new Interfaces.Building() {
            @Override
            public void habitability() {
                System.out.println("But a castle. Habitability=True");
                System.out.println("Great castle 'Chestnuts'");
            }
        };
        house.habitability();
        castle.habitability();
        Main.tenant();

        System.out.println(pooh + " found it!");
        System.out.println("Yeah! Here is the tail! Look: " + lostTail.toString());
    }

    /**
     * Локальный класс резиденции
     */
    public static void tenant() {
        class Resident {
            private final String animaltype = "Owl";
            Resident() {
                System.out.println(animaltype + " is a resident of this Building");
            }
        }
        Resident resident = new Resident();
    }
}