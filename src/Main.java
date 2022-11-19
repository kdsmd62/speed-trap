public class Main {

    public static void main(String[] args) {

        Run run = new Run();
        Calculation calculation = new Calculation();

        float avgSpeed = calculation.detectSpeed(run.running()) * 60 / 1000;

        System.out.println();
        System.out.println("=".repeat(60));
        if(avgSpeed > 1.2) System.out.printf("평균속도 : %.2f(km/m)로 과속입니다.\n", avgSpeed);
        else System.out.printf("평균속도 : %.2f(km/m)로 과속이 아닙니다.\n", avgSpeed);
        System.out.println("=".repeat(60));

    }
}