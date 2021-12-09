package Customer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
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
     * @return return false if username exists, return true otherwise.
     * @throws IOException throws exception if error occurs during file reading.
     */

    public static boolean checkUsername(String username) throws IOException {
        path = "users.csv";

        BufferedReader br =new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null){
            String[] data = line.split(",");
            if (Objects.equals(data[0], username)){
                br.close();
                return false;
            }
        }
        br.close();
        return true;
    }


    /**
     * Add a user to file
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

    /**
     * Change the username of a user with Old username
     * @param Old The original username
     * @param New The new username
     * @return return true if the change was successful, false otherwise
     * @throws IOException throws exception if error occurs during file reading.
     */
    public static boolean changeUsername(String Old, String New) throws IOException {
        if(checkUsername(New)){
            path = "users.csv";
            String new_path = "temp.csv";

            File old_file = new File(path);
            File new_file = new File(new_path);

            FileWriter fw = new FileWriter(new_file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br =new BufferedReader(new FileReader(path));
            String line = br.readLine();
            pw.println(line);
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                if (Objects.equals(data[0], Old)){
                    pw.println(New +"," + data[1] + "," + data[2]);
                }else {
                    pw.println(line);
                }
            }

            pw.flush();
            pw.close();
            br.close();

            System.gc();
            old_file.delete();
            File dump = new File(path);
            return new_file.renameTo(dump);

        }return false;
    }

    /**
     * Change the password of a user with Username from old_password to new_password.
     * @param Username the username that corresponds to the old password
     * @param old_password the old password to be changed
     * @param new_password the new password
     * @return return true if successfully changed, false otherwise.
     */
    public static boolean changePassword(String Username, String old_password, String new_password){
        path = "users.csv";
        String new_path = "temp.csv";

        File old_file = new File(path);
        File new_file = new File(new_path);
        try{
            FileWriter fw = new FileWriter(new_file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br =new BufferedReader(new FileReader(path));
            String line = br.readLine();
            pw.println(line);

            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                if (Objects.equals(data[0], Username) && Objects.equals((data[1]), old_password)){
                    pw.println(Username +"," + new_password + "," + data[2]);
                }else {
                    pw.println(line);
                }
            }
            pw.flush();
            pw.close();
            br.close();

            System.gc();
            old_file.delete();
            File dump = new File(path);
            return new_file.renameTo(dump);}
        catch (IOException e){
            System.out.println("error");
        }return false;

    }

    /**
     * Change the name of the user with Username
     * @param Username the username that corresponds to old_name
     * @param old_name the old name to be changed
     * @param new_name the new name
     * @return true if successfully changed, false otherwise
     */
    public static boolean changeName(String Username, String old_name, String new_name){
        path = "users.csv";
        String new_path = "temp.csv";

        File old_file = new File(path);
        File new_file = new File(new_path);
        try{
            FileWriter fw = new FileWriter(new_file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            BufferedReader br =new BufferedReader(new FileReader(path));
            String line = br.readLine();
            pw.println(line);

            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                if (Objects.equals(data[0], Username) && Objects.equals((data[2]), old_name)){
                    pw.println(Username +"," + data[1] + "," + new_name);
                }else {
                    pw.println(line);
                }
            }
            pw.flush();
            pw.close();
            br.close();

            System.gc();
            old_file.delete();
            File dump = new File(path);
            return new_file.renameTo(dump);
        }
        catch (IOException e){
            System.out.println("error");
        }return false;

    }


}
