package ec.edu.monster.vista;

import ec.edu.monster.controlador.ConversionControlador;

public class ConversionVista extends javax.swing.JFrame {

    private ConversionControlador conversionControlador;

    public ConversionVista() {
        initComponents();
        this.conversionControlador = new ConversionControlador();

        // Cargar unidades en ComboBox
        String[] unidades = {
            "m","cm","km","in","ft",
            "kg","g","lb","oz","t",
            "C","F","K","R"
        };

        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();

        for (String u : unidades) {
            jComboBox1.addItem(u);
            jComboBox2.addItem(u);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Centtxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Pulgtext = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BtnPulg = new javax.swing.JButton();
        BtnCent = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/gr02/recursos/2b800d65ab8fc20f88548fb7d39f223c (1).png")));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22));
        jLabel2.setText("CONVERSION DE UNIDADES");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel3.setText("Valor:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel4.setText("Destino:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel5.setText("Resultado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel6.setText("Resultado:");

        BtnPulg.setText("Convertir");
        BtnPulg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPulgActionPerformed(evt);
            }
        });

        BtnCent.setText("Convertir");
        BtnCent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCentActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20)
                        .addComponent(Centtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnCent)
                    .addComponent(jLabel5))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
                .addGap(40)
                .addComponent(jLabel2)
                .addGap(40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Centtxt))
                .addGap(20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1)
                    .addComponent(jComboBox2))
                .addGap(20)
                .addComponent(BtnCent)
                .addGap(20)
                .addComponent(jLabel5)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel1)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addComponent(jPanel1)
        );

        pack();
    }

    private void BtnCentActionPerformed(java.awt.event.ActionEvent evt) {

        String valorTxt = Centtxt.getText();

        if (valorTxt.isEmpty()) {
            jLabel5.setText("⚠ Ingrese un valor");
            return;
        }

        double valor;

        try {
            valor = Double.parseDouble(valorTxt);
        } catch (Exception e) {
            jLabel5.setText("⚠ Debe ser número");
            return;
        }

        String origen = jComboBox1.getSelectedItem().toString();
        String destino = jComboBox2.getSelectedItem().toString();

        String resultado = conversionControlador.convertir(valor, origen, destino);

        jLabel5.setText("Resultado: " + resultado);
    }

    private void BtnPulgActionPerformed(java.awt.event.ActionEvent evt) {
        // NO USAR
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ConversionVista().setVisible(true);
        });
    }

    private javax.swing.JButton BtnCent;
    private javax.swing.JButton BtnPulg;
    private javax.swing.JTextField Centtxt;
    private javax.swing.JTextField Pulgtext;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
}