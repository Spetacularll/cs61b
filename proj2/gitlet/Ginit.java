package gitlet;

import java.io.File;

public class Ginit {
    static final File CWD = new File(System.getProperty("user.dir"));
    static File gitlet = Utils.join(CWD,".gitlet");

    static void Init(){
        if(gitlet.exists()){
            System.out.println("A Gitlet version-control system already exists in the current directory.");
            System.exit(0);
        }
        gitlet.mkdir();
    }
}
