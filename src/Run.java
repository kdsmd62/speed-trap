import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Run {
    Scanner scanner = new Scanner(System.in);
    Timer timer = new Timer();
    Car car = new Car(1320, 22);        //1320
    Calculation calculation = new Calculation();
    Accelerator accelerator = new Accelerator();
    Brake brake = new Brake();

    public long running(){
        //시작 타임스탬프
        long start = System.currentTimeMillis();
        //과속단속 구간 진입
        System.out.println("과속 단속 구간에 진입합니다. (현재속도 : 1.32km/m  제한속도 : 1.20km/m)");
        //1초마다 남은 거리와 속도 계산
        timer.schedule(printDistance, 0, 1000);
        //변속장치 조작
        while(true) {
            //사용자 입력
            System.out.println("(1)_엑셀  (2)_브레이크");
            String userInput = scanner.nextLine();
            //탈출조건
            if(car.getDistance() <= 0) {
                break;
            }
            //입력에 따른 메서드 호출
            if(userInput.equals("1")) {
                car.setspeed(accelerator.accelation(car.getspeed()));
                System.out.printf("남은거리 : %d(m),  속력 : %.2f(km/m)\n", car.getDistance(),  (float) car.getspeed() * 60 / 1000);
            } else if (userInput.equals("2")) {
                car.setspeed(brake.brake(car.getspeed()));
                System.out.printf("남은거리 : %d(m),  속력 : %.2f(km/m)\n", car.getDistance(),  (float) car.getspeed() * 60 / 1000);
            }
        }
        long end = printDistance.scheduledExecutionTime();
        System.out.printf("과속 단속 구간 종료     (소요시간 : 약 %.2f 초)\n",(float) (end - start) / 1000);
        return end - start;
    }

    TimerTask printDistance = new TimerTask() {
        @Override
        public void run() {
            //countDistance() 메서드를 호출하고, 남은 거리와 속도를 출력한다
            if(car.getDistance() <= 0) timer.cancel();
            car.setDistance(calculation.countDistance(car.getDistance(), car.getspeed()));
            //float speed = (float) car.getspeed() * 60 / 1000;
            //System.out.println(car.getDistance());
            //System.out.println("speed = "+ speed + "km/m");
        }
    };
}
