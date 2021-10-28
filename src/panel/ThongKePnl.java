package panel;

import DAO.ThongKeDAO;
import chart.ModelChart;
import controller.ThongKeController;
import helper.ChuyenDoi;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import swing.ScrollBar;

public class ThongKePnl extends javax.swing.JPanel {

    ThongKeController thongKeController;
    ThongKeDAO tkdao = new ThongKeDAO();
    
    public ThongKePnl() {
        initComponents();
        spTable2.setVerticalScrollBar(new ScrollBar());
        spTable2.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable2.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable2.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        chart1.addLegend("Tiền phòng", new Color(245, 189, 135));
        chart1.addLegend("Dịch vụ", new Color(135, 189, 245));
        chart1.addLegend("Phụ thu", new Color(189, 135, 245));
        lblTienDichVu.setEditable(false);
        lblTienPhong.setEditable(false);
        lblTienPhuThu.setEditable(false);
        lblTongTien.setEditable(false);
        txtTu.setText("Chọn ngày bắt đầu");
        txtTu.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTu.getText().equals("Chọn ngày bắt đầu")) {
                    txtTu.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtTu.getText().isEmpty()) {
                    txtTu.setText("Chọn ngày bắt đầu");
                }
            }
        }); 
        
        txtDen.setText("Chọn ngày kết thúc");
        txtDen.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtDen.getText().equals("Chọn ngày kết thúc")) {
                    txtDen.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtDen.getText().isEmpty()) {
                    txtDen.setText("Chọn ngày kết thúc");
                }
            }
        });
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser3 = new com.raven.datechooser.DateChooser();
        jLabel1 = new javax.swing.JLabel();
        chart1 = new chart.Chart();
        spTable2 = new javax.swing.JScrollPane();
        tblThongKe = new swing.Table();
        jPanel2 = new javax.swing.JPanel();
        panelCoverDialog1 = new component.PanelCoverDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTongTien = new swing.TextInput();
        lblTienPhuThu = new swing.TextInput();
        lblTienDichVu = new swing.TextInput();
        lblTienPhong = new swing.TextInput();
        jLabel9 = new javax.swing.JLabel();
        lblJlb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTuNgay = new javax.swing.JLabel();
        lblDenNgay = new javax.swing.JLabel();
        txtTu = new swing.TextInput();
        txtDen = new swing.TextInput();
        btnThongKe = new swing.ButtonOutLine();

        dateChooser2.setTextRefernce(txtDen);

        dateChooser3.setTextRefernce(txtTu);

        setBackground(new java.awt.Color(242, 246, 253));
        setPreferredSize(new java.awt.Dimension(1230, 750));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(140, 110, 207));
        jLabel1.setText("THỐNG KÊ DOANH THU");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        spTable2.setBorder(null);

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Phòng", "Nhân viên", "Ngày trả phòng", "Tiền phòng", "Dịch vụ", "Phụ thu", "Tổng tiền"
            }
        ));
        spTable2.setViewportView(tblThongKe);
        if (tblThongKe.getColumnModel().getColumnCount() > 0) {
            tblThongKe.getColumnModel().getColumn(0).setMinWidth(40);
            tblThongKe.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblThongKe.getColumnModel().getColumn(0).setMaxWidth(40);
            tblThongKe.getColumnModel().getColumn(1).setMinWidth(70);
            tblThongKe.getColumnModel().getColumn(1).setPreferredWidth(70);
            tblThongKe.getColumnModel().getColumn(1).setMaxWidth(70);
            tblThongKe.getColumnModel().getColumn(2).setMinWidth(70);
            tblThongKe.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblThongKe.getColumnModel().getColumn(2).setMaxWidth(70);
            tblThongKe.getColumnModel().getColumn(3).setMinWidth(100);
            tblThongKe.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblThongKe.getColumnModel().getColumn(3).setMaxWidth(100);
            tblThongKe.getColumnModel().getColumn(6).setMinWidth(60);
            tblThongKe.getColumnModel().getColumn(6).setPreferredWidth(60);
            tblThongKe.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tổng tiền phụ thu");
        panelCoverDialog1.add(jLabel6);
        jLabel6.setBounds(10, 130, 120, 32);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tổng tiền phòng");
        panelCoverDialog1.add(jLabel8);
        jLabel8.setBounds(350, 80, 110, 32);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tổng doanh thu");
        panelCoverDialog1.add(jLabel7);
        jLabel7.setBounds(350, 130, 110, 32);

        lblTongTien.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblTongTien.setText("0");
        panelCoverDialog1.add(lblTongTien);
        lblTongTien.setBounds(470, 130, 160, 35);

        lblTienPhuThu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblTienPhuThu.setText("0");
        panelCoverDialog1.add(lblTienPhuThu);
        lblTienPhuThu.setBounds(140, 130, 160, 35);

        lblTienDichVu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblTienDichVu.setText("0");
        panelCoverDialog1.add(lblTienDichVu);
        lblTienDichVu.setBounds(140, 80, 160, 35);

        lblTienPhong.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lblTienPhong.setText("0");
        panelCoverDialog1.add(lblTienPhong);
        lblTienPhong.setBounds(470, 80, 160, 35);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tổng tiền dịch vụ");
        panelCoverDialog1.add(jLabel9);
        jLabel9.setBounds(10, 80, 120, 32);

        lblJlb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblJlb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJlb.setText("-");
        panelCoverDialog1.add(lblJlb);
        lblJlb.setBounds(310, 40, 40, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DOANH THU");
        panelCoverDialog1.add(jLabel4);
        jLabel4.setBounds(250, 0, 170, 30);

        lblTuNgay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTuNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelCoverDialog1.add(lblTuNgay);
        lblTuNgay.setBounds(170, 40, 120, 20);

        lblDenNgay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDenNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelCoverDialog1.add(lblDenNgay);
        lblDenNgay.setBounds(370, 40, 120, 20);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );

        btnThongKe.setBackground(new java.awt.Color(255, 0, 0));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/analytics.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTu, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spTable2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDen, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spTable2, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        String date1 = txtTu.getText();
        String date2 = txtDen.getText();
        LocalDate d1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate d2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String dst1 = d1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String dst2 = d2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        lblTuNgay.setText(date1);
        lblDenNgay.setText(date2);
        
        tableAfterView(dst1, dst2);
        bieuDo(dst1, dst2);       
    }//GEN-LAST:event_btnThongKeActionPerformed
    public void setTime(List<Object[]> data) {
        for (int i = 0; i <= data.size()-1; i++) {
            lblTuNgay.setText(data.get(0)[8].toString());
            lblDenNgay.setText(data.get(0)[9].toString());
        }
    }
    
    public void tableAfterView(String dst1, String dst2) {
        List<Object[]> table = thongKeController.thongKeTheoKhoang(dst1, dst2);
        viewTableThongKe(table);
        
        Double tienPhong = 0.0,tienDichVu=0.0 ,phuThu=0.0 ,Tong=0.0;        
        for(int i=0 ;i<=table.size()-1;i++){
            tienPhong+=ChuyenDoi.SoDouble(table.get(i)[4].toString());
            tienDichVu+=ChuyenDoi.SoDouble(table.get(i)[5].toString());
            phuThu+=ChuyenDoi.SoDouble(table.get(i)[6].toString());
            Tong+=ChuyenDoi.SoDouble(table.get(i)[7].toString());
        }
        setValueSum(tienPhong, tienDichVu, phuThu, Tong);
    }
    
    public void bieuDoDefault(List<Object[]> data) {
        chart1.clear();
        for (int i = 0; i <= data.size()-1; i++) {
            Double tienGio = Double.parseDouble(data.get(i)[1].toString());
            Double dichVu = Double.parseDouble(data.get(i)[2].toString());
            Double phuThu1 = Double.parseDouble(data.get(i)[3].toString());  
            chart1.addData(new ModelChart(data.get(i)[0].toString()+"/"+data.get(i)[4].toString(),new double[]{tienGio,dichVu,phuThu1}));
        }
        chart1.start();
    }
    
    public void bieuDo(String dst1, String dst2) {
        chart1.clear();
        List<Object[]> data = thongKeController.thongKeBieuDo(dst1, dst2);       
        for (int i = 0; i <= data.size()-1; i++) {
            Double tienGio = Double.parseDouble(data.get(i)[1].toString());
            Double dichVu = Double.parseDouble(data.get(i)[2].toString());
            Double phuThu1 = Double.parseDouble(data.get(i)[3].toString());  
            chart1.addData(new ModelChart(data.get(i)[0].toString()+"/"+data.get(i)[4].toString(),new double[]{tienGio,dichVu,phuThu1}));
        }   
        chart1.start();
    }
    
    public void setGiaDefault(List<Object[]> data) {
        Double tienPhong = 0.0,tienDichVu=0.0 ,phuThu=0.0 ,Tong=0.0;        
        for(int i=0 ;i<=data.size()-1;i++){
            tienPhong+=ChuyenDoi.SoDouble(data.get(i)[4].toString());
            tienDichVu+=ChuyenDoi.SoDouble(data.get(i)[5].toString());
            phuThu+=ChuyenDoi.SoDouble(data.get(i)[6].toString());
            Tong+=ChuyenDoi.SoDouble(data.get(i)[7].toString());
        }
        setValueSum(tienPhong, tienDichVu, phuThu, Tong);
    }
    
    public void viewTableThongKe(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblThongKe.getModel();   
        if(data == null) {
            for (int i = tblThongKe.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }
        }else {
            for (int i = tblThongKe.getRowCount()-1; i >= 0; i--) {
                model.removeRow(i);
            }      
            for (Object[] objects : data) {
                model.addRow(objects);
            }            
        }       
    }
    
    public void setController (ThongKeController thongKeController) {
        this.thongKeController = thongKeController;
    } 
    
    public void setValueSum(Double phong , Double dichVu ,Double phuThu, Double tong){
        lblTienPhong.setText(ChuyenDoi.SoString(phong));
        lblTienDichVu.setText(ChuyenDoi.SoString(dichVu));
        lblTienPhuThu.setText(ChuyenDoi.SoString(phuThu));
        lblTongTien.setText(ChuyenDoi.SoString(tong));
    }           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonOutLine btnThongKe;
    private chart.Chart chart1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private com.raven.datechooser.DateChooser dateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblJlb;
    private swing.TextInput lblTienDichVu;
    private swing.TextInput lblTienPhong;
    private swing.TextInput lblTienPhuThu;
    private swing.TextInput lblTongTien;
    private javax.swing.JLabel lblTuNgay;
    private component.PanelCoverDialog panelCoverDialog1;
    private javax.swing.JScrollPane spTable2;
    private swing.Table tblThongKe;
    private swing.TextInput txtDen;
    private swing.TextInput txtTu;
    // End of variables declaration//GEN-END:variables
}
