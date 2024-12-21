package data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
 * You are given a list of student information: ID, FirstName, and CGPA. Your task is to rearrange them according to their CGPA in decreasing order. 
 * If two student have the same CGPA, then arrange them according to their first name in alphabetical order. 
 * If those two students also have the same first name, then order them according to their ID. No two students have the same ID.
*/
class Student implements Comparable<Student> {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student o) {
        // Comparação do CGPA, colocando os maiores CGPAs primeiro (ordem decrescente)
        if (Double.compare(this.cgpa, o.cgpa) != 0) {
            return Double.compare(o.cgpa, this.cgpa); // Se CGPAs forem diferentes, retorna a comparação
        }

        // Se os CGPAs forem iguais, compara os nomes em ordem alfabética (ordem
        // crescente)
        if (this.fname.compareTo(o.getFname()) != 0) {
            return this.fname.compareTo(o.getFname()); // Retorna a comparação lexicográfica do nome
        }

        // Se tanto o CGPA quanto o nome forem iguais, compara os IDs em ordem crescente
        return Integer.compare(this.id, o.getId()); // Retorna a comparação do ID
    }
}

public class Sort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        // Ordena a lista de estudantes usando o compareTo definido na classe Student
        Collections.sort(studentList);

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
