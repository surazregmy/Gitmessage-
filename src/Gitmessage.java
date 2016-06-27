import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by suraj on 6/20/2016.
 */
public class Gitmessage {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String commitId;
        System.out.println("Enter the git id --------->");
        commitId = input.nextLine();

        String gitCommands[] = new String[]{"git log --format=%B -n 1 ","git diff-tree --no-commit-id --name-status -r ","git --no-pager log -1 --pretty=format:\"%an <%ae>\" ",
                "git branch --contains ","git show -s --format=%ci"};
       // System.out.println(gitCommands[1]);
       // System.out.println(gitCommands[3]);
        ArrayList<String> result=new ArrayList<>();
        for(String eachgitCommand:gitCommands) {
            try {
                File f = new File("D:\\javaproject\\NFjava\\gitreport");

                Process p = Runtime.getRuntime().exec(eachgitCommand + commitId, null, f);

                BufferedReader stdInput = new BufferedReader(new
                        InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new
                        InputStreamReader(p.getErrorStream()));
                result.add(stdInput.readLine());

            } catch (IOException e) {e.printStackTrace();
            }
        }
        printout_result(result);
    }
    public static void printout_result(ArrayList<String> output) {

        String message = output.get(1);

        System.out.println("Author:" + output.get(2));
        System.out.println("Branch:" + output.get(3));
        System.out.println("Time committed:" + output.get(4));

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("D:\\javaproject\\NFjava\\gitreport\\filename.txt"), "utf-8"));
            writer.write("Author:" + output.get(2));
            writer.write("Author:" + output.get(2));
            writer.write("Author:" + output.get(2));

        } catch (IOException ex) {


        }
    }
}
