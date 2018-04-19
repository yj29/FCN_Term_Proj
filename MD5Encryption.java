import java.security.MessageDigest;

public class MD5Encryption {

    public static String getMD5(String input) {
        MessageDigest messageDigest;
        // StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                byte[] hash = messageDigest.digest(input.getBytes());
                s = new String(hash);
            } catch (Exception e) {
                System.out.println("Error while creating MD5 for IP");
                e.printStackTrace();
            }
        }
        return s;
    }
}
