import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class lab0 {
    public static void main(String[] args)
    {
        System.out.println("\nCONVERSOR PARA HTML\nResultado:\n");
        Scanner scanner = new Scanner(System.in);

        FileInputStream file = null;
        
        try
        {
            file = new FileInputStream(new File("entrada.txt"));
        }catch(IOException e)
        {
            System.err.println("\nErro ao abrir o arquivo.");
            scanner.close();
            return;
        }
        
        int ch; 
        boolean underline = false;
        boolean asterisco = false;
        try
        {
            while((ch = file.read()) != -1)
            {
                if((char)ch == '_')
                {
                    if(underline == false)
                    {
                        System.out.print("<i>");
                        underline = true;
                        continue;
                    }
                    if(underline == true)
                    {
                        System.out.print("</i>");
                        underline = false;
                        continue;
                    }
                }

                if((char)ch == '*')
                {
                    if(asterisco == false)
                    {
                        System.out.print("<b>");
                        asterisco = true;
                        continue;
                    }
                    if(asterisco == true)
                    {
                        System.out.print("</b>");
                        asterisco = false;
                        continue;
                    }
                }
                System.out.print((char)ch);
            }
        }catch (IOException e)
        {
            System.err.println("\nErro na leitura do arquivo.");
            scanner.close();
            return;
        }
        System.out.println();
    }
}