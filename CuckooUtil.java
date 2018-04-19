import java.util.ArrayList;

public class CuckooUtil {

    public void addInFilter(String IP) {
        String SHACode = SHAEncryption.getSHA(IP);
        String MD5Code = MD5Encryption.getMD5(IP);
        String fingerprint = getFingerPrint(SHACode);
        int hash1 = getHash(MD5Code);
        int hash2 = computeHash2(hash1, fingerprint);
        insertInCuckoo(fingerprint, hash1, hash2);
    }

    private void insertInCuckoo(String fingerprint, int hash1, int hash2) {
        Cuckoo place1 = Main.cuckoo[hash1];
        Cuckoo place2 = Main.cuckoo[hash2];
        boolean isPresent = findInCuckoo(fingerprint, place1) || findInCuckoo(fingerprint, place2);
        if (isPresent) {
            //already present in the system so return
            return;
        } else {
            if (place1.getBucket().getBuckets().size() == 2 && place2.getBucket().getBuckets().size() == 2) {
                //collision handling
                int index = (int) ((Math.random()) % 2);
                if (index == 0) {
                    //replace hash1
                } else if (index == 1) {
                    //replace hash2
                }

            } else {
                if (place1.getBucket().getBuckets().size() < 2) {
                    place1.getBucket().getBuckets().add(fingerprint);
                } else if (place2.getBucket().getBuckets().size() < 2) {
                    place2.getBucket().getBuckets().add(fingerprint);
                }
            }
        }
    }

    private boolean findInCuckoo(String fingerprint, Cuckoo place1) {
        ArrayList<String> buckets = place1.getBucket().getBuckets();
        if (buckets == null || buckets.size() == 0) {
            return false;
        }
        for (String string : buckets) {
            if (string.equals(fingerprint)) {
                return true;
            }
        }
        return false;
    }

    private int computeHash2(int hash1, String fingerPrint) {
        int temp1 = 0;
        for (int i = 0; i < fingerPrint.length(); i++) {
            temp1 += (int) fingerPrint.charAt(i);
        }
        int temp = hash1 ^ temp1;
        return getHash(String.valueOf(temp));
    }

    private int getHash(String code) {
        int out = 0;
        for (int i = 0; i < code.length(); i++) {
            out += (int) code.charAt(i);
        }
        return out % (Main.cuckoo.length);
    }

    private String getFingerPrint(String shaCode) {
        StringBuilder builder = new StringBuilder();
        builder.append(shaCode.charAt(0));
        builder.append(shaCode.charAt(1));
        return builder.toString();
    }
}

