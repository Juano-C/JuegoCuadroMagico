package frontend;
import javax.swing.JPanel;
import java.awt.Component;

public final class Ejemplo {
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source comp iconoXcerrar
	 * @wbp.factory.parameter.source comp_1 felicidades
	 * @wbp.factory.parameter.source comp_2 suRecord
	 * @wbp.factory.parameter.source comp_3 nombre
	 * @wbp.factory.parameter.source comp_4 botonSubida
	 * @wbp.factory.parameter.source comp_5 botonIrIinicio
	 * @wbp.factory.parameter.source comp_6 record
	 */
	public static JPanel createJPanel(Component comp, Component comp_1, Component comp_2, Component comp_3, Component comp_4, Component comp_5, Component comp_6) {
		JPanel panel = new JPanel();
		panel.add(comp);
		panel.add(comp_1);
		panel.add(comp_2);
		panel.add(comp_3);
		panel.add(comp_4);
		panel.add(comp_5);
		panel.add(comp_6);
		return panel;
	}
}