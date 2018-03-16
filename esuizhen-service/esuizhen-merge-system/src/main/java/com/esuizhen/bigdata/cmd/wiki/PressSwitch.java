package com.esuizhen.bigdata.cmd.wiki;

/* The test class or client */
public class PressSwitch {
    public static void main(String[] args) {
        // Check number of arguments
        if (args.length != 1) {
            System.err.println("Argument \"ON\" or \"OFF\" is required.");
            System.exit(-1);
        }

        Light lamp = new Light();
        Command switchUp = new FlipUpCommand(lamp);
        Command switchDown = new FlipDownCommand(lamp);

        Switch mySwitch = new Switch();

        switch (args[0]) {
            case "ON":
                mySwitch.storeAndExecute(switchUp);
                break;
            case "OFF":
                mySwitch.storeAndExecute(switchDown);
                break;
            default:
                System.err.println("Argument \"ON\" or \"OFF\" is required.");
                System.exit(-1);
        }
    }
}