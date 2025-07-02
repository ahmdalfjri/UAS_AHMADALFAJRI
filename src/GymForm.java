/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ilham
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import javax.swing.ImageIcon;
import java.util.Map;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.AutoFilter.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.sql.Statement;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

        
















public class GymForm extends javax.swing.JFrame {
    
    Map<String, TrainerData> trainerMap = new HashMap<>();
    
   

   
private void detail() {
    String nama = tfNama.getText();
    String email = tfEmail.getText();
    String nohp = tfNoHP.getText();

    String tipe = rbBulanan.isSelected() ? "Bulanan" : "Tahunan";
    String trainer = cbTrainer.getSelectedItem().toString();

    // Harga dasar per tipe
    double hargaDasar = tipe.equals("Bulanan") ? 200000 : 2400000;

    // Faktor trainer
    double faktorTrainer = 1.0;
    String latihan = "";
    int rating = sbRating.getValue();

    switch (trainer) {
        case "David Laid":
            faktorTrainer = 2.3;
            latihan = "Angkat Beban";
            break;
        case "Steve Cook":
            faktorTrainer = 1.9;
            latihan = "Cardio";
            break;
        case "Adriene Mishler":
            faktorTrainer = 1.7;
            latihan = "Yoga";
            break;
        case "Lex Griffin":
            faktorTrainer = 2.1;
            latihan = "Cross Fit";
            break;
        default:
            latihan = "-";
            break;
    }

    int masaAktif;
    try {
        masaAktif = Integer.parseInt(spAktif.getValue().toString());
    } catch (Exception e) {
        masaAktif = 1;
    }

    String metode = "";
    if (cbCash.isSelected()) metode += "Cash ";
    if (cbBca.isSelected()) metode += "BCA ";
    if (cbMandiri.isSelected()) metode += "MANDIRI ";
    if (cbBri.isSelected()) metode += "BRI";
    metode = metode.trim();

    String jenisLatihan = listJenisLatihan.getSelectedValue() != null
            ? listJenisLatihan.getSelectedValue()
            : latihan;

    double totalHarga = hargaDasar * masaAktif * faktorTrainer;
    tfHarga.setText(String.format("%.0f", totalHarga));

    String bukti = tfBukti.getText().isEmpty() ? "Belum diunggah" : tfBukti.getText();

    detail.setText(
        "Nama: " + nama + "\n" +
        "Email: " + email + "\n" +
        "No HP: " + nohp + "\n" +
        "Tipe Member: " + tipe + "\n" +
        "Trainer: " + trainer + "\n" +
        "Rating Trainer: " + rating + "/10\n" +
        "Jenis Latihan: " + jenisLatihan + "\n" +
        "Masa Aktif: " + masaAktif + (tipe.equals("Bulanan") ? " Bulan\n" : " Tahun\n") +
        "Harga Dasar: Rp" + (int)hargaDasar + "\n" +
        "Faktor Trainer: " + faktorTrainer + "\n" +
        "Harga Total: Rp" + String.format("%.0f", totalHarga) + "\n" +
        "Metode Pembayaran: " + metode + "\n" +
        "Bukti Pembayaran: " + bukti
    );
}



   




    public GymForm() {
        setTitle("Aplikasi Ahmad Al Fajri: Form Berlangganan Gym");
        
        loadTrainerData();
        
        initComponents();
         tampilData();
        

      rbBulanan.addActionListener(e -> detail());
      rbTahunan.addActionListener(e -> detail());
      cbTrainer.addActionListener(e -> detail());
      spAktif.addChangeListener(e -> detail());
      sbRating.addAdjustmentListener(e -> detail());
      cbCash.addActionListener(e -> detail());
      cbBca.addActionListener(e -> detail());
      cbMandiri.addActionListener(e -> detail());
      cbBri.addActionListener(e -> detail());
      listJenisLatihan.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) detail();
});

   
      
        
}
    
    class TrainerData {
    String imagePath;
    int rating; // max 10
    String latihan;
    

    TrainerData(String imagePath, int rating, String latihan) {
        this.imagePath = imagePath;
        this.rating = rating;
        this.latihan = latihan;
    }
}




    private void loadTrainerData() {
    trainerMap.put("David Laid", new TrainerData("Trainer/david.jpg", 10, "Angkat Beban"));
    trainerMap.put("Steve Cook", new TrainerData("Trainer/steve.jpg", 8, "Cardio"));
    trainerMap.put("Adriene Mishler", new TrainerData("Trainer/adriene.jpg", 7, "Yoga"));
    trainerMap.put("Lex Griffin", new TrainerData("Trainer/lex.jpg", 9, "Cross Fit"));
    

    // tambahkan lainnya
    // Map berdasarkan nama (sudah kamu punya)
    
    
    
    

    }
    
    private String getTrainerNameByData(TrainerData data) {
    for (Map.Entry<String, TrainerData> entry : trainerMap.entrySet()) {
        if (entry.getValue().equals(data)) {
            return entry.getKey();
        }
    }
    return "";
}


        
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbBulanan = new javax.swing.JRadioButton();
        rbTahunan = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        spAktif = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        cbTrainer = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbCash = new javax.swing.JCheckBox();
        cbBca = new javax.swing.JCheckBox();
        cbMandiri = new javax.swing.JCheckBox();
        cbBri = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        detail = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnupload = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        tfNoHP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listJenisLatihan = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        sbRating = new javax.swing.JScrollBar();
        jLabel11 = new javax.swing.JLabel();
        tfRating = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        taKeterangan = new javax.swing.JTextArea();
        lblFoto = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfHarga = new javax.swing.JTextField();
        resetForm = new javax.swing.JButton();
        tfBukti = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldatagym = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama:");

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipe Member:");

        buttonGroup2.add(rbBulanan);
        rbBulanan.setText("Bulanan");
        rbBulanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBulananActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbTahunan);
        rbTahunan.setText("Tahunan");

        jLabel4.setText("Masa Aktif:");

        spAktif.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                spAktifAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel5.setText("Trainer:");

        cbTrainer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Trainer--", "David Laid", "Steve Cook", "Adriene Mishler", "Lex Griffin", "Non Trainer" }));
        cbTrainer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrainerActionPerformed(evt);
            }
        });

        jLabel6.setText("Metode Pembayaran:");

        buttonGroup1.add(cbCash);
        cbCash.setText("Cash");
        cbCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCashActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbBca);
        cbBca.setText("BCA");

        buttonGroup1.add(cbMandiri);
        cbMandiri.setText("Mandiri");

        buttonGroup1.add(cbBri);
        cbBri.setText("BRI");

        detail.setEditable(false);
        detail.setColumns(20);
        detail.setRows(5);
        jScrollPane1.setViewportView(detail);

        jLabel7.setText("Info Harga & Detail:");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnupload.setText("Upload Bukti pembayaran");
        btnupload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuploadActionPerformed(evt);
            }
        });

        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });

        tfNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNoHPActionPerformed(evt);
            }
        });

        jLabel8.setText("Email:");

        jLabel9.setText("No_Hp:");

        listJenisLatihan.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Angkat Beban", "Yoga", "Cardio", "Cross Fit", " ", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listJenisLatihan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                listJenisLatihanAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        listJenisLatihan.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listJenisLatihanValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listJenisLatihan);

        jLabel10.setText("Rating");

        sbRating.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        sbRating.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                sbRatingAdjustmentValueChanged(evt);
            }
        });

        jLabel11.setText("Keterangan:");

        tfRating.setEditable(false);
        tfRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRatingActionPerformed(evt);
            }
        });

        taKeterangan.setColumns(20);
        taKeterangan.setRows(5);
        jScrollPane4.setViewportView(taKeterangan);

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Trainer/profil.png"))); // NOI18N
        lblFoto.setMaximumSize(new java.awt.Dimension(613, 490));
        lblFoto.setMinimumSize(new java.awt.Dimension(613, 490));
        lblFoto.setPreferredSize(new java.awt.Dimension(613, 490));

        jLabel12.setText("Jenis Latihan:");

        jLabel13.setText("Harga");

        tfHarga.setEditable(false);

        resetForm.setText("Reset");
        resetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfNoHP, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                            .addComponent(tfEmail)
                                            .addComponent(tfNama)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbBulanan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbTahunan)))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(96, 96, 96)
                                        .addComponent(jLabel6))
                                    .addComponent(cbTrainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbCash)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbMandiri))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbBca)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbBri))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnSimpan)
                                .addGap(122, 122, 122)
                                .addComponent(resetForm)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnupload, javax.swing.GroupLayout.Alignment.LEADING)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(290, 290, 290)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                                .addGap(248, 248, 248)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sbRating, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfRating, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 47, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(tfBukti, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbCash)
                    .addComponent(cbMandiri)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(cbTrainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbBca, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(cbBri, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(95, 95, 95)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(sbRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(29, 29, 29)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnupload)
                            .addComponent(tfBukti, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rbBulanan)
                            .addComponent(rbTahunan))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(spAktif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(resetForm))
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Member", jPanel1);

        tbldatagym.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "EMAIL", "NO_HP", "TIPE_MEMBER", "TRAINER", "HARGA", "MASA_AKTIF", "METODE-PEMBAYARAN"
            }
        ));
        tbldatagym.setShowGrid(false);
        tbldatagym.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldatagymMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbldatagym);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jButton5.setText("Cetak Excel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jButton1.setText("Cetak Laporan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnHapus)
                        .addGap(31, 31, 31)
                        .addComponent(btnEdit)
                        .addGap(55, 55, 55)
                        .addComponent(jButton5)
                        .addGap(70, 70, 70)
                        .addComponent(jButton1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Laporan", jPanel2);

        jLabel2.setText("Form Berlangganan Gym");

        jMenu3.setText("Menu");

        jMenuItem2.setText("Menu Utama");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void cbCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCashActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbCashActionPerformed

    private void rbBulananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBulananActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_rbBulananActionPerformed

    private void cbTrainerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrainerActionPerformed
        // TODO add your handling code here:
       
        
        
    
    String selectedTrainer = cbTrainer.getSelectedItem().toString();
    TrainerData data = trainerMap.get(selectedTrainer);

    if (data != null) {
        // Tampilkan gambar
        ImageIcon icon = new ImageIcon(getClass().getResource("/" + data.imagePath));
        Image img = icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
        lblFoto.setIcon(new ImageIcon(img));

        // Rating via scrollbar
        sbRating.setValue(data.rating);  // set nilai
        tfRating.setText(String.valueOf(data.rating)); // muncul ke TextField

        // Jenis Latihan
        listJenisLatihan.setSelectedValue(data.latihan, true);

        // Deskripsi ke textArea
        String deskripsi = "Trainer: " + selectedTrainer +
                           "\nRating: " + data.rating +
                           "\nLatihan: " + data.latihan;
        taKeterangan.setText(deskripsi);
    }





    }//GEN-LAST:event_cbTrainerActionPerformed

    private void spAktifAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_spAktifAncestorAdded
        // TODO add your handling code here:
       JSpinner spAktif = new JSpinner(new SpinnerNumberModel(1, 1, 24, 1));
    }//GEN-LAST:event_spAktifAncestorAdded

    private void tfNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNoHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNoHPActionPerformed

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void sbRatingAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_sbRatingAdjustmentValueChanged
        // TODO add your handling code here:
        
        
        int nilaiRating = sbRating.getValue();

        // Cari trainer berdasarkan rating
        for (Map.Entry<String, TrainerData> entry : trainerMap.entrySet()) {
            TrainerData data = entry.getValue();

            if (data.rating == nilaiRating) {
                String trainerName = entry.getKey();

                // Foto
                ImageIcon icon = new ImageIcon(getClass().getResource("/" + data.imagePath));
                Image img = icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(img));

                // Combo trainer dan list latihan
                cbTrainer.setSelectedItem(trainerName);
                listJenisLatihan.setSelectedValue(data.latihan, true);

                // TextField rating
                tfRating.setText(String.valueOf(data.rating));

                // Keterangan
                String deskripsi = "Trainer: " + trainerName +
                                   "\nRating: " + data.rating +
                                   "\nLatihan: " + data.latihan;
                taKeterangan.setText(deskripsi);
                break;
            }
        }
    


        
        int value = sbRating.getValue();
        if (value > 10) {
            sbRating.setValue(10);
            value = 10;
        }
        tfRating.setText(String.valueOf(value));
    


    }//GEN-LAST:event_sbRatingAdjustmentValueChanged

    private void listJenisLatihanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_listJenisLatihanAncestorAdded
        // TODO add your handling code here:
        
       

    }//GEN-LAST:event_listJenisLatihanAncestorAdded

    private void listJenisLatihanValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listJenisLatihanValueChanged
        // TODO add your handling code here:
        listJenisLatihan.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            String selectedLatihan = listJenisLatihan.getSelectedValue();

            for (Map.Entry<String, TrainerData> entry : trainerMap.entrySet()) {
                TrainerData data = entry.getValue();

                if (data.latihan.equalsIgnoreCase(selectedLatihan)) {
                    String trainerName = entry.getKey();

                    // Foto
                    ImageIcon icon = new ImageIcon(getClass().getResource("/" + data.imagePath));
                    Image img = icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
                    lblFoto.setIcon(new ImageIcon(img));

                    // Combo trainer dan rating
                    cbTrainer.setSelectedItem(trainerName);
                    sbRating.setValue(data.rating);
                    tfRating.setText(String.valueOf(data.rating));

                    // Keterangan
                    String deskripsi = "Trainer: " + trainerName +
                                       "\nRating: " + data.rating +
                                       "\nLatihan: " + data.latihan;
                    taKeterangan.setText(deskripsi);
                    break;
                }
            }
        }
    }
});

    }//GEN-LAST:event_listJenisLatihanValueChanged

    private void tfRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRatingActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
       

    try {
        Connection con = DBConnection.connect(); // Koneksi ke Derby
        String sql = "INSERT INTO gymdb (nama, email, no_hp, tipe_member, trainer, harga, masa_aktif, metode_pembayaran) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, tfNama.getText());
        ps.setString(2, tfEmail.getText());
        ps.setString(3, tfNoHP.getText());

        String tipe = rbBulanan.isSelected() ? "Bulanan" : "Tahunan";
        ps.setString(4, tipe);
        ps.setString(5, cbTrainer.getSelectedItem().toString());

        double harga = Double.parseDouble(tfHarga.getText());
        ps.setDouble(6, harga);

        int masaAktif = (Integer) spAktif.getValue();
        ps.setInt(7, masaAktif);

        String metode = "";
        if (cbCash.isSelected()) metode += "Cash ";
        if (cbBca.isSelected()) metode += "BCA ";
        if (cbMandiri.isSelected()) metode += "MANDIRI ";
        if (cbBri.isSelected()) metode += "BRI";
        metode = metode.trim();
        ps.setString(8, metode);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        resetForm();
        tampilData();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal simpan: " + e.getMessage());
    }





    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnuploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuploadActionPerformed
        // TODO add your handling code here:
        
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        tfBukti.setText(selectedFile.getAbsolutePath());
        detail(); // panggil agar langsung muncul ke JTextArea
    }
    }//GEN-LAST:event_btnuploadActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        btnHapus.addActionListener(e -> {
    int selectedRow = tbldatagym.getSelectedRow();

    int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (konfirmasi != JOptionPane.YES_OPTION) return;

    try {
        String id = tbldatagym.getValueAt(selectedRow, 0).toString(); // asumsikan kolom ke-0 adalah ID
        Connection con = DBConnection.connect();
        String sql = "DELETE FROM gymdb WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        int rows = ps.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            tampilData(); // refresh tabel
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal dihapus.");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
});

    }//GEN-LAST:event_btnHapusActionPerformed

    private void resetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_resetFormActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        
    int selectedRow = tbldatagym.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Ambil ID dari baris terpilih (asumsi kolom pertama adalah ID)
    String id = tbldatagym.getValueAt(selectedRow, 0).toString();

    detail();
    // Ambil data dari input field
    String nama = tfNama.getText().trim();
    String email = tfEmail.getText().trim();
    String nohp = tfNoHP.getText().trim();
    String tipe = rbBulanan.isSelected() ? "Bulanan" : "Tahunan";
    String trainer = cbTrainer.getSelectedItem() != null ? cbTrainer.getSelectedItem().toString() : "Tidak Ada";
    int masaAktif = (Integer) spAktif.getValue();
    double harga = Double.parseDouble(tfHarga.getText());

    String metode = "";
    if (cbCash.isSelected()) metode += "Cash ";
    if (cbBca.isSelected()) metode += "BCA ";
    if (cbMandiri.isSelected()) metode += "MANDIRI ";
    if (cbBri.isSelected()) metode += "BRI";
    metode = metode.trim();

    try {
        Connection con = DBConnection.connect();
        String sql = "UPDATE gymdb SET nama=?, email=?, no_hp=?, tipe_member=?, trainer=?, harga=?, masa_aktif=?, metode_pembayaran=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, nama);
        ps.setString(2, email);
        ps.setString(3, nohp);
        ps.setString(4, tipe);
        ps.setString(5, trainer);
        ps.setDouble(6, harga);
        ps.setInt(7, masaAktif);
        ps.setString(8, metode);
        ps.setString(9, id);

        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui!");
            tampilData(); // Refresh tabel
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal diperbarui!");
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Gagal update: " + ex.getMessage());
    }

    }//GEN-LAST:event_btnEditActionPerformed

    private void tbldatagymMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldatagymMouseClicked
        // TODO add your handling code here:
       
        int row = tbldatagym.getSelectedRow();

        if (row != -1) {
            tfNama.setText(tbldatagym.getValueAt(row, 1).toString());
            tfEmail.setText(tbldatagym.getValueAt(row, 2).toString());
            tfNoHP.setText(tbldatagym.getValueAt(row, 3).toString());

            String tipe = tbldatagym.getValueAt(row, 4).toString();
            if (tipe.equalsIgnoreCase("Bulanan")) {
                rbBulanan.setSelected(true);
            } else {
                rbTahunan.setSelected(true);
            }

            String trainer = tbldatagym.getValueAt(row, 5).toString();
            cbTrainer.setSelectedItem(trainer.equals("") ? "Tidak Ada" : trainer);

            tfHarga.setText(tbldatagym.getValueAt(row, 6).toString());
            spAktif.setValue(Integer.parseInt(tbldatagym.getValueAt(row, 7).toString()));

            String metode = tbldatagym.getValueAt(row, 8).toString();
            cbCash.setSelected(metode.contains("Cash"));
            cbBca.setSelected(metode.contains("BCA"));
            cbMandiri.setSelected(metode.contains("MANDIRI"));
            cbBri.setSelected(metode.contains("BRI"));
        }
    

    }//GEN-LAST:event_tbldatagymMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
    Connection conn = DBConnection.connect(); // Panggil koneksi dari class DBConnection

    // Pastikan file laporan sudah dikompilasi (laporan_gym.jasper) dan diletakkan di folder src/report
    String reportPath = "src/report/laporan_gym.jasper";

    // Jika ingin kirim parameter ke laporan, siapkan Map (jika tidak, pakai null)
    JasperPrint jp = JasperFillManager.fillReport(reportPath, null, conn);

    // Tampilkan laporan
    JasperViewer.viewReport(jp, false); // false agar form utama tidak tertutup

} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal menampilkan laporan: \n" + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        exportToExcel(tbldatagym);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
          Menu daftar = new Menu();
        daftar.setVisible(true);
        daftar.setLocationRelativeTo(null);   
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void exportToExcel(JTable table){
    Workbook workbook = new XSSFWorkbook();
    try {
        Sheet sheet = workbook.createSheet("Data Member Gym");

        if (table.getRowCount() > 0) {
            TableModel model = table.getModel();

            // Header kolom dari JTable
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < model.getColumnCount(); col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(model.getColumnName(col));
            }

            // Data baris dari JTable
            for (int row = 0; row < model.getRowCount(); row++) {
                Row dataRow = sheet.createRow(row + 1);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    Cell cell = dataRow.createCell(col);
                    cell.setCellValue(value != null ? value.toString() : "");
                }
            }

        } else {
            // Jika JTable kosong, ambil langsung dari database gymdb
            String sql = "SELECT * FROM gymdb";
            Connection conn = DBConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Buat header kolom
            String[] kolom = {
                "ID", "Nama", "Email", "No HP", "Tipe Member",
                "Trainer", "Harga", "Masa Aktif", "Metode Pembayaran"
            };
            Row header = sheet.createRow(0);
            for (int i = 0; i < kolom.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(kolom[i]);
            }

            // Data dari ResultSet
            int rowIndex = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(rs.getString("id"));
                row.createCell(1).setCellValue(rs.getString("nama"));
                row.createCell(2).setCellValue(rs.getString("email"));
                row.createCell(3).setCellValue(rs.getString("no_hp"));
                row.createCell(4).setCellValue(rs.getString("tipe_member"));
                row.createCell(5).setCellValue(rs.getString("trainer"));
                row.createCell(6).setCellValue(rs.getDouble("harga"));
                row.createCell(7).setCellValue(rs.getInt("masa_aktif"));
                row.createCell(8).setCellValue(rs.getString("metode_pembayaran"));
            }
        }

        FileOutputStream out = new FileOutputStream("Data_Gym.xlsx");
        workbook.write(out);
        out.close();

        JOptionPane.showMessageDialog(null, "Data berhasil diekspor ke Excel!");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal ekspor: " + e.getMessage());
    }
}

    
    private void tampilData() {
    try {
        Connection con = DBConnection.connect();
        String sql = "SELECT * FROM gymdb";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = (DefaultTableModel) tbldatagym.getModel();
        model.setRowCount(0); // hapus data lama

        while (rs.next()) {
            Object[] row = {
                rs.getString("id"),                // tambahkan kolom ID
                rs.getString("nama"),
                rs.getString("email"),
                rs.getString("no_hp"),
                rs.getString("tipe_member"),
                rs.getString("trainer"),
                rs.getDouble("harga"),
                rs.getInt("masa_aktif"),
                rs.getString("metode_pembayaran")
            };
            model.addRow(row);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal tampil data: " + e.getMessage());
    }
}

    

    private void resetForm() {
    tfNama.setText("");
    tfEmail.setText("");
    tfNoHP.setText("");
    tfHarga.setText("");
    tfBukti.setText("");
    detail.setText("");

    rbBulanan.setSelected(true); // Default: Bulanan
    cbTrainer.setSelectedIndex(0); // Asumsi index 0 = "-- Pilih Trainer --"
    spAktif.setValue(1); // Reset spinner ke 1 bulan/tahun
    sbRating.setValue(5); // Nilai default rating

    cbCash.setSelected(false);
    cbBca.setSelected(false);
    cbMandiri.setSelected(false);
    cbBri.setSelected(false);

    listJenisLatihan.clearSelection(); // Reset list latihan

    // Kembali ke tab pertama (opsional)
    jTabbedPane1.setSelectedIndex(0);
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GymForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GymForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GymForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GymForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GymForm().setVisible(true);
            }
        });

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnupload;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cbBca;
    private javax.swing.JCheckBox cbBri;
    private javax.swing.JCheckBox cbCash;
    private javax.swing.JCheckBox cbMandiri;
    private javax.swing.JComboBox<String> cbTrainer;
    private javax.swing.JTextArea detail;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JList<String> listJenisLatihan;
    private javax.swing.JRadioButton rbBulanan;
    private javax.swing.JRadioButton rbTahunan;
    private javax.swing.JButton resetForm;
    private javax.swing.JScrollBar sbRating;
    private javax.swing.JSpinner spAktif;
    private javax.swing.JTextArea taKeterangan;
    private javax.swing.JTable tbldatagym;
    private javax.swing.JTextField tfBukti;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNoHP;
    private javax.swing.JTextField tfRating;
    // End of variables declaration//GEN-END:variables

  


}

