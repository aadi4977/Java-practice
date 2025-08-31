
import java.util.Arrays;
public class OTPgenerator {
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000; // Generates 100000-999999
    }

    public static boolean checkUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false; // duplicate found
                }
            }
        }
        return true; // all unique
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        System.out.println("Generated OTPs: " + Arrays.toString(otpArray));

        boolean unique = checkUnique(otpArray);
        if (unique) {
            System.out.println("All 10 OTPs are unique ✅");
        } else {
            System.out.println("There are duplicate OTPs ❌");
        }
    }
}
