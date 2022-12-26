package Model;

import java.time.LocalDateTime;

public class Yearly implements Repeatability{
    @Override
    public LocalDateTime nextTime(LocalDateTime currentDateTime) {
        return currentDateTime.minusYears(1);
    }



    @Override
    public String toString() {
        return "ежегодная";
    }
}
