import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Stopwatch {
    AtomicInteger hours = new AtomicInteger(0);
    AtomicInteger minutes = new AtomicInteger(0);
    AtomicInteger seconds = new AtomicInteger(0);

    public void increment()
    {
        if (seconds.incrementAndGet() >= 60) {
            int valM = minutes.incrementAndGet();
            seconds.set(0);
            if (valM >= 60) {
                hours.incrementAndGet();
                minutes.set(0);
            }
         }
    }
    public String showTime(){
       return String.format("%02d:%02d:%02d", hours.intValue(), minutes.intValue(), seconds.intValue());
    }
}
