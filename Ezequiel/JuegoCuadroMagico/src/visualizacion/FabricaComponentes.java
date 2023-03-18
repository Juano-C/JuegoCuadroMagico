package visualizacion;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

public final class FabricaComponentes {
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source background java.awt.Color.LIGHT_GRAY
	 * @wbp.factory.parameter.source comp textField
	 * @wbp.factory.parameter.source comp_1 textField_1
	 * @wbp.factory.parameter.source comp_2 textField_2
	 * @wbp.factory.parameter.source comp_3 textField_3
	 * @wbp.factory.parameter.source comp_4 textField_4
	 * @wbp.factory.parameter.source comp_5 textField_5
	 * @wbp.factory.parameter.source comp_6 textField_6
	 * @wbp.factory.parameter.source comp_7 textField_7
	 * @wbp.factory.parameter.source comp_8 textField_8
	 * @wbp.factory.parameter.source comp_9 textField_9
	 * @wbp.factory.parameter.source comp_10 textField_10
	 * @wbp.factory.parameter.source comp_11 textField_11
	 * @wbp.factory.parameter.source comp_12 textField_12
	 * @wbp.factory.parameter.source comp_13 textField_13
	 * @wbp.factory.parameter.source comp_14 textField_14
	 * @wbp.factory.parameter.source comp_15 textField_15
	 */
	public static JPanel crearGrilla(Color background, Component comp, Component comp_1, Component comp_2, Component comp_3, Component comp_4, Component comp_5, Component comp_6, Component comp_7, Component comp_8, Component comp_9, Component comp_10, Component comp_11, Component comp_12, Component comp_13, Component comp_14, Component comp_15) {
		JPanel panel = new JPanel();
		panel.setBackground(background);
		panel.setLayout(new GridLayout(4, 4, 20, 20));
		panel.add(comp);
		panel.add(comp_1);
		panel.add(comp_2);
		panel.add(comp_3);
		panel.add(comp_4);
		panel.add(comp_5);
		panel.add(comp_6);
		panel.add(comp_7);
		panel.add(comp_8);
		panel.add(comp_9);
		panel.add(comp_10);
		panel.add(comp_11);
		panel.add(comp_12);
		panel.add(comp_13);
		panel.add(comp_14);
		panel.add(comp_15);
		return panel;
	}
	
	public static JPanel crearGrilla_(Color background, int cantidadFilas, int cantidadColumnas, int hgap, int vgap , Component... comp) {
		JPanel grilla = new JPanel();
		grilla.setBackground(background);
		grilla.setLayout(new GridLayout(cantidadFilas, cantidadColumnas, hgap, vgap));
		for(Component componente: comp) {
			grilla.add(componente);
		}
		return grilla;
	}
}