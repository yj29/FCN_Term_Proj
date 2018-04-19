import java.util.ArrayList;

public class Cuckoo {
    private String fingerPrint;
    private Bucket bucket;

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }
}


class Bucket {
    ArrayList<String> arrayList = new ArrayList<String>();

    public ArrayList<String> getBuckets() {
        return arrayList;
    }

    public void setBuckets(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }
}
