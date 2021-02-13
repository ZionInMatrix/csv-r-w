package inputoutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String CSV_SEPARATOR = ";";
    private static final String fileName = System.getProperty("user.dir") + "/src/Tel.csv";

    /**
     * Snazim Cist lines from CSVFile into List<Employee> employees = new ArrayList<Employee>
     *     ted jenom cte ve spravnem formatu www
     */
    public void readFile() {
        BufferedReader in = null;
        String line = "";
        List<Employee> employees = new ArrayList<>();
        try {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName), "Windows-1250"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                String lines[] = line.split(CSV_SEPARATOR);

                for(Employee employee : employees) {
                    System.out.println(employee);
                }
                if ((line = in.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Udelal jsem metodu, ktera bude nacitat data do CSVFilu
     */

    public void writeToCSV(ArrayList<Employee> employees) {
        try {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "Windows-1250"));
            } catch (UnsupportedEncodingException | FileNotFoundException e) {
                e.printStackTrace();
            }
            for (Employee employee : employees) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(employee.getJmeno());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getFunkce());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getPopisCinnosti());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getCisloDveri());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getTelefon());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getMobil());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getEmail());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getOddeleni());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getZkratkaOdboru());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(employee.getNazevOdboru());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
