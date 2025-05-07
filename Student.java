package program2;

    import java.time.LocalDate;
    import java.time.Period;
    import java.time.format.DateTimeFormatter;
    
    public class Student {
        private String name;
        private LocalDate dob;
    
        public Student(String name, String dobStr) {
            this.name = name;
            this.dob = parseDate(dobStr);
        }
    
        private LocalDate parseDate(String dobStr) {
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                return LocalDate.parse(dobStr, formatter1);
            } catch (Exception e) {
                return LocalDate.parse(dobStr, formatter2);
            }
        }
    
        public void displayInfo() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + calculateAge() + " years");
        }
    
        private int calculateAge() {
            return Period.between(dob, LocalDate.now()).getYears();
        }
    
        public static void main(String[] args) {
            Student student = new Student("Alice", "2002-04-15"); // or "15-04-2002"
            student.displayInfo();
        }
    }
     

