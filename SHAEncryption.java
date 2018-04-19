import java.security.MessageDigest;

public class SHAEncryption {

    public static String getSHA(String input) {
        MessageDigest messageDigest;
        // StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        {
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] hash = messageDigest.digest(input.getBytes());
                s = new String(hash, "UTF-8");
            } catch (Exception e) {
                System.out.println("Error while creating SHA for IP");
                e.printStackTrace();
            }
        }
        return s;
    }
}
