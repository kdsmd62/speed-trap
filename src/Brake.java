/*
 * 자동차의 멈춤장치를 구현
 * Brake 메서드 호출시 자동차의 초당 거리를 000 만큼 낮춘다
 */
public class Brake {
    public int brake(int speed) {
        speed -= 10;
        return speed;
    }
}
