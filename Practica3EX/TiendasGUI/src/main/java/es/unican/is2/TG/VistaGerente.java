package es.unican.is2.TG;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;

import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JButton;

import es.unican.is2.TC.*;
/**
 * Clase que implementa la vista del funcionario dentro de la capa de
 * presentacion de la aplicacion usando Swing
 */
@SuppressWarnings("serial")
public class VistaGerente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreTienda;
	private JTextField txtTotalSueldos;
	private JTextField txtDireccionTienda;
	private JList<String> listNombreEmpleados;
	private DefaultListModel<String> listModel;
	private JButton btnBuscar;

	private IGestionTiendas tiendas;
	private IGestionEmpleados empleados;
	/**
	 * Create the frame.
	 */
	public VistaGerente(IGestionTiendas tiendas, IGestionEmpleados empleados) {
		this.tiendas = tiendas;
		this.empleados = empleados;
		init();
	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		listModel = new DefaultListModel<String>();
		

		//SUELDOS BOX
		txtTotalSueldos = new JTextField();
		txtTotalSueldos.setBounds(230, 251, 86, 20);
		contentPane.add(txtTotalSueldos);
		txtTotalSueldos.setColumns(10);
		txtTotalSueldos.setName("txtTotalSueldos");

		JLabel lblTotalSueldos = new JLabel("Total sueldos");
		lblTotalSueldos.setBounds(115, 254, 99, 14);
		contentPane.add(lblTotalSueldos);

		//EMPLEADOS BOX
		listNombreEmpleados = new JList<String>();
		listNombreEmpleados.setBounds(230, 98, 121, 116);
		contentPane.add(listNombreEmpleados);
		listNombreEmpleados.setBorder(new LineBorder(new Color(0, 0, 0)));
		listNombreEmpleados.setModel(listModel);

		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setBounds(132, 103, 83, 14);
		contentPane.add(lblEmpleados);


		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(155, 54, 65, 14);
		contentPane.add(lblDireccion);

		//DIRECCION BOX
		txtDireccionTienda = new JTextField();
		txtDireccionTienda.setBounds(230, 51, 185, 20);
		contentPane.add(txtDireccionTienda);
		txtDireccionTienda.setColumns(10);
		txtDireccionTienda.setName("txtDireccionTienda");

		JLabel lblDatosTienda = new JLabel("Datos Tienda");
		lblDatosTienda.setBounds(230, 11, 149, 14);
		contentPane.add(lblDatosTienda);

		//NOMBRE TIENDA BOX
		txtNombreTienda = new JTextField();
		txtNombreTienda.setBounds(10, 51, 113, 20);
		contentPane.add(txtNombreTienda);
		txtNombreTienda.setColumns(10);
		txtNombreTienda.setName("txtNombreTienda");

		JLabel lblNombreTienda = new JLabel("Nombre Tienda");
		lblNombreTienda.setBounds(21, 27, 139, 14);
		contentPane.add(lblNombreTienda);


		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rellenaDatosTienda(txtNombreTienda.getText());
			}
		});
		btnBuscar.setBounds(21, 122, 89, 23);
		contentPane.add(btnBuscar);
		btnBuscar.setName("btnBuscar");
		listNombreEmpleados.setVisible(true);
	}

	private void rellenaDatosTienda(String nombre) {
		Tienda t = tiendas.tienda(nombre);
		if (t != null) {
			txtDireccionTienda.setText(t.getDireccion());
			txtTotalSueldos.setText(Double.toString(t.gastoMensualSueldos()));
			listModel.removeAllElements();
			for (int i = 0; i < t.getEmpleados().size(); i++) {
				Empleado e = t.getEmpleados().get(i);
				listModel.addElement(e.getNombre());
			}
		} else {
			txtDireccionTienda.setText("Tienda no existe");
			txtTotalSueldos.setText("0");
			listModel.removeAllElements();
		}

	}
}