
import com.oracle.jrockit.jfr.Transition;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TuringTest {

    String tape = new String();
    static int head;
    static ArrayList<String>  States = new ArrayList<String>();
    static ArrayList<String> Alphabets = new ArrayList<String>();
    static ArrayList<String> Transitions = new ArrayList<String>();
   static int statesNo ;
   static int alphabetsNo ;
    
    
    
    
    public static void main(String[] args) {
        
//        States.add("qa");
//        States.add("qr");


        alphabetsNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Alphabets: "));
        for(int j = 0 ; j < alphabetsNo ; j++) {
            Alphabets.add(JOptionPane.showInputDialog("Enter Alphabet No." +  j+1 ));
        }

        statesNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of States: "));
        for(int i = 0 ; i < statesNo ; i++){
            States.add(JOptionPane.showInputDialog("Enter State No." + i+1));
        }
        
        int f = 0;
        int c = 1;
        String t;
        while (true){
            t = JOptionPane.showInputDialog(null,"Enter transition"+ c);
            if(t.equals("Done"))
                break;
            Transitions.add(t);
            c++;
        }
        String Tape = JOptionPane.showInputDialog("Enter Tape Contents: ");
        head = Integer.parseInt(JOptionPane.showInputDialog("Head: ")) ;
        String CS = States.get(0) ;
        
        while (!(CS.equals("qa")) &&  !(CS.equals("qr"))){
            boolean b = false;
//            System.out.println(Tape + " " + CS + " " + head);
            for (int i = 0 ; i<Transitions.size() ; i++){
                   String temp = Transitions.get(i);
                   String temp2[] = temp.split(",");
                   if(temp2[0].contains(CS) && temp2[1].contains(""+Tape.charAt(head))){
                       b = true;
                      CS = temp2[2];
                      Tape = Tape.substring(0, head) + temp2[3] + Tape.substring(head+1);
                        if (temp2[4].contains("r")){
                            head ++ ;
                        }
                        else {
                            head -- ;
                        }
                       break;
                   }
                   
            }
            if (!b){
                JOptionPane.showMessageDialog(null,"Transition not Found.");
                break;
            }
            if (head< 0)
                head = 0;
            while (Tape.length() <= head)
                Tape += "-";
        
        }
        
        
        if (CS.equals("qa")){
            JOptionPane.showMessageDialog(null, "Accepted Input");
            JOptionPane.showMessageDialog(null, "The Input " + Tape + ":" + "\n Is Accepted");
        }
        else{
            JOptionPane.showMessageDialog(null, "Rejected Input");
            JOptionPane.showMessageDialog(null, "The Input " + Tape + ":" + "\n Is Rejected");
        }
        
        
        
        
    }
}
