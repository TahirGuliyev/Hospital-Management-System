package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import Model.Clinic;
import Model.HeadDoctor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Point;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import Util.*;
import javax.swing.JComboBox;

public class HeadDoctorGUI extends JFrame {

	Clinic clinic = new Clinic();

	static HeadDoctor headDoctor = new HeadDoctor();

	private JPanel wPane;
	private JTable tableDoctors;
	private DefaultTableModel doctorModel = null;
	private Object[] doctorData = null;
	private JTable tableClinics;
	private DefaultTableModel clinicModel = null;
	private Object[] clinicData = null;
	private JPopupMenu clinicMenu;
	private JTable tableWorker;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeadDoctorGUI frame = new HeadDoctorGUI(headDoctor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HeadDoctorGUI(HeadDoctor headDoctor) throws SQLException {
		// Doctor Model
		doctorModel = new DefaultTableModel();
		Object[] colDoctorName = new Object[4];
		colDoctorName[0] = "ID";
		colDoctorName[1] = "Ad Soyad";
		colDoctorName[2] = "F??N Kod";
		colDoctorName[3] = "??ifr??";
		setTitle("X??st??xana ??dar??etm?? Sistemi");
		doctorModel.setColumnIdentifiers(colDoctorName);
		doctorData = new Object[4];
		for (int i = 0; i < headDoctor.getDoctorList().size(); i++) {
			doctorData[0] = headDoctor.getDoctorList().get(i).getId();
			doctorData[1] = headDoctor.getDoctorList().get(i).getName();
			doctorData[2] = headDoctor.getDoctorList().get(i).getFinKod();
			doctorData[3] = headDoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
		// Clinic Model
		clinicModel = new DefaultTableModel();
		Object[] colClinicName = new Object[2];
		colClinicName[0] = "ID";
		colClinicName[1] = "Kliniki ????b??";
		clinicModel.setColumnIdentifiers(colClinicName);
		clinicData = new Object[2];
		for (int i = 0; i < clinic.getClinicList().size(); i++) {
			clinicData[0] = clinic.getClinicList().get(i).getId();
			clinicData[1] = clinic.getClinicList().get(i).getName();
			clinicModel.addRow(clinicData);
		}

		// Worker Model
		DefaultTableModel workerModel = new DefaultTableModel();
		Object[] colWorker = new Object[2];
		colWorker[0] = "ID";
		colWorker[1] = "Ad Soyad";
		workerModel.setColumnIdentifiers(colWorker);
		Object[] workerData = new Object[2];
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		wPane = new JPanel();
		wPane.setBackground(new Color(224, 255, 255));
		wPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(wPane);
		wPane.setLayout(null);

		JLabel lblWelcomeDoctor = new JLabel("Xo?? g??lmisiniz, h??rm??tli " + headDoctor.getName());
		lblWelcomeDoctor.setBounds(22, 16, 490, 39);
		lblWelcomeDoctor.setFont(new Font("Tahoma", Font.BOLD, 14));
		wPane.add(lblWelcomeDoctor);

		JButton btnDoctorExit = new JButton("\u00C7IXI\u015E");
		btnDoctorExit.setBounds(578, 21, 88, 29);
		btnDoctorExit.setForeground(new Color(255, 255, 255));
		btnDoctorExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDoctorExit.setBackground(new Color(220, 20, 60));
		wPane.add(btnDoctorExit);

		JTabbedPane wTabPane = new JTabbedPane(JTabbedPane.TOP);
		wTabPane.setBackground(new Color(224, 255, 255));
		wTabPane.setBounds(10, 97, 661, 399);
		wPane.add(wTabPane);

		JPanel wDoctorManage = new JPanel();
		wDoctorManage.setBackground(new Color(224, 255, 255));
		wTabPane.addTab("H??kiml??r", null, wDoctorManage, null);
		wDoctorManage.setLayout(null);

		JLabel lblDoctorManageName = new JLabel("Ad Soyad");
		lblDoctorManageName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoctorManageName.setBounds(455, 23, 106, 23);
		wDoctorManage.add(lblDoctorManageName);

		JTextArea txtDoctorManageName = new JTextArea();
		txtDoctorManageName.setBounds(455, 48, 175, 23);
		wDoctorManage.add(txtDoctorManageName);

		JTextArea txtDoctorManageFinKod = new JTextArea();
		txtDoctorManageFinKod.setBounds(455, 107, 175, 23);
		wDoctorManage.add(txtDoctorManageFinKod);

		JLabel lblDoctorManageFinKod = new JLabel("F??N Kod");
		lblDoctorManageFinKod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoctorManageFinKod.setBounds(455, 82, 106, 23);
		wDoctorManage.add(lblDoctorManageFinKod);

		JTextArea txtDoctorManagePassword = new JTextArea();
		txtDoctorManagePassword.setBounds(455, 166, 175, 23);
		wDoctorManage.add(txtDoctorManagePassword);

		JLabel lblDoctorManagePassword = new JLabel("??ifr??");
		lblDoctorManagePassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoctorManagePassword.setBounds(455, 141, 106, 23);
		wDoctorManage.add(lblDoctorManagePassword);

		JButton btnDoctorManageAdd = new JButton("??LAV?? ET");
		btnDoctorManageAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDoctorManageName.getText().length() == 0 || txtDoctorManagePassword.getText().length() == 0
						|| txtDoctorManageFinKod.getText().length() == 0) {
					Util.Helper.showMsg("fill");
				} else {
					boolean control = headDoctor.addDoctor(txtDoctorManageFinKod.getText(),
							txtDoctorManagePassword.getText(), txtDoctorManageName.getText());
					if (control) {
						Util.Helper.showMsg("success");
						txtDoctorManageFinKod.setText(null);
						txtDoctorManagePassword.setText(null);
						txtDoctorManageName.setText(null);
						try {
							updateDoctorModel();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnDoctorManageAdd.setBackground(new Color(50, 205, 50));
		btnDoctorManageAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoctorManageAdd.setBounds(455, 201, 175, 34);
		wDoctorManage.add(btnDoctorManageAdd);

		JLabel lblDoctorManageUserID = new JLabel("??stifad????i ID");
		lblDoctorManageUserID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoctorManageUserID.setBounds(455, 264, 106, 23);
		wDoctorManage.add(lblDoctorManageUserID);

		JTextArea txtDoctorManageUserID = new JTextArea();
		txtDoctorManageUserID.setBounds(455, 289, 175, 23);
		wDoctorManage.add(txtDoctorManageUserID);

		JButton btnDoctorManageDelete = new JButton("S??L");
		btnDoctorManageDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDoctorManageUserID.getText().length() == 0) {
					Util.Helper.showMsg("Z??hm??t olmasa bir h??kim se??in!");
				} else {
					if (Helper.confirm("sure")) {
						int selectID = Integer.parseInt(txtDoctorManageUserID.getText());
						try {
							boolean control = headDoctor.deleteDoctor(selectID);
							if (control) {
								Helper.showMsg("success");
								txtDoctorManageUserID.setText(null);
								updateDoctorModel();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnDoctorManageDelete.setForeground(new Color(255, 255, 255));
		btnDoctorManageDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoctorManageDelete.setBackground(new Color(220, 20, 60));
		btnDoctorManageDelete.setBounds(455, 323, 175, 34);
		wDoctorManage.add(btnDoctorManageDelete);

		JScrollPane wScrollDoctor = new JScrollPane();
		wScrollDoctor.setBounds(10, 11, 434, 346);
		wDoctorManage.add(wScrollDoctor);

		tableDoctors = new JTable(doctorModel);
		tableDoctors.setBackground(new Color(224, 255, 255));
		wScrollDoctor.setViewportView(tableDoctors);

		JPanel wClinicManage = new JPanel();
		wClinicManage.setBackground(new Color(224, 255, 255));
		wTabPane.addTab("Kliniki ????b??l??r", null, wClinicManage, null);
		wClinicManage.setLayout(null);

		JScrollPane wScrollClinic = new JScrollPane();
		wScrollClinic.setBounds(10, 36, 235, 324);
		wClinicManage.add(wScrollClinic);

		clinicMenu = new JPopupMenu();
		JMenuItem updateMenu = new JMenuItem("D??z??li?? Et");
		JMenuItem deleteMenu = new JMenuItem("Sil");
		clinicMenu.add(updateMenu);
		clinicMenu.add(deleteMenu);

		updateMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedClinicID = Integer
						.parseInt(tableClinics.getValueAt(tableClinics.getSelectedRow(), 0).toString());
				Clinic selectedClinic = clinic.getFetch(selectedClinicID);
				UpdateClinicGUI updateClinicGUI = new UpdateClinicGUI(selectedClinic);
				updateClinicGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateClinicGUI.setVisible(true);
				updateClinicGUI.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						try {
							updateClinicModel();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
			}

		});

		deleteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Util.Helper.confirm("sure")) {
					int selectedClinicID = Integer
							.parseInt(tableClinics.getValueAt(tableClinics.getSelectedRow(), 0).toString());
					if (clinic.deleteClinic(selectedClinicID)) {
						Util.Helper.showMsg("success");
						try {
							updateClinicModel();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						Util.Helper.showMsg("error");
					}
				}
				;

			}

		});

		tableClinics = new JTable(clinicModel);
		tableClinics.setComponentPopupMenu(clinicMenu);
		tableClinics.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point point = e.getPoint();
				int selectedRow = tableClinics.rowAtPoint(point);
				tableClinics.setRowSelectionInterval(selectedRow, selectedRow);
			}
		});
		tableClinics.setBackground(new Color(224, 255, 255));
		wScrollClinic.setViewportView(tableClinics);

		JTextArea txtClinicManageName = new JTextArea();
		txtClinicManageName.setBounds(261, 37, 129, 23);
		wClinicManage.add(txtClinicManageName);

		JLabel lblClinicManageName = new JLabel("Kliniki ????b??nin Ad??");
		lblClinicManageName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClinicManageName.setBounds(261, 6, 129, 23);
		wClinicManage.add(lblClinicManageName);

		JButton btnClinicManageAdd = new JButton("??LAV?? ET");
		btnClinicManageAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtClinicManageName.getText().length() == 0) {
					Util.Helper.showMsg("fill");
				} else {
					if (clinic.addClinic(txtClinicManageName.getText())) {
						Util.Helper.showMsg("success");
						txtClinicManageName.setText(null);
						try {
							updateClinicModel();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnClinicManageAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClinicManageAdd.setBackground(new Color(50, 205, 50));
		btnClinicManageAdd.setBounds(261, 71, 129, 34);
		wClinicManage.add(btnClinicManageAdd);

		JScrollPane wScrollWorker = new JScrollPane();
		wScrollWorker.setBounds(411, 36, 235, 324);
		wClinicManage.add(wScrollWorker);

		tableWorker = new JTable();
		wScrollWorker.setViewportView(tableWorker);

		JComboBox selectDoctorClinicManage = new JComboBox();
		selectDoctorClinicManage.setBounds(261, 256, 129, 34);
		for (int i = 0; i < headDoctor.getDoctorList().size(); i++) {
			selectDoctorClinicManage.addItem(
					new Item(headDoctor.getDoctorList().get(i).getId(), headDoctor.getDoctorList().get(i).getName()));
		}
		selectDoctorClinicManage.addActionListener(e -> {
			JComboBox c = (JComboBox) e.getSource();
			Item item = (Item) c.getSelectedItem();
		});
		wClinicManage.add(selectDoctorClinicManage);

		JButton btnClinicManageAddWorker = new JButton("??LAV?? ET");
		btnClinicManageAddWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow = tableClinics.getSelectedRow();
				if (selRow >= 0) {
					String selClinic = tableClinics.getModel().getValueAt(selRow, 0).toString();
					int selClinicID = Integer.parseInt(selClinic);
					Item doctorItem = (Item) selectDoctorClinicManage.getSelectedItem();
					boolean control = headDoctor.addWorker(doctorItem.getKey(), selClinicID);
					if (control) {
						Util.Helper.showMsg("success");
						DefaultTableModel clearModel = (DefaultTableModel) tableWorker.getModel();
						clearModel.setRowCount(0);
							try {
								for (int i = 0; i < headDoctor.getClinicDoctorList(selClinicID).size(); i++) {
								workerData[0] = headDoctor.getClinicDoctorList(selClinicID).get(i).getId();
								workerData[1] = headDoctor.getClinicDoctorList(selClinicID).get(i).getName();
								workerModel.addRow(workerData);
								

}
							} catch (SQLException e1) {
								e1.printStackTrace();
							} 
						tableWorker.setModel(workerModel);
					} else {
						Util.Helper.showMsg("error");
					}
				} else {
					Util.Helper.showMsg("Z??hm??t olmasa bir kliniki ????b?? se??in!");
				}
			}
		});
		btnClinicManageAddWorker.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClinicManageAddWorker.setBackground(new Color(50, 205, 50));
		btnClinicManageAddWorker.setBounds(261, 312, 129, 34);
		wClinicManage.add(btnClinicManageAddWorker);

		JLabel lblKlinikibniSe = new JLabel("Kliniki ????b??ni Se??");
		lblKlinikibniSe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKlinikibniSe.setBounds(261, 146, 129, 23);
		wClinicManage.add(lblKlinikibniSe);

		JButton btnClinicSelect = new JButton("SE??");
		btnClinicSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow = tableClinics.getSelectedRow();
				if (selRow >= 0) {
					String selClinic = tableClinics.getModel().getValueAt(selRow, 0).toString();
					int selClinicID = Integer.parseInt(selClinic);
					DefaultTableModel clearModel = (DefaultTableModel) tableWorker.getModel();
					clearModel.setRowCount(0);
					try {
						for (int i = 0; i < headDoctor.getClinicDoctorList(selClinicID).size(); i++) {
						workerData[0] = headDoctor.getClinicDoctorList(selClinicID).get(i).getId();
						workerData[1] = headDoctor.getClinicDoctorList(selClinicID).get(i).getName();
						workerModel.addRow(workerData);
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					tableWorker.setModel(workerModel);
				} else {
					Util.Helper.showMsg("Z??hm??t olmasa bir kliniki ????b?? se??in!");
				}
			}
		});
		btnClinicSelect.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClinicSelect.setBackground(new Color(30, 144, 255));
		btnClinicSelect.setBounds(261, 180, 129, 34);
		wClinicManage.add(btnClinicSelect);
		
		JLabel lblKlinikiblr = new JLabel("Kliniki ????b??l??r");
		lblKlinikiblr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKlinikiblr.setBounds(81, 6, 105, 23);
		wClinicManage.add(lblKlinikiblr);
		
		JLabel lblClinicManageName_1_1 = new JLabel("H??kiml??r");
		lblClinicManageName_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClinicManageName_1_1.setBounds(501, 6, 67, 23);
		wClinicManage.add(lblClinicManageName_1_1);
		tableDoctors.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {

					txtDoctorManageUserID.setText(tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 0).toString());
				} catch (Exception ex) {
				}
			}
		});
		tableDoctors.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int selectID = Integer
							.parseInt(tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 0).toString());
					String selectName = tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 1).toString();
					String selectFinKod = tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 2).toString();
					String selectPassword = tableDoctors.getValueAt(tableDoctors.getSelectedRow(), 3).toString();
					boolean control = headDoctor.updateDoctor(selectID, selectFinKod, selectPassword, selectName);
					if (control) {
						// Util.Helper.showMsg("success");
					}
				}
			}
		});
	}

	public void updateDoctorModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) tableDoctors.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < headDoctor.getDoctorList().size(); i++) {
			doctorData[0] = headDoctor.getDoctorList().get(i).getId();
			doctorData[1] = headDoctor.getDoctorList().get(i).getName();
			doctorData[2] = headDoctor.getDoctorList().get(i).getFinKod();
			doctorData[3] = headDoctor.getDoctorList().get(i).getPassword();
			doctorModel.addRow(doctorData);
		}
	}

	public void updateClinicModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) tableClinics.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < clinic.getClinicList().size(); i++) {
			clinicData[0] = clinic.getClinicList().get(i).getId();
			clinicData[1] = clinic.getClinicList().get(i).getName();
			clinicModel.addRow(clinicData);
		}
	}
}
