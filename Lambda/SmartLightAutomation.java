import java.util.function.Consumer;

public class SmartLightAutomation {
    public static void main(String[] args) {
        Consumer<String> motionTrigger = t -> System.out.println("Lights on due to motion at " + t);
        Consumer<String> timeTrigger = t -> System.out.println("Lights dimming for evening at " + t);
        Consumer<String> voiceTrigger = t -> System.out.println("Voice command received: " + t);

        motionTrigger.accept("Hallway");
        timeTrigger.accept("6:30 PM");
        voiceTrigger.accept("Turn on bedroom lights");
    }
}
