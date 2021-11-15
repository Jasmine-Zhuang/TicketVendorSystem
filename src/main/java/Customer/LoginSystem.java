package Customer;

import java.io.*;
import java.util.Objects;

public class LoginSystem implements Serializable{
    static String path;
    /**
     *Check if the username matches the password in users.csv.
     * @param username the username to be checked.
     * @param password the password to be checked
     * @return return true it username matches the password, return false otherwise.
     * @throws IOException throws exception if error occurs during file reading.
     */
    public static boolean checkUser(String username, String password) throws IOException {
        path = "users.csv";

        BufferedReader br =new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] data = line.split(",");
            if (Objects.equals(data[0], username)){
                if (Objects.equals(data[1], password)){
                return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the username exist in users.csv.
     * @param username the username to be checked.
     * @return return false username exist, return true otherwise.
     * @throws IOException throws exception if error occurs during file reading.
     */

    public static boolean checkUsername(String username) throws IOException {
        path = "users.csv";

        BufferedReader br =new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] data = line.split(",");
            if (Objects.equals(data[0], username)){
                return false;
            }
        }
        return true;
    }


    /**
     *
     * @param username New username
     * @param password Password that matches the new username
     * @param fullName fullName of this user with username
     * @param file  data file that stores all users.
     */
    public static void addUser(String username, String password, String fullName, String file){
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(username + "," + password + "," + fullName);
            pw.flush();
            pw.close();
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void changeUsername(String Old, String New){
//        path = "users.csv";
//        String new_path = "temp.csv";
//
//        File old_file = new File(path);
//        File new_file = new File(new_path);
//        try{
//        FileWriter fw = new FileWriter(new_file, true);
//        BufferedWriter bw = new BufferedWriter(fw);
//        PrintWriter pw = new PrintWriter(bw);
//
//        BufferedReader br =new BufferedReader(new FileReader(path));
//        String line = br.readLine();
//        pw.println(line);
//
//        while ((line = br.readLine()) != null){
//            String[] data = line.split(",");
//            if (Objects.equals(data[0], Old)){
//                pw.println(New +"," + data[1] + "," + data[2]);
//            }else {
//                pw.println(line);
//            }
//        }
//        pw.flush();
//        pw.close();
//        old_file.delete();
//        File dump = new File(path);
//        new_file.renameTo(dump);}
//        catch (IOException e){
//            System.out.println("error");
//        }
//
//    }
//
//    public static void changePassword(String Username, String old_password, String new_password){
//        path = "users.csv";
//        String new_path = "temp.csv";
//
//        File old_file = new File(path);
//        File new_file = new File(new_path);
//        try{
//            FileWriter fw = new FileWriter(new_file, true);
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//
//            BufferedReader br =new BufferedReader(new FileReader(path));
//            String line = br.readLine();
//            pw.println(line);
//
//            while ((line = br.readLine()) != null){
//                String[] data = line.split(",");
//                if (Objects.equals(data[0], Username) && Objects.equals((data[1]), old_password)){
//                    pw.println(Username +"," + new_password + "," + data[2]);
//                }else {
//                    pw.println(line);
//                }
//            }
//            pw.flush();
//            pw.close();
//            old_file.delete();
//            File dump = new File(path);
//            new_file.renameTo(dump);}
//        catch (IOException e){
//            System.out.println("error");
//        }

    }

//    public static void main(String[] args) {
//            changeUsername("Ryan", "RARA");
//            changePassword("Olivia", "paswd", "pswd");
//    }

//    public static void changePassword(String username, String password){
//
//    }
//}
