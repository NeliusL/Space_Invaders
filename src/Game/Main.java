package Game;

import javax.management.monitor.GaugeMonitorMBean;

public class Main {
    public static void main(String[] args){
        Run();
    }


    public static void Run(){
        new Game();
        Game.Loop();
        Game.Kill();
    }
}


