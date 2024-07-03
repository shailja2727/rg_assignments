import java.util.ArrayList;
import java.util.Scanner;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


class Employee
{
    private int id;
    private String name;
    private String department;

    Employee(int id, String name, String department)
    {
        this.id=id;
        this.name=name;
        this.department=department;
    }

    public int getEmpId()
    {
        return id;
    }

    public String getEmpNameString()
    {
        return name;
    }

    public String getEmpDept()
    {
        return department;
    }

    public String toString()
    {
        return id+" "+name+" "+department;
    }
}

class CrudArrayList
{

    public static void main(String[] args)
    {
        List<Employee> c= new ArrayList<Employee>();
        Scanner s=new Scanner(System.in);
        Scanner s1=new Scanner(System.in);
        int ch;
        do
        {
            System.out.println("1.Insert");
            System.out.println("2.Display");
            System.out.println("3.Search");
            System.out.println("4.Delete");
            System.out.println("5.Update");
            System.out.println("Enter your choice: ");
            ch=s.nextInt();


            switch(ch)
            {
                case 1:
                    System.out.println("Enter employee id");
                    int eid = s.nextInt();
                    System.out.println("Enter employee name");
                    String ename = s1.nextLine();
                    System.out.println("Enter employee department");
                    String edep = s1.nextLine();
                    c.add(new Employee(eid, ename, edep));
                    break;

                case 2:
                    //System.out.println(c);

                    Iterator<Employee> i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        System.out.println(e);
                    }

                    break;

                case 3:
                    boolean found= false;
                    System.out.println("Enter the Employee Id: ");
                    int emid=s.nextInt();

                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if(e.getEmpId() == emid)
                        {
                            System.out.println(e);
                            found=true;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Record not found ");
                    }
                    break;

                case 4:
                    found= false;
                    System.out.println("Enter the Employee Id that you want to delete: ");
                    emid=s.nextInt();

                    i = c.iterator();
                    while (i.hasNext()) {
                        Employee e = i.next();
                        if(e.getEmpId() == emid)
                        {
                            i.remove();
                            found=true;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Record not found ");
                    }
                    else
                        System.out.println("Record deleted successfully");
                    break;

                case 5:
                    found= false;
                    System.out.println("Enter the Employee Id that you want to update: ");
                    emid=s.nextInt();

                    ListIterator<Employee>li = c.listIterator();

                    while (li.hasNext()) {
                        Employee e = li.next();
                        if(e.getEmpId() == emid)
                        {
                            System.out.println("Enter new Name: ");
                            ename = s1.nextLine();

                            System.out.println("Enter new Department: ");
                            edep = s1.nextLine();

                            li.set(new Employee(emid, ename, edep));
                            found=true;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Record not found ");
                    }
                    else
                        System.out.println("Record updated successfully");
                    break;

            }
        }while(ch!=0);
    }
}


