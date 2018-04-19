public class Main {
    static Cuckoo[] cuckoo = new Cuckoo[5000];

    public static void main(String[] args) {
        CuckooUtil cuckooUtil = new CuckooUtil();

        for (int i = 0; i < cuckoo.length; i++) {
            cuckoo[i] = new Cuckoo();
        }

        String ip = "0000:0000:0000:0001";
        cuckooUtil.addInFilter(ip);
    }
}
