public class Calculation {

    public int countDistance(int distance, int speed) {
        //프로그램이 진행되는 동안 남은 거리(m)를 계산해준다
        distance -= speed;
        return distance;
    }

    public float detectSpeed(long milliSecond) {
        //1320m / ms
        long second = milliSecond / 1000;
        float speed = 1320 / (float) second;
        return speed;
    }
}
