package jframe;

import service.QuerySqlServer;

public class TelaLogin extends javax.swing.JFrame {
    
    private QuerySqlServer mssql;

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
        incorreto.setVisible(false);
        mssql = new QuerySqlServer();
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        fundo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        inSenha = new javax.swing.JTextField();
        inEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        verificarLogin = new javax.swing.JButton();
        incorreto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setUndecorated(true);

        fundo.setBackground(new java.awt.Color(51, 51, 51));
        fundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(39, 39, 39));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inSenha.setBackground(new java.awt.Color(28, 28, 28));
        inSenha.setForeground(new java.awt.Color(255, 255, 255));
        inSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        inSenha.setCaretColor(new java.awt.Color(204, 204, 204));
        inSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inSenhaActionPerformed(evt);
            }
        });
        jPanel2.add(inSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 220, 40));

        inEmail.setBackground(new java.awt.Color(28, 28, 28));
        inEmail.setForeground(new java.awt.Color(255, 255, 255));
        inEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inEmail.setToolTipText("");
        inEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        inEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        inEmail.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        inEmail.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        inEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inEmailActionPerformed(evt);
            }
        });
        jPanel2.add(inEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 220, 40));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Senha");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 262, -1, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Email");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 158, -1, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Tech");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, 36));

        verificarLogin.setBackground(new java.awt.Color(0, 51, 255));
        verificarLogin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        verificarLogin.setForeground(new java.awt.Color(255, 255, 255));
        verificarLogin.setText("Entrar");
        verificarLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        verificarLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        verificarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarLoginActionPerformed(evt);
            }
        });
        jPanel2.add(verificarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 150, 38));

        incorreto.setDisplayedMnemonic('\u0011');
        incorreto.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        incorreto.setForeground(new java.awt.Color(255, 0, 0));
        incorreto.setText("*Credenciais incorretas!");
        jPanel2.add(incorreto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 130, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Auto");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, 36));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/back1.jpg"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1620, -140, 2180, 970));

        fundo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, -40, 550, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inEmailActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_inEmailActionPerformed

    private void inSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inSenhaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_inSenhaActionPerformed
    
    private void verificarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarLoginActionPerformed
        // TODO add your handling code here:
        String u_email = String.valueOf(inEmail.getText());
        String u_senha = String.valueOf(inSenha.getText());
        Boolean loginConfirmado = mssql.verificarLogin(u_email, u_senha);
        
        if(loginConfirmado){
            CapturaDeDados capturaDeDados = new CapturaDeDados(mssql.getUser());
            capturaDeDados.setVisible(true);
            this.setVisible(false);
        }else{
            incorreto.setVisible(true);
        }
        
    }//GEN-LAST:event_verificarLoginActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fundo;
    private javax.swing.JTextField inEmail;
    private javax.swing.JTextField inSenha;
    private javax.swing.JLabel incorreto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton verificarLogin;
    // End of variables declaration//GEN-END:variables
}
