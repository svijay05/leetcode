import java.text.MessageFormat;

public class Test {

    public static void main(String[] args) {
        String msg = "We failed to get LLDP information from the CPE {1}. Please check LLDP is enabled on this device and reattempt the ZTP launch.";
        print(msg,null, "ce-mtlrnj5701w.cpe.nj.crnrstn.comcast.net");
    }

    static void print(String msg, Object... args){
       String result =  MessageFormat.format(msg, args);
       System.out.println(result);

    }
}
