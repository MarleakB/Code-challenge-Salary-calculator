package employee;

import java.io.*;

public class SalaryCalculator {

    public static void main(String arg[]) {
    String path = "/Users/jaylinjacobs/IdeaProjects/SalaryCalculator/src/employee/salary.txt";
    String line;
    double totalSalary;
    int bonus = 10000;


        try {
            //read file
            BufferedReader br = new BufferedReader(new FileReader(path));

            //loop through csv file
            while((line = br.readLine()) != null){

                //split csv data into values
                String[] values = line.split(",");

                //convert csv data
                Double dblRate = Double.parseDouble(values[1]);
                Double dblHours = Double.parseDouble(values[2]);
                String role = values[3];

                //set conditions for specific roles and print output
                if (role.equals("CONTRACT")){

                    totalSalary =  bonus + (dblHours * dblRate);
                    System.out.println(line);
                    System.out.println("Total salary is: $"+ totalSalary);

                } else if (role.equals("FULL TIME")){

                    totalSalary = dblHours * dblRate;
                    System.out.println(line);
                    System.out.println("Total salary is: $"+ totalSalary);

                } else if(role.equals("PART TIME")){

                    totalSalary = dblHours * dblRate;
                    System.out.println(line);

                    if(totalSalary > 50000){

                        System.out.println("Total salary is capped at $50000");

                    } else {

                        System.out.println("Total salary is: $"+ totalSalary);

                    }

                }
            }

        //if something goes wrong do this
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
