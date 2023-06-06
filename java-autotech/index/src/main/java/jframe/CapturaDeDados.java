package jframe;

import java.util.Timer;
import java.util.TimerTask;
import service.QueryMySql;
import model.GestaoAcesso;
import util.Log;
import util.LogLevel;
import api.LoocaApi;
import api.SlackApi;
import service.QuerySqlServer;

public class CapturaDeDados extends javax.swing.JFrame {

    private GestaoAcesso user;
    private final QuerySqlServer mssql = new QuerySqlServer();
    private final LoocaApi loocaApi = new LoocaApi();
    private final QueryMySql mysql = new QueryMySql();
    private Boolean primeiraVez = false;

    public CapturaDeDados(GestaoAcesso user) {
        initComponents();
        setLocationRelativeTo(null);
        this.user = user;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 34, -1, 177));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 309, -1, -1));

        btnIniciar.setBackground(new java.awt.Color(0, 102, 255));
        btnIniciar.setFont(new java.awt.Font("Liberation Sans", 1, 21)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Start");
        btnIniciar.setActionCommand("Start");
        btnIniciar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        btnIniciar.setBorderPainted(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 252, 48));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jframe/back1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1060, -1250, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 317, 101));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mssql.setUser(this.user);
        mssql.getInfoComponentes();
    }//GEN-LAST:event_formWindowOpened
    
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        Log log = new Log();
        log.makeLog(LogLevel.START, "Autotech Log");
        log.makeLog(LogLevel.INFO, "\n" + loocaApi.getSistemaInfo());
        
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("salve meu mano");
                
                try{
                    Double download = loocaApi.getDownload();
                    Double upload = loocaApi.getUpload();
                    System.out.println("nem to usando essa parte kkkkkk");
                    mssql.setRegistrosRede((download * 10)/10, (upload * 10)/10);
                }catch(InterruptedException e){
                    log.makeLog(LogLevel.ERROR, e.toString());
                }
                mssql.setRegistros(loocaApi.getCpu(), loocaApi.getMemoria(), loocaApi.getDisco());
                mysql.setRegistro(mssql.getC1().getIdComponente(), mssql.getC2().getIdComponente(), mssql.getC3().getIdComponente(), mssql.getC1().getFkHardware(),
                        mssql.getC1().getFkUnidade(), mssql.getC1().getFkCliente(), mssql.getC1().getFkModeloComponente(), mssql.getC2().getFkModeloComponente(), mssql.getC3().getFkModeloComponente(),
                        loocaApi.getCpu(), loocaApi.getMemoria(), loocaApi.getDisco());
                
                if(loocaApi.getMemoria() > 30 && !primeiraVez){
                    new Alert().setVisible(true);
                    primeiraVez = true;
                }
                
                SlackApi.verificarOcorrencia(loocaApi.getCpu(), loocaApi.getMemoria(), loocaApi.getDisco(), log);
    
            }
        }, 0, 5000);
    }//GEN-LAST:event_btnIniciarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InitCarregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
