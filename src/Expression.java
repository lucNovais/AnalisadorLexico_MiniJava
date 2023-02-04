import java.sql.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Expression{
    public static void main(String[] args) {
        ArrayList<Pattern> gramaticaMiniJava = new ArrayList<>();

        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> ops = new ArrayList<>();
        ArrayList<String> delims = new ArrayList<>();
        ArrayList<String> decls = new ArrayList<>();
        ArrayList<String> fluxos = new ArrayList<>();
        ArrayList<String> tipos = new ArrayList<>();
        ArrayList<String> comments = new ArrayList<>();

        gramaticaMiniJava.add(Pattern.compile("^class [a-zA-Z][a-zA-Z0-9_]*? \\{$", 1));
        gramaticaMiniJava.add(Pattern.compile("^\s*?public static void main\\(String\\[\\] [a-zA-Z][a-zA-Z0-9_]*?\\) \\{$", 1));
        gramaticaMiniJava.add(Pattern.compile("^\\s*?System.out.println\\(\".*?\"|new [a-zA-Z][a-zA-Z0-9]*?\\(\\).[a-zA-Z][a-zA-Z0-9]*?\\([0-9]*?\\)\\);$", 1));
        gramaticaMiniJava.add(Pattern.compile("^lw \\$[t|s][0-7],[0-9]\\d*\\(\\$[t|s][0-7]\\)",1));
        gramaticaMiniJava.add(Pattern.compile("^sw \\$[t|s][0-7],[0-9]\\d*\\(\\$[t|s][0-7]\\)",1));
        
        try {
            File arq = new File("entrada.txt");
            FileReader reader = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(reader);

            String comando = leitor.readLine();
            String[] comandoSeparado;

            while(comando != null) {
                for(int i = 0; i < gramaticaMiniJava.size(); i++) {
                    Matcher matcher = gramaticaMiniJava.get(i).matcher(comando);
                    boolean matchFound = matcher.find();
                    if(matchFound) {
                        System.out.println("Comando: \n\t'"+ comando + "' valido!\n");

                        if(i == 0) {
                            comandoSeparado = comando.split(" ", 3);
                            decls.add(comandoSeparado[0]);
                            ids.add(comandoSeparado[1]);
                            delims.add(comandoSeparado[2]);
                        }
                        else if(i == 1) {
                            int j = 0;
                            if (comando.charAt(0) == ' ') {
                                while(comando.charAt(j) == ' ') {
                                    j++;
                                }
                            }
                            comandoSeparado = comando.split(" ", j + 5);
                                
                            decls.add(comandoSeparado[j]);
                            decls.add(comandoSeparado[j + 1]);
                            decls.add(comandoSeparado[j + 2]);
                            decls.add(comandoSeparado[j + 3]);
                        }
                        
                        break;
                    } else {
                        if (i == gramaticaMiniJava.size() - 1) {
                            System.out.println("Comando: \n\t'"+ comando + "' invalido!\n");
                        }
                    }
                }
                comando = leitor.readLine();
            }
            leitor.close();
        }
        catch(IOException e) {
            System.out.println("Erro na leitura do arquivo de entrada!");
        }
        
        System.out.println("\nTokens coletados: \n");
        System.out.println("ID: " + ids);
        System.out.println("OP: " + ops);
        System.out.println("DELIM: " + delims);
        System.out.println("DECL: " + decls);
        System.out.println("FLUXO: " + fluxos);
        System.out.println("TIPO: " + tipos);
        System.out.println("COMMENT: " + comments);

    }
}
