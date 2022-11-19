/*
 * 자동차의 가속장치를 구현
 * Accelerator 메서드 호출시 자동차의 초당 거리를 10m 만큼 높인다
 */
public class Accelerator {
    public int accelation(int speed) {
        speed += 10;
        return speed;
    }
}
