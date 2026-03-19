 import java.util.*;
public class codealpha_studentgradetracker {
    public static void main(String[] args) {
     
        Scanner Scan= new Scanner(System.in);
                ArrayList<String> names = new ArrayList<String>();
                ArrayList <Integer>marks = new ArrayList<Integer>();

           System.out.println("Enter no of student: ");
         int n1 = Scan.nextInt();
         Scan.nextLine();
         for(int i=0;i<n1;i++){
            System.out.println("\nstudent" +  (i+1));
            System.out.println("Enter student name: ");
            String name = Scan.nextLine();
            names.add(name);
            System.out.println("Enter mark: ");
            int mark = Scan.nextInt();
            marks.add(mark);
            Scan.nextLine();

         }
         int total =0;
         int highest =marks.get(0);
         int lowest = marks.get(0);
         for(int m :marks){
            total+=m;
if(m>highest){
    highest=m;
}
if(m<lowest){
    lowest=m;
}
         }
           double avg = (double) total/n1; 
           System.out.println("\n----Student summary----");
           for(int i=0;i<n1;i++){
            System.out.println(names.get(i)+" : "+marks.get(i));
           }
            System.out.println("\n Average mark: "+avg);
            System.out.println("Highest mark: "+highest);
            System.out.println("lowset mark: "+lowest);

            Scan.close();
           }
        }

    




