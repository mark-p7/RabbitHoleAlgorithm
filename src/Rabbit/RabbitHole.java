package Rabbit;

public class RabbitHole {

    private int iterations = 0;
    Rabbit rabbit;
    boolean caught = false;
    boolean hitUpperBound = false;
    boolean hitLowerBound = false;
    boolean reverseCurrentLocation = false;

    public RabbitHole() {
        rabbit = new Rabbit();
    }

    void upperBoundCheck() {
        if (hitUpperBound) {
            reverseCurrentLocation = true;
            hitUpperBound = false;
        }
    }

    void lowerBoundCheck() {
        if (hitLowerBound) {
            reverseCurrentLocation = false;
            hitLowerBound = false;
        }
    }

    void getRabbit() {

        int currentLocationCheck = 0;

        while (!caught) {

            // If upper-bound is true, switch to reverse and turn upper-bound false
            upperBoundCheck();
            // If lower-bound is true, switch to reverse and turn lower-bound false
            lowerBoundCheck();

            if (currentLocationCheck + 1 > rabbit.getUpperBound() && !reverseCurrentLocation) {
                hitUpperBound = true;
            }
            if (currentLocationCheck - 1 < rabbit.getLowerBound() && reverseCurrentLocation) {
                hitLowerBound = true;
            }

            if (currentLocationCheck == rabbit.getCurrentLocation()) {
                caught = true;
                break;
            } else {
                iterations++;
                System.out.println("Not here: " + currentLocationCheck);
                rabbit.move();
            }

            if (hitUpperBound || hitLowerBound) {
                continue;
            }

            currentLocationCheck = !reverseCurrentLocation ? currentLocationCheck + 1 : currentLocationCheck - 1;
        }
        System.out.println("Caught at: " + currentLocationCheck);
        System.out.println("Iterations: " + iterations);
    }

}

class driver {
    public static void main(String[] args) {

        RabbitHole rabbitHole = new RabbitHole();
        rabbitHole.getRabbit();

    }
}