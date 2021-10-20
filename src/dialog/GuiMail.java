package dialog;

public class GuiMail extends javax.swing.JDialog {

    public GuiMail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        txtNguoiGui.setEditable(false);
        txtMatKhau.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCoverDialog2 = new component.PanelCoverDialog();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtTieuDe = new swing.TextInput();
        txtNguoiGui = new swing.TextInput();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNguoiNhan = new swing.TextInput();
        jLabel7 = new javax.swing.JLabel();
        txtCC = new swing.TextInput();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaNoiDung = new javax.swing.JTextArea();
        btnGuiMail = new swing.ButtonOutLine();
        btnChonFile = new swing.ButtonOutLine();
        txtMatKhau = new swing.PassInput();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GỬI MAIL");
        panelCoverDialog2.add(jLabel2);
        jLabel2.setBounds(4, 4, 310, 30);
        panelCoverDialog2.add(jSeparator1);
        jSeparator1.setBounds(0, 40, 320, 10);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setText("Nội dung");
        panelCoverDialog2.add(jLabel3);
        jLabel3.setBounds(10, 260, 70, 30);
        panelCoverDialog2.add(txtTieuDe);
        txtTieuDe.setBounds(90, 220, 220, 29);

        txtNguoiGui.setText("sikienbmto1@gmail.com");
        panelCoverDialog2.add(txtNguoiGui);
        txtNguoiGui.setBounds(90, 60, 220, 29);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Người gửi");
        panelCoverDialog2.add(jLabel4);
        jLabel4.setBounds(10, 60, 70, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Mật khẩu");
        panelCoverDialog2.add(jLabel5);
        jLabel5.setBounds(10, 100, 70, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Người nhận");
        panelCoverDialog2.add(jLabel6);
        jLabel6.setBounds(10, 140, 70, 30);
        panelCoverDialog2.add(txtNguoiNhan);
        txtNguoiNhan.setBounds(90, 140, 220, 29);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("File");
        panelCoverDialog2.add(jLabel7);
        jLabel7.setBounds(10, 180, 70, 30);
        panelCoverDialog2.add(txtCC);
        txtCC.setBounds(90, 180, 160, 29);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Tiêu đề");
        panelCoverDialog2.add(jLabel8);
        jLabel8.setBounds(10, 220, 70, 30);

        jtaNoiDung.setColumns(20);
        jtaNoiDung.setRows(5);
        jScrollPane1.setViewportView(jtaNoiDung);

        panelCoverDialog2.add(jScrollPane1);
        jScrollPane1.setBounds(90, 270, 220, 110);

        btnGuiMail.setText("Gửi");
        panelCoverDialog2.add(btnGuiMail);
        btnGuiMail.setBounds(230, 390, 75, 30);

        btnChonFile.setBackground(new java.awt.Color(255, 255, 0));
        btnChonFile.setText("File");
        panelCoverDialog2.add(btnChonFile);
        btnChonFile.setBounds(260, 180, 50, 30);

        txtMatKhau.setText("01263500");
        panelCoverDialog2.add(txtMatKhau);
        txtMatKhau.setBounds(90, 100, 220, 29);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCoverDialog2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCoverDialog2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public swing.ButtonOutLine btnChonFile;
    public swing.ButtonOutLine btnGuiMail;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextArea jtaNoiDung;
    private component.PanelCoverDialog panelCoverDialog2;
    public swing.TextInput txtCC;
    public swing.PassInput txtMatKhau;
    public swing.TextInput txtNguoiGui;
    public swing.TextInput txtNguoiNhan;
    public swing.TextInput txtTieuDe;
    // End of variables declaration//GEN-END:variables
}
