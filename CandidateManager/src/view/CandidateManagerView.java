package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.Candidate;
import model.CandidateManagerModel;
import model.Province;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CandidateManagerController;

import javax.swing.JRadioButton;

public class CandidateManagerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public CandidateManagerModel model;
	public JTextField textField_CandidateID;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_Subject1;
	public JTextField textField_Name;
	public JTextField textField_Subject2;
	public JTextField textField_Subject3;
	public JTextField textField_Birthday;
	public JTextField textField_Total;
	public JComboBox comboBox_InforHometown;
	public JComboBox comboBox_FilterHometown;
	public ButtonGroup btnGroup;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private JFileChooser chooser;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CandidateManagerView frame = new CandidateManagerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CandidateManagerView() {
		this.model = new CandidateManagerModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent e) {
				exitApp();
            }
		});
		setBounds(100, 100, 720, 575);
		
		CandidateManagerController action = new CandidateManagerController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuFile);
		
		JMenuItem menuItemOpen = new JMenuItem("Open");
		menuItemOpen.addActionListener(action);
		menuItemOpen.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuFile.add(menuItemOpen);
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		menuItemSave.addActionListener(action);
		menuItemSave.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuFile.add(menuItemSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(action);
		menuItemExit.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuFile.add(menuItemExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuAbout);
		
		JMenuItem jMenuItemAboutMe = new JMenuItem("About Me");
		jMenuItemAboutMe.addActionListener(action);
		jMenuItemAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuAbout.add(jMenuItemAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCandidateFilter = new JPanel();
		panelCandidateFilter.setBorder(new TitledBorder(null, "Candidate Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCandidateFilter.setBounds(10, 10, 686, 50);
		contentPane.add(panelCandidateFilter);
		panelCandidateFilter.setLayout(null);
		
		JLabel lblHometownFilter = new JLabel("Hometown");
		lblHometownFilter.setBounds(10, 10, 100, 34);
		lblHometownFilter.setHorizontalAlignment(SwingConstants.CENTER);
		lblHometownFilter.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCandidateFilter.add(lblHometownFilter);
		
		comboBox_FilterHometown = new JComboBox();
		comboBox_FilterHometown.setBounds(107, 17, 150, 23);
		comboBox_FilterHometown.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addProvinceToComboBox(comboBox_FilterHometown);
		panelCandidateFilter.add(comboBox_FilterHometown);
		
		JLabel lblCandidateID = new JLabel("CandidateID");
		lblCandidateID.setBounds(266, 10, 100, 34);
		lblCandidateID.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandidateID.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCandidateFilter.add(lblCandidateID);
		
		textField_CandidateID = new JTextField();
		textField_CandidateID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_CandidateID.setBounds(376, 17, 100, 23);
		panelCandidateFilter.add(textField_CandidateID);
		textField_CandidateID.setColumns(10);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(action);
		btnFilter.setBounds(486, 12, 90, 31);
		btnFilter.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelCandidateFilter.add(btnFilter);
		
		JButton btnCancelFilter = new JButton("Cancel Filter");
		btnCancelFilter.addActionListener(action);
		btnCancelFilter.setBounds(586, 12, 90, 30);
		btnCancelFilter.setFont(new Font("Tahoma", Font.BOLD, 9));
		panelCandidateFilter.add(btnCancelFilter);
		
		JPanel panelCandidateList = new JPanel();
		panelCandidateList.setBorder(new TitledBorder(null, "Candidate List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCandidateList.setBounds(10, 70, 686, 200);
		contentPane.add(panelCandidateList);
		panelCandidateList.setLayout(null);
		
		JScrollPane scrollPaneCandidateList = new JScrollPane();
		scrollPaneCandidateList.setBounds(10, 20, 666, 170);
		
		panelCandidateList.add(scrollPaneCandidateList);
		
		table = new JTable();
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(15);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "ID", "Name", "Hometown", "Birthday", "Sex", "Subject 1", "Subject 2", "Subject 3"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(30);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(60);
		table.getColumnModel().getColumn(8).setPreferredWidth(60);
		scrollPaneCandidateList.setViewportView(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // Gọi hàm khi một hàng được chọn
                        displayedOnInforForm();
                        calculateTotal();
                    }
                }
			}

		});
		
		JPanel panelCandidateInformation = new JPanel();
		panelCandidateInformation.setBorder(new TitledBorder(null, "Candidate Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCandidateInformation.setBounds(10, 281, 686, 230);
		contentPane.add(panelCandidateInformation);
		panelCandidateInformation.setLayout(null);
		
		JPanel panelInformation = new JPanel();
		panelInformation.setBounds(6, 15, 674, 160);
		panelCandidateInformation.add(panelInformation);
		panelInformation.setLayout(new GridLayout(0, 4, 0, 10));
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblID);
		
		textField_ID = new JTextField();
		textField_ID.setEditable(false);
		textField_ID.setEnabled(false);
		panelInformation.add(textField_ID);
		textField_ID.setColumns(10);
		
		JLabel lblSubject_1 = new JLabel("Subject 1");
		lblSubject_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblSubject_1);
		
		textField_Subject1 = new JTextField();
		textField_Subject1.setEditable(false);
		textField_Subject1.setEnabled(false);
		panelInformation.add(textField_Subject1);
		textField_Subject1.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblName);
		
		textField_Name = new JTextField();
		textField_Name.setEnabled(false);
		textField_Name.setEditable(false);
		panelInformation.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblSubject_2 = new JLabel("Subject 2");
		lblSubject_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblSubject_2);
		
		textField_Subject2 = new JTextField();
		textField_Subject2.setEditable(false);
		textField_Subject2.setEnabled(false);
		panelInformation.add(textField_Subject2);
		textField_Subject2.setColumns(10);
		
		JLabel lblHometownInfor = new JLabel("Hometown");
		lblHometownInfor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHometownInfor.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblHometownInfor);
		
		comboBox_InforHometown = new JComboBox();
		comboBox_InforHometown.setEnabled(false);
		comboBox_InforHometown.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addProvinceToComboBox(comboBox_InforHometown);
		panelInformation.add(comboBox_InforHometown);
		
		JLabel lblSubject_3 = new JLabel("Subject 3");
		lblSubject_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubject_3.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblSubject_3);
		
		textField_Subject3 = new JTextField();
		textField_Subject3.setEditable(false);
		textField_Subject3.setEnabled(false);
		panelInformation.add(textField_Subject3);
		textField_Subject3.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirthday.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblBirthday);
		
		textField_Birthday = new JTextField();
		textField_Birthday.setEditable(false);
		textField_Birthday.setEnabled(false);
		panelInformation.add(textField_Birthday);
		textField_Birthday.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblTotal);
		
		textField_Total = new JTextField();
		textField_Total.setEnabled(false);
		textField_Total.setEditable(false);
		panelInformation.add(textField_Total);
		textField_Total.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(lblSex);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setEnabled(false);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMale.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setEnabled(false);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFemale.setHorizontalAlignment(SwingConstants.CENTER);
		panelInformation.add(rdbtnFemale);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnMale);
		btnGroup.add(rdbtnFemale);
		
		JPanel panelBtn = new JPanel();
		FlowLayout fl_panelBtn = (FlowLayout) panelBtn.getLayout();
		fl_panelBtn.setHgap(50);
		panelBtn.setBounds(6, 185, 670, 35);
		panelCandidateInformation.add(panelBtn);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(action);
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelBtn.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(action);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelBtn.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(action);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelBtn.add(btnEdit);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(action);
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelBtn.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(action);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelBtn.add(btnCancel);
		
//		this.setVisible(true);
	}
	
	private void calculateTotal() {
		float subject1 = Float.parseFloat(textField_Subject1.getText());
		float subject2 = Float.parseFloat(textField_Subject2.getText());
		float subject3 = Float.parseFloat(textField_Subject3.getText());
		float total = subject1+subject2+subject3;
		textField_Total.setText(total+"");
	}
	
	// Thêm các tỉnh thành vào comboBox
    private void addProvinceToComboBox(JComboBox<String> comboBox) {
        ArrayList<Province> provinceList = Province.getProvinceList();
        comboBox.addItem(""); // để box trống trước khi user chọn
        for (Province province : provinceList) {
            comboBox.addItem(province.getProvinceName());
        }
    }

	public void emptyForm() {
		textField_ID.setText(null);
		textField_Name.setText(null);
		comboBox_InforHometown.setSelectedIndex(-1);;
		btnGroup.clearSelection();
		textField_Birthday.setText(null);
		textField_Subject1.setText(null);
		textField_Subject2.setText(null);
		textField_Subject3.setText(null);
		textField_Total.setText(null);
		
	}
	
	public void addRowToTable(Candidate candidate) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int rowCount = defaultTableModel.getRowCount();
		defaultTableModel.addRow(
				new Object[] {
						rowCount + 1,
						candidate.getCandidateCode()+"",
						candidate.getCandidateName()+"",
						candidate.getHometown().getProvinceName(),
						df.format(candidate.getBirthday()),
						(candidate.isGender()?"Male":"Female"),
						candidate.getScore1()+"",
						candidate.getScore2()+"",
						candidate.getScore3()+""
				}
		);
		
	}
	
	public Candidate getChooseCandidate() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		
		int candidateCode = Integer.valueOf(defaultTableModel.getValueAt(i_row, 1)+"");// vị trí cột 0 hàng r_row
		String candidateName = defaultTableModel.getValueAt(i_row, 2)+"";
		
		Province province = Province.getProvinceByName(defaultTableModel.getValueAt(i_row, 3)+"");
		
		String inputDateStr = defaultTableModel.getValueAt(i_row, 4)+"";
		
		Date birthday = null;
		try {
			birthday = df.parse(inputDateStr);// fomat date là dd/MM/yyyy trước khi nhập vào birthday (do lỗi mm/dd/yyyy)
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String genderStr = defaultTableModel.getValueAt(i_row, 5)+"";
		boolean gender = true; // true = male
		if(genderStr.equals("Female")) {
			gender = false;
		}
		
		float score1 = Float.valueOf(defaultTableModel.getValueAt(i_row, 6)+"");
		float score2 = Float.valueOf(defaultTableModel.getValueAt(i_row, 7)+"");
		float score3 = Float.valueOf(defaultTableModel.getValueAt(i_row, 8)+"");
		
		Candidate candidateChosen = new Candidate(candidateCode, candidateName, province, birthday, gender, score1, score2, score3);
		return candidateChosen;
	}
	

	public void addOrEditCandidate() {
		int candidateCode = Integer.valueOf(this.textField_ID.getText());
		String candidateName = this.textField_Name.getText();
		
		int hometownId = this.comboBox_InforHometown.getSelectedIndex()-1;
		Province province = Province.getProvinceById(hometownId);
		
		String inputDateStr = this.textField_Birthday.getText();
		
		Date birthday = null;
		try {
			birthday = df.parse(inputDateStr);// fomat date là dd/MM/yyyy trước khi nhập vào birthday (do lỗi mm/dd/yyyy)
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		boolean gender = true;//true == male
		if(this.rdbtnFemale.isSelected()) {
			gender = false;
		} 
		float score1 = Float.valueOf(this.textField_Subject1.getText());
		float score2 = Float.valueOf(this.textField_Subject2.getText());
		float score3 = Float.valueOf(this.textField_Subject3.getText());
		
		Candidate newCandidate = new Candidate(candidateCode, candidateName, province, birthday, gender, score1, score2, score3);
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		
		if(!this.model.checkExist(newCandidate)) {// nếu như chưa tồn tại thì insert
			this.model.insert(newCandidate);
			this.addRowToTable(newCandidate);
			
		} else {// nếu đã tồn tại thì update
			//Update lại thí sinh trong candidateList
			Candidate existCandidate = getChooseCandidate();
			int oldCandidateId = this.model.candidateList.indexOf(existCandidate);
			this.model.candidateList.set(oldCandidateId, newCandidate);
			
			int numberOfRow = defaultTableModel.getRowCount();
			for (int i = 0; i < numberOfRow; i++) {
				String id = defaultTableModel.getValueAt(i, 1)+"";
				if(id.equals(newCandidate.getCandidateCode()+"")) {
					defaultTableModel.setValueAt(newCandidate.getCandidateCode()+"", i, 1);
					defaultTableModel.setValueAt(newCandidate.getCandidateName()+"", i, 2);
					defaultTableModel.setValueAt(newCandidate.getHometown().getProvinceName(), i, 3);
					defaultTableModel.setValueAt(df.format(newCandidate.getBirthday()), i, 4);
					defaultTableModel.setValueAt((newCandidate.isGender()?"Male":"Female"), i, 5);
					defaultTableModel.setValueAt(newCandidate.getScore1()+"", i, 6);
					defaultTableModel.setValueAt(newCandidate.getScore2()+"", i, 7);
					defaultTableModel.setValueAt(newCandidate.getScore3()+"", i, 8);
				}
				
			}
		}
		
		
	}

	public void enableInforBox() {
		textField_ID.setEditable(true);
		textField_ID.setEnabled(true);
		textField_Name.setEnabled(true);
		textField_Name.setEditable(true);
		comboBox_InforHometown.setEnabled(true);
		textField_Birthday.setEditable(true);
		textField_Birthday.setEnabled(true);
		rdbtnMale.setEnabled(true);
		rdbtnFemale.setEnabled(true);
		textField_Subject1.setEditable(true);
		textField_Subject1.setEnabled(true);
		textField_Subject2.setEditable(true);
		textField_Subject2.setEnabled(true);
		textField_Subject3.setEditable(true);
		textField_Subject3.setEnabled(true);
	}
	
	public void disableInforBox() {
		textField_ID.setEditable(false);
		textField_ID.setEnabled(false);
		textField_Name.setEnabled(false);
		textField_Name.setEditable(false);
		comboBox_InforHometown.setEnabled(false);
		textField_Birthday.setEditable(false);
		textField_Birthday.setEnabled(false);
		rdbtnMale.setEnabled(false);
		rdbtnFemale.setEnabled(false);
		textField_Subject1.setEditable(false);
		textField_Subject1.setEnabled(false);
		textField_Subject2.setEditable(false);
		textField_Subject2.setEnabled(false);
		textField_Subject3.setEditable(false);
		textField_Subject3.setEnabled(false);
	}
	
	

	public void displayedOnInforForm() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		Candidate candidateChosen = getChooseCandidate();
		
		this.textField_ID.setText(candidateChosen.getCandidateCode()+"");
		this.textField_Name.setText(candidateChosen.getCandidateName());
		this.comboBox_InforHometown.setSelectedItem(candidateChosen.getHometown().getProvinceName());// lấy ra đối tượng trong comboBox có province === province đã lấy trong getProvinceByName()
		this.textField_Birthday.setText(df.format(candidateChosen.getBirthday()));
		if(candidateChosen.isGender()) {
			this.rdbtnMale.setSelected(true);
		} else {
			this.rdbtnFemale.setSelected(true);
		}
		this.textField_Subject1.setText(candidateChosen.getScore1()+"");
		this.textField_Subject2.setText(candidateChosen.getScore2()+"");
		this.textField_Subject3.setText(candidateChosen.getScore3()+"");
	}

	public void deleteChoose() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int userChoose = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this candidate?");
		Candidate candidateChoose = getChooseCandidate();
		if(userChoose==JOptionPane.YES_OPTION) {
			this.model.delete(candidateChoose);
			defaultTableModel.removeRow(i_row);
			refreshTable();
		} 
	}

	public void filter() {
		//Gọi hàm hủy tìm để clear table trước khi tìm cái mới
		this.refreshTable();
		
		int hometownId = this.comboBox_FilterHometown.getSelectedIndex()-1;
		String candidateIdFilter = this.textField_CandidateID.getText();
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int numberOfRow = defaultTableModel.getRowCount();
		Set<Integer> candidateIdWillBeDelete = new TreeSet<Integer>();
		
		if(hometownId>=0) {// filter hometown
			Province provinceChoose = Province.getProvinceById(hometownId);
			System.out.println("provinceChoose: "+ provinceChoose);
			for (int i = 0; i < numberOfRow; i++) {
				String candidateIdInTable = defaultTableModel.getValueAt(i, 1)+"";
				String hometownNameInTable = defaultTableModel.getValueAt(i, 3)+"";
				if(!hometownNameInTable.equals(provinceChoose.getProvinceName())) { // nếu không phải hometown đó thì xóa nó đi bằng cách add riêng nó vào set và xóa(cần cân nhắc khi để giá trị so sánh trong equals(giá trị) vì nó có thể null)
					candidateIdWillBeDelete.add(Integer.valueOf(candidateIdInTable));
					System.out.println("candidateIdWillBeDelete.add(Integer.valueOf(candidateIdInTable)): "+ candidateIdInTable);
				}
				
			}
		}
		if(candidateIdFilter.length() > 0) { // filter candidate Id
			for (int i = 0; i < numberOfRow; i++) {
				String candidateIdInTable = defaultTableModel.getValueAt(i, 1)+"";
				if(!candidateIdFilter.equals(candidateIdInTable)) { 
					candidateIdWillBeDelete.add(Integer.valueOf(candidateIdInTable));
				}
				
			}
		}
		
		for (Integer idWillBeDelete : candidateIdWillBeDelete) {
			numberOfRow = defaultTableModel.getRowCount();
			for (int i = 0; i < numberOfRow; i++) {
				String candidateIdInTable = defaultTableModel.getValueAt(i, 1)+"";
				if(candidateIdInTable.equals(idWillBeDelete.toString())) { 
					try {
						defaultTableModel.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
				
			}
		}
		
	}

	public void refreshTable() {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setRowCount(0);//xoa table filter
		
		for (Candidate candidate : this.model.getCandidateList()) {
			this.addRowToTable(candidate);
		}
		
	}

	public void exitApp() {
		int userChoose = JOptionPane.showConfirmDialog(this, "Do you want to save your work");
		if(userChoose==JOptionPane.YES_OPTION) {
			saveFile();
		} else if(userChoose==JOptionPane.NO_OPTION){
			System.exit(0);
		}
		
	}
	
	public void save(String filePath) {
		/*
		 * Lưu ý tất cả đối tượng muốn lưu xuống phải implements Serializable
		 */
		try {
			this.model.setFileName(filePath);
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Candidate candidate : this.model.getCandidateList()) {
				oos.writeObject(candidate);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	public void saveFile() {
		//nếu có tên file thì fileSize sẽ chứa tên file nên sẽ > 0
		int fileSize = this.model.getFileName().length();
		if(fileSize > 0) { // nếu > 0 thì tên file đã tồn tại, ta ghi dữ liệu đè xuống
			save(this.model.getFileName());
		} else {// nếu file chưa tồn tại
			JFileChooser chooser = new JFileChooser();
			//showSaveDialog hiển thị hộp thoại để chọn nơi lưu file
			int returnVal = chooser.showSaveDialog(this);//hiển thị ở view
		    if(returnVal == JFileChooser.APPROVE_OPTION) {//APPROVE là chọn đc file
		       File file = chooser.getSelectedFile();
		       save(file.getAbsolutePath());
		    }
		}
	}
	
	private void open(File file) {
		ArrayList candidateFileList = new ArrayList();
		try {
			this.model.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Candidate candidateFromFile = null;
			while((candidateFromFile = (Candidate) ois.readObject()) != null) {
				candidateFileList.add(candidateFromFile);
			}
			
			ois.close();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		this.model.setCandidateList(candidateFileList);
	}

	public void openFile() {
		JFileChooser chooser = new JFileChooser();
		//showOpenDialog hiển thị hộp thoại để chọn nơi mở file
		int returnVal = chooser.showOpenDialog(this);//hiển thị ở view
		if(returnVal == JFileChooser.APPROVE_OPTION) {//APPROVE là chọn đc file
			File file = chooser.getSelectedFile();
			open(file); 
		}
		this.refreshTable();
	}

	
}
