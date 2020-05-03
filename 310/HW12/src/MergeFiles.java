
import java.io.*;
import java.util.*;


public class MergeFiles {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<File> files = new ArrayList<>();
        File merged = new File("");
        try {
            File fileNames  = new File("fileNames.txt");
            Scanner s = new Scanner(fileNames);
            int c = 0;
            while (s.hasNext()) {
                String next = s.next();
                if (c==0){
                    merged = new File(next);
                    c++;
                } else {
                    File file = new File(next);
                    files.add(file); 
                    c++;
                }
            }        
            System.out.println(files);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        mergeFiles(files, merged);
        
        
    }
    
    public static void mergeFiles(ArrayList<File> files, File merged) {
        FileWriter fw = null;
        BufferedWriter bout = null;
        
        try {
            fw = new FileWriter(merged, true);
            bout = new BufferedWriter(fw);
            
        } catch (IOException ex) {
        
        }
        
        for (int i = 0; i < files.size(); i++) {
            File f = files.get(i);
            System.out.println("merging: " + f.toString());
            FileInputStream fileInput = null;
            try {
                fileInput = new FileInputStream(f);
                BufferedReader bin = new BufferedReader(new InputStreamReader(fileInput));
                String a;
                int aInt;
                Integer last = null;
                while ((a=bin.readLine()) != null) {
                    if (bin.readLine() != null) {
                        aInt = Integer.parseInt(bin.readLine());
                        if (last == null) {
                            last = aInt;
                            bout.write(a);
                            bout.newLine();
                        } else {
                            if (last > aInt) {
                                deleteLast(merged);
                                bout.write(a);
                                bout.newLine();
                                bout.write(last);
                                bout.newLine();
                            }
                        }
                    }
                    
                    //aInt = Integer.parseInt(bin.readLine());
                }
                bin.close();
            } catch (IOException ex) {
                
            }
        }
        try {
            bout.close();
        } catch (IOException ex) {
            
        }
    }
    
    public static void deleteLast(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            s.nextLine();
            if (!s.hasNextLine()) {
                try{
                    FileWriter writer = new FileWriter(file.toString());
                    BufferedWriter bwriter = new BufferedWriter(writer);
                    bwriter.write("");
                    bwriter.close();
                }catch (IOException ex){
                }
            }
        }
    }
}
