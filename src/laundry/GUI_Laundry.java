/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;

public class GUI_Laundry extends javax.swing.JFrame {
    DefaultTableModel tabModel;
    ResultSet RsProduk=null;
    
    public int harga,berat,ttlbyr;
    
    public GUI_Laundry() {
        initComponents();
        setVisible(true);
        tgl();
        setExtendedState(MAXIMIZED_BOTH);
        tampilData();
    }
    private void tgl () {
        Date ys = new Date ();
        SimpleDateFormat s= new SimpleDateFormat ("yyyy-MM-dd");
        txttgl.setText(s.format(ys));
    }
    
    public void kosong (){
        txtberat.setText("");
        txtharga.setText("");
        txtnotelp.setText("");
        txtttlbyr.setText("");
        txtkodepel.setText("");
        txtNamapel.setText("");
        Taalamat.setText("");
        txtkodepel.requestFocus();
    }
    
    void tblKeForm(){
        txttgl.setText(tabModel.getValueAt(Tabellaundry.getSelectedRow(),0)+"");
        txtkodepel.setText(tabModel.getValueAt(Tabellaundry.getSelectedRow(),1)+"");
        txtNamapel.setText(tabModel.getValueAt(Tabellaundry.getSelectedRow(),2)+"");
        txtnotelp.setText(tabModel.getValueAt(Tabellaundry.getSelectedRow(),3)+"");
        Taalamat.setText(tabModel.getValueAt(Tabellaundry.getSelectedRow(),4)+"");
        txtberat.setText(tabModel.getValueAt(Tabellaundry.getSelectedRow(),5)+"");
        txtharga.setText(tabModel.getValueAt(Tabellaundry.getSelectedRow(),6)+"");
        txtttlbyr.setText(tabModel.getValueAt(Tabellaundry.getSelectedRow(),7)+"");      
        
       
    } 
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Tanggal", "Kode Pelanggan", "Nama Pelanggan", "No Telepon", "Alamat", "Berat Pakaian","Harga", "Total Bayar"};
            tabModel =new DefaultTableModel(null,judul_kolom);
            Tabellaundry.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
                        RsProduk=stt.executeQuery("SELECT * from transaksi ");  
            while(RsProduk.next()){
                Object[] data={
                    RsProduk.getString("Tanggal"),
                    RsProduk.getString("Kode_pelanggan"),
                    RsProduk.getString("Nama_pelanggan"),
                    RsProduk.getString("No_telp"),
                    RsProduk.getString("Alamat"),
                    RsProduk.getString("Berat_Pakaian"),
                    RsProduk.getString("Harga"),
                    RsProduk.getString("Total_bayar"),
                    
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
       
        
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttgl = new javax.swing.JTextField();
        txtkodepel = new javax.swing.JTextField();
        txtNamapel = new javax.swing.JTextField();
        txtnotelp = new javax.swing.JTextField();
        txtberat = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtttlbyr = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Taalamat = new javax.swing.JTextArea();
        btnsimpan = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabellaundry = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tanggal");

        jLabel2.setText("Kode Pelanggan");

        jLabel3.setText("Nama Pelanggan");

        jLabel4.setText("No Telp");

        jLabel5.setText("Alamat");

        jLabel6.setText("Harga /kg");

        jLabel7.setText("Berat Pakaian (kg)");

        jLabel8.setText("Total Bayar");

        txtberat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtberatActionPerformed(evt);
            }
        });

        txtharga.setEnabled(false);

        txtttlbyr.setEnabled(false);

        Taalamat.setColumns(20);
        Taalamat.setRows(5);
        jScrollPane1.setViewportView(Taalamat);

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnhapus.setText("Delete");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        Tabellaundry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tabellaundry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabellaundryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabellaundry);

        jLabel9.setFont(new java.awt.Font("Calibri", 2, 24)); // NOI18N
        jLabel9.setText("TRANSAKSI LAUNDRY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnotelp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtkodepel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNamapel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtttlbyr, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsimpan)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapus)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtberat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtkodepel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(txtNamapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtttlbyr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtnotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsimpan)
                            .addComponent(btnupdate)
                            .addComponent(btnhapus)
                            .addComponent(jButton2))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        String Tanggal=txttgl.getText();
        String nama=txtNamapel.getText();
        String kode=txtkodepel.getText();
        String alamat=Taalamat.getText();
        String total=txtttlbyr.getText();
        String telepon=txtnotelp.getText();
        String harga=txtharga.getText();
        String berat=txtberat.getText();

         if (Tanggal.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Tanggal tidak boleh kosong");
            txttgl.requestFocus();
        }else if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama pelanggan tidak boleh kosong");
            txtNamapel.requestFocus();
        }else if (kode.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Kode Pelanggan tidak boleh kosong");
            txtkodepel.requestFocus();
        }else if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh kosong");
            Taalamat.requestFocus();
        }else if (berat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Berat tidak boleh kosong");
            txtberat.requestFocus();
        }else if (telepon.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nomor telepon tidak boleh kosong");
            txtberat.requestFocus();
        }else if (!(new Scanner(harga).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga harus angka");
            txtharga.requestFocus();
        }else if (!(new Scanner(berat).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Berat harus angka");
            txtberat.requestFocus();
        }else if (!(new Scanner(telepon).hasNextInt())) {
            JOptionPane.showMessageDialog(null," Nomor telepon harus angka");
            txtnotelp.requestFocus();
        }else if (!(new Scanner(total).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Total bayar harus angka");
            txtttlbyr.requestFocus();
        
        }else{
            try{
                Connection conn=(Connection)Koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into transaksi(Tanggal,Kode_Pelanggan, Nama_Pelanggan, No_Telp, Alamat, Berat_Pakaian, Harga, Total_Bayar)"+
                    "VALUES('"+Tanggal+"','"+nama+"','"+kode+"','"+telepon+"','"+alamat+"','"+berat+"','"+harga+"','"+total+"')");
                kosong();
                tampilData();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
  // TODO add your handling code here:
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void txtberatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtberatActionPerformed
        berat = Integer.parseInt(txtberat.getText());
        harga=6000;
        ttlbyr=berat*6000;
        txtttlbyr.setText(String.valueOf (ttlbyr));
        txtharga.setText(String.valueOf(harga));// TODO add your handling code here:
    }//GEN-LAST:event_txtberatActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
       String Tanggal=txttgl.getText();
        String nama=txtNamapel.getText();
        String kode=txtkodepel.getText();
        String alamat=Taalamat.getText();
        String total=txtttlbyr.getText();
        String telepon=txtnotelp.getText();
        String harga=txtharga.getText();
        String berat=txtberat.getText();

         if (Tanggal.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Tanggal tidak boleh kosong");
            txttgl.requestFocus();
        }else if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama pelanggan tidak boleh kosong");
            txtNamapel.requestFocus();
        }else if (kode.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Kode Pelanggan tidak boleh kosong");
            txtkodepel.requestFocus();
        }else if (alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Alamat tidak boleh kosong");
            Taalamat.requestFocus();
        }else if (!(new Scanner(harga).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Harga harus angka");
            txtharga.requestFocus();
        }else if (!(new Scanner(berat).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Berat harus angka");
            txtberat.requestFocus();
        }else if (!(new Scanner(total).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Total bayar harus angka");
            txtttlbyr.requestFocus();
        }else if (harga.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga tidak boleh kosong");
            txtharga.requestFocus();
        }else if (berat.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Berat tidak boleh kosong");
            txtberat.requestFocus();
        }else if (total.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Total Bayar tidak boleh kosong");
            txtttlbyr.requestFocus();
        }else if (telepon.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No telepon tidak boleh kosong");
            txtnotelp.requestFocus();
       
        }else{
            try{
                Connection conn=(Connection)Koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE transaksi SET Tanggal='"+Tanggal+"', Nama_Pelanggan='"+nama+"', No_Telp='"+telepon+"',"+
                    "Alamat='"+alamat+"',"+ "Berat_Pakaian='"+berat+"',"+
                    "Harga='"+harga+"',"+ "Total_bayar='"+total+"' WHERE Kode_Pelanggan='"+kode+"'");
                kosong();
                tampilData();
                JOptionPane.showMessageDialog(this,"UPDATE Data berhasil","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"UPDATE data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }  // TODO add your handling code here:
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
     String kode=txtkodepel.getText();

        if (kode.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Kode tidak boleh kosong");
            txtkodepel.requestFocus();
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM transaksi WHERE Kode_Pelanggan='"+kode+"'");
            tampilData();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusActionPerformed

    private void TabellaundryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabellaundryMouseClicked
        tblKeForm();         // TODO add your handling code here:
    }//GEN-LAST:event_TabellaundryMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
kosong();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Taalamat;
    private javax.swing.JTable Tabellaundry;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtNamapel;
    private javax.swing.JTextField txtberat;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtkodepel;
    private javax.swing.JTextField txtnotelp;
    private javax.swing.JTextField txttgl;
    private javax.swing.JTextField txtttlbyr;
    // End of variables declaration//GEN-END:variables
}
