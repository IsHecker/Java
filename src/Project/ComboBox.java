package Project;

public class ComboBox extends javax.swing.JComboBox<String>{
    public ComboBox(String[] tableList, int posX, int posY, int width, int height){
        super(tableList);
        setBounds(posX, posY, width, height);
        setFocusable(false);
    }
}
