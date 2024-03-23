public class Main {
    public static void main(String[] args) {

        //https://stackoverflow.com/questions/2482971/how-to-change-the-color-of-titlebar-in-jframe/70097948#70097948

        /**
        UIDefaults uiDefaults = UIManager.getDefaults();
        uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.gray));
        uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
        JFrame.setDefaultLookAndFeelDecorated(true);
        */
        GameLoop ticGameLoop = new GameLoop();
    }
}