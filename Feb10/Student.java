package Feb10;

public class Student {

    public static class node{
        int roll,age;
        String name,grade;
        node next;

        public node(int roll,int age,String name,String grade){
            this.age=age;
            this.roll=roll;
            this.grade=grade;
            this.name=name;
            this.next=null;
        }
    }
    private node head;
    private node tail;

    public void addFirst(int roll,int age,String name,String grade ){
        node newNode=new node(roll, age, name, grade);
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int roll,int age,String name,String grade ){
        node newNode=new node(roll, age, name, grade);
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void add(int pos,int roll,int age,String name,String grade ){
        node newNode=new node(roll, age, name, grade);
        if(head==null){
            head=tail=newNode;
            return;
        }
        node temp=head;
        int i=0;
        while(temp!=null && i<pos-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public void delete(int roll){
        if(head==null){
            System.out.println("It is already empty.");
        }
        if (head.roll == roll) {
            head = head.next;
            return;
        }
        node temp=head;
        while(temp.next!=null &&temp.next.roll!=roll){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        if (temp.next == null) {
            System.out.println("Student with roll number " + roll + " not found.");
            return;
        }
    }
    public void searchStudent(int rollNo) {
        node temp = head;
        while (temp != null) {
            if (temp.roll == rollNo) {
                System.out.println("Student found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNo + " not found.");
    }
    public void updateGrade(int rollNo, String newGrade) {
        node temp = head;
        while (temp != null) {
            if (temp.roll == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated for student " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNo + " not found.");
    }


    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.roll + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Student s1=new Student();
        s1.addFirst(1,20,"Rajeev","A");
       // s1.addLast(2,10 ,"Sachin","H");
      s1.displayAllStudents();
       // s1.updateGrade(1,"C");
       // s1.displayAllStudents();
        Student s2=new Student();
        s2.addFirst(3,67 ,"Manish" , "j");
        s2.displayAllStudents();
    }
}
