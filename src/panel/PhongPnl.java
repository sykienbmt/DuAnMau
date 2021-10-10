package panel;

import component.PhongBtn;
import controller.DichVuController;
import controller.PhongController;
import dialog.DatPhongDialog;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import model.LoaiPhong;
import model.Phong;
import swing.ScrollBar;
import swing.WrapLayout;

public class PhongPnl extends javax.swing.JPanel {
    private DichVuController dichVuController;
    private PhongController phongController;
    private DatPhongDialog datPhongDialog = null;
    
    public PhongPnl() {
        initComponents();
        init();
        //css table phong
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        //css table dich vu
        spTable1.setVerticalScrollBar(new ScrollBar());
        spTable1.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable1.getViewport().setBackground(Color.WHITE);
        spTable1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }

    private void init() {
        panel.setLayout(new WrapLayout(WrapLayout.LEADING));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());    
        panel.revalidate();
        panel.repaint();
    }
    
    public void viewTablePhong(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblPhong.getModel();      
        for (int i = tblPhong.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }      
        for (Object[] objects : data) {
            model.addRow(objects);
        }
    }
    
    public void viewBtnPhong(List<Phong> data) {
        for (Phong phong : data) {
            Button btnphong = new Button(phong.toString());           
            btnphong.setPreferredSize(new Dimension(95,60));
            btnphong.setFont(new java.awt.Font("Segoe UI Light", 1, 12));
            btnphong.setForeground(new java.awt.Color(255,255,255));
            if (phong.getTrangThai().equals("Đang sử dụng")) {
                btnphong.setBackground(new Color(255,51,0));
            }else if (phong.getTrangThai().equals("Phòng trống")) {
                btnphong.setBackground(new Color(0,204,204));
            }else {
                btnphong.setBackground(new Color(102,102,102));
            }
            
            btnphong.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (datPhongDialog == null) {
                        datPhongDialog = new DatPhongDialog(null,true);
                        datPhongDialog.txtTenPhong.setEditable(false);
                        datPhongDialog.cbxLoaiPhong.setEnabled(false);
                        
                        if(btnphong.getActionCommand().equals(phong.getTenPhong()) ) {
                                datPhongDialog.txtTenPhong.setText(phong.getTenPhong());
                                datPhongDialog.txtSoKhach.setText(phong.getSoKhachMax());
                                datPhongDialog.jdcNgayDat.setDate(phong.getNgayDat());
                            if(phong.getTrangThai().equals("Bảo trì")){
                                datPhongDialog.rdbBaoTri.setSelected(true);
                            }else if(phong.getTrangThai().equals("Phòng trống")){
                                datPhongDialog.rdbPhongTrong.setSelected(true);
                            }else datPhongDialog.rdbSuDung.setSelected(true);
                        }
                        
                        datPhongDialog.btnDatPhong.addActionListener(new AbstractAction(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int clickThem = JOptionPane.showConfirmDialog(new Frame(),"Bạn có muốn đặt không ?", "Thông báo",JOptionPane.YES_NO_OPTION);
                                if (clickThem == JOptionPane.YES_OPTION) {
                                    String tenPhong = datPhongDialog.txtTenPhong.getText();
                                    LoaiPhong loaiPhong =(LoaiPhong) datPhongDialog.cbxLoaiPhong.getSelectedItem();
                                    Integer tenLoaiPhong = loaiPhong.getIdLoaiPhong();
                                    String soKhach = datPhongDialog.txtSoKhach.getText(); 
                                    java.util.Date ngayDat1 = datPhongDialog.jdcNgayDat.getDate();
                                    java.sql.Date ngayDat= new java.sql.Date(ngayDat1.getTime());
                                    String trangThai = null;
                                    if(datPhongDialog.rdbBaoTri.isSelected()){
                                        trangThai="Bảo trì";
                                    }else if(datPhongDialog.rdbPhongTrong.isSelected()){
                                        trangThai = "Phòng trống";
                                    }else trangThai = "Sử dụng";

//                                    Integer idPhong = (Integer) btnphong.;
//                                    phongController.update(idPhong, tenLoaiPhong, tenPhong, soKhach, ngayDat, trangThai);
                                    datPhongDialog.setVisible(false);
                                }
                            }
                        });
                    }
                    DefaultComboBoxModel <LoaiPhong> model = (DefaultComboBoxModel<LoaiPhong>) datPhongDialog.cbxLoaiPhong.getModel();
                    model.removeAllElements();
                    List<LoaiPhong> loaiPhongs = phongController.getLoaiPhong();
                    model.addAll(phongController.getLoaiPhong());
                    model.setSelectedItem(loaiPhongs.get(0));
                    datPhongDialog.setVisible(true);
                }                    
            });
            panel.add(btnphong);
        }
    }

    public void viewTableDichVu(List<Object[]> data) {
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();      
        for (int i = tblDichVu.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }      
        for (Object[] objects : data) {
            model.addRow(objects);
        }
    }
    
    public void setController (DichVuController dichVuController) {
        this.dichVuController = dichVuController;
    }
    
    public void setController (PhongController phongController) {
        this.phongController = phongController;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblPhong = new swing.Table();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        spTable1 = new javax.swing.JScrollPane();
        tblDichVu = new swing.Table();

        setBackground(new java.awt.Color(246, 248, 248));

        jScrollPane1.setBorder(null);

        panel.setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panel);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 153));
        jLabel1.setText("DANH SÁCH PHÒNG");

        spTable.setBorder(null);

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " STT", "Loại phòng", "Tên phòng", "Số khách", "Ngày đặt", "Trạng Thái"
            }
        ));
        spTable.setViewportView(tblPhong);
        if (tblPhong.getColumnModel().getColumnCount() > 0) {
            tblPhong.getColumnModel().getColumn(0).setMinWidth(45);
            tblPhong.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblPhong.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        jButton1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setText("Bảo trì");

        jButton2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setText("Phòng trống");

        jButton3.setBackground(new java.awt.Color(255, 51, 0));

        jLabel4.setText("Sử dụng");

        spTable1.setBorder(null);

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " STT", "Tên dịch vụ", "Tên phòng", "Giá", "Ngày Sử Dụng"
            }
        ));
        spTable1.setViewportView(tblDichVu);
        if (tblDichVu.getColumnModel().getColumnCount() > 0) {
            tblDichVu.getColumnModel().getColumn(0).setMinWidth(45);
            tblDichVu.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblDichVu.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                            .addComponent(spTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jButton3)
                        .addComponent(jLabel3)
                        .addComponent(jButton2)
                        .addComponent(jLabel2)
                        .addComponent(jButton1))
                    .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private swing.Table tblDichVu;
    private swing.Table tblPhong;
    // End of variables declaration//GEN-END:variables
}
