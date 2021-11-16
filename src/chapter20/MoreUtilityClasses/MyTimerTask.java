package chapter20.MoreUtilityClasses;

import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask { //класс задания, которое будет выполняться по расписанию
    @Override
    public void run() {
        System.out.println(new Date());
    }
}
