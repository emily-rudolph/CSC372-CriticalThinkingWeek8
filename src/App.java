import java.io.File;
import java.io.FileWriter;
import java.util.*; 

public class App {
    public static void main(String[] args) throws Exception {

        String name; 
        String address; 
        double GPA; 
        
        LinkedList<Student> Students = new LinkedList<Student>();

        boolean loop = true; 
        while (loop == true) { 
            Scanner in = new Scanner(System.in);
            
            System.out.println("Enter The Students Name: " ); 
            name = in.nextLine(); 

            System.out.println("Enter The Students Address: " ); 
            address = in.nextLine(); 

            System.out.println("Enter The Students GPA " ); 
            String stringGPA = in.nextLine(); 

            try {
                GPA = Double.parseDouble(stringGPA); 
            }
            catch(Exception e) {
                System.out.println("The Number You Entered Is Not A Valid GPA. Student Can Not Be Added As Entered. Enter Another Student? (y/n)");

                String c = in.nextLine().trim().toLowerCase();
                if (c.equals("y")) {
                    continue; 
                } else {
                    System.out.println("Finished Entering Students");
                    loop = false;
                    break;
                }
            }

            if (GPA < 1 || GPA > 4) { 
                System.out.println("The Number You Entered Is Not A Valid GPA. Student Can Not Be Added As Entered. Enter Another Student? (y/n)");

                String c = in.nextLine().trim().toLowerCase();
                if (c.equals("y")) {
                    continue; 
                } else {
                    System.out.println("Finished Entering Students");
                    loop = false;
                    break;
                }
            }
            
            Student s = new Student(name, address, GPA); 
            Students.add(s); 

            System.out.println("Student Entered. Enter Another Student? (y/n)");
            String c = in.nextLine().trim().toLowerCase();
            if (!c.equals("y")) {
                loop = false;
                System.out.println("Finished Entering Students");
                in.close();
            }
        }
        
        Students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        }); 

        FileWriter myWriter = new FileWriter("Students.txt");

        for (Student student : Students) {
            myWriter.append("Name: " + student.getName() + ", Address: " + student.getAddress() + ", GPA: " + student.getGPA() + "\n");
        }

        myWriter.close(); 
    }
}