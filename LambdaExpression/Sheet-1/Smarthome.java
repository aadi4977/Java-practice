@FunctionalInterface
interface LightAction {
    void execute();
}

public class SmartHome {
    public static void main(String[] args) {

        // Motion detected behavior
        LightAction motionTrigger = () -> 
            System.out.println("Motion detected! Turning ON the lights.");

        // Time-based evening mode
        LightAction eveningTrigger = () -> 
            System.out.println("Evening mode activated! Dimming the lights.");

        // Voice command behavior
        LightAction voiceCommand = () -> 
            System.out.println("Voice command: Turning OFF all lights.");

        // Execute the behaviors
        motionTrigger.execute();
        eveningTrigger.execute();
        voiceCommand.execute();
    }
}

    

