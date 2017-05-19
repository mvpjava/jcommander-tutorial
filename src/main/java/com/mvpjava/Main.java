package com.mvpjava;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

public class Main {

    final MainCLIParameters mainArgs = new MainCLIParameters();

    public static void main(String[] args) {
        Main demo = new Main();
        demo.handleInputArgs(args);
        demo.run();
    }

    void handleInputArgs(String args[]) {
        JCommander jCommander = new JCommander(mainArgs);
        jCommander.setProgramName("archive");

        try {
            jCommander.parse(args);
        } catch (ParameterException exception) {
            System.out.println(exception.getMessage());
            showUsage(jCommander);
        }

        if (mainArgs.isHelp()) {
            showUsage(jCommander);
        }
    }
    
    void showUsage(JCommander jCommander) {
        jCommander.usage();
        System.exit(0);
    }
    
    void run() {
        System.out.println("Running archive with ...");
        System.out.println(mainArgs);
    }



}
