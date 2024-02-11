public class Student {
    
    private String name; 
    private String address; 
    private double GPA; 

    public Student(String name, String address, double GPA) { 
        this.name = name; 
        this.address = address; 
        this.GPA = GPA; 
    }

    public String getName(){ 
        return this.name; 
    }

    public String getAddress(){ 
        return this.address; 
    }

    public double getGPA(){ 
        return this.GPA; 
    }

    public void setName(String n){ 
        this.name = n; 
    }

    public void setAddress(String a){ 
        this.address = a; 
    }

    public void setGPA(double gpa){ 
        this.GPA = gpa; 
    }
}

