package streams;

public class StringBuilder {

    public static void main(String[] args) {

        String s = "cd costs 25$ total";

        String[] t = s.split(" ");

        java.lang.StringBuilder sb = new java.lang.StringBuilder();

        for (String e: t){

            if(e.matches("^\\d+\\$$")){
                Integer i =  Integer.parseInt(e.substring(0,e.length()-1));
                float f = (int) (i - 1*.25);
                System.out.println("matches" + f);
                sb.append(f+"$ ");

            }else {

                sb.append(e + " " );
            }


        }

        System.out.println(sb.toString());

    }

}
