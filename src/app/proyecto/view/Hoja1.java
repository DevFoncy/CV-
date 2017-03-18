package app.proyecto.view;

import app.proyecto.model.*;
import app.proyecto.db.*;
import java.awt.Color;
import app.proyecto.view.*;
import java.util.Date;
import static app.proyecto.view.Hoja1.paises;
import static app.proyecto.view.Hoja3.cv1;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;


public class Hoja1 extends javax.swing.JFrame {
    AccesoDB conn = new AccesoDB();
    
    public static Postulante pos1 = new Postulante();
    Idioma id_in, id1, id2 = new Idioma();
    Detalle_Idioma detid_in, det_id1, det_id2 = new Detalle_Idioma();
    
    Colegio coleg = new Colegio();
    Detalle_EdEscolar ees = new Detalle_EdEscolar();
    public static String regPos,regId_in,
                   regId_1,regId_2,regDet_in,regDet_1,regDet_2,regDet_EdSup,regEdSup,regColegio,regEdEs;
    
    EdSuperior edsup = new EdSuperior();
    Detalle_EdSuperior det_edsup = new Detalle_EdSuperior();
    
    JComboBox jcb1,jcb2,jcb3,jcb4,jcb5,jcb6,jcb7;
    public static String[] paises={"Peru","Afganistan","Albania","Andorra","Afganistán",
"Antigua y Barbuda","Anguila","Angola","Antártida","Argentina","Samoa Americana",
"Austria","Australia","Aruba","Azerbaiyán","Bosnia-Herzegovina","Barbados","Bangladés",
"Bélgica","Burkina Faso","Bulgaria","Bahréin","Burundi","Benín","BL-San Bartolomé","Bermudas","Brunei",
"Bolivia","Brasil","Las Bahamas","Bután","Isla Bouvet","Botsuana","Bielorrusia","Belice","Canadá","Suiza","ci  –  Costa de Marfil","ck  –  Islas Cook","cl  –  Chile","cm  –  Camerún",
"China","Colombia","Costa Rica","Cuba","Cabo Verde","Curacao",
"Chipre","República Checa","Alemania","Yibuti","Dinamarca","Dominica","República Dominicana",
"Argelia","Ecuador","Estonia","Egipto","Eritrea","España","Etiopía","Finlandia",
"Fiyi","Islas Feroe","Francia","Gabón","Reino Unido","Granada","Georgia","Guayana Francesa","Guernsey","Ghana",
"Gibraltar","Groenlandia","Gambia","Guinea","Guadalupe","Grecia","Guatemala","Guam","Guinea-Bissau","Guyana","Hong Kong",
"Honduras","Croacia","Haití","Hungría" ,"Indonesia",
"Irlanda" ,"Israel" ,"Isla de Man","in–India",
"Iraq","Irán","Islandia","Italia","Jersey","Jamaica","Jordania","Japón","Kenia","Kirguistán","Camboya","ki–Kiribati",
"Comoras","Corea del Norte","Corea del Sur","Kuwait","Islas Caimán",
"Kazajistán","Laos","Líbano","Santa Lucía","Liechtenstein",
"Sri Lanka","Liberia","Lesoto","Lituania","Luxemburgo","Letonia","Libia",
"Marruecos" +"Mónaco","Moldovia","Montenegro","Saint Martin","Madagascar","Islas Marshall",
"Macedonia","Mali","Burma","Mongolia","Macao","Martinica","Mauritania",
"Montserrat","Malta","Mauricio","Maldivas","Malaui",
"México","Malasia","Mozambique","Namibia","Nueva Caledonia",
"Níger","Isla Norfolk","Nigeria","Nicaragua","Países Bajos","Noruega","Nepal","Nauru",
"Niue","Nueva Zelanda","Omán","Panamá","Filipinas","Pakistán",
"Polonia","Puerto Rico","Cisjordania","Portugal","Palaos",
"Paraguay","Qatar","Reunion","Rumania","Serbia","Rusia","Ruanda","Arabia Saudita","Islas Salomón",
"Seychelles","Sudán","Suecia","Singapur","Eslovenia","Svalbard","Eslovaquia","Sierra Leona","San Marino",
"Senegal","Somalia","Surinam","Sudán Sur","Santo Tomé y Príncipe","El Salvador","Sint Maarten",
"Siria","Suazilandia","Chad","Togo","Tailandia","Tokelau","Túnez","Tonga","Turquía",
"Trinidad y Tobago","Tuvalu","Taiwán","tz–Tanzania","ua–Ucrania","ug–Uganda",
"Estados Unidos","uy–Uruguay","uz–Uzbekistán","ve–Venezuela",
"Islas Vírgenes de los EE. UU.","Vietnam","Vanuatu","Samoa",
"Kosovo","Yemen","Mayotte","Sudáfrica","Zambia","Zimbabwe"};
    
     static public String []anio ={"2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986",
            "1985","1984","1983","1982","1981","1980","1979","1978","1977","1976","1975","1974","1973","1972","1971","1970","1969","1968","1967","1966","1965","1964","1963","1962","1961","1960","1959","1958","1957",
            "1956","1955","1954","1953","1952","1951","1950","1949","1948","1947","1946","1945","1944","1943","1942","1941","1940","1939","1938","1937","1936","1935","1934","1933","1932",
            "1931","1930","1929","1928","1927","1926","1925","1924","1923","1922","1921","1920","1919","1918","1917","1916","1915","1914","1913","1912","1911","1910","1909","1908","1907","1906","1905","1904","1903","1902"};
   
     Random rnd_dir = new Random();
     int id_prueba =(int)(rnd_dir.nextDouble() * 2000 + 1000);
    /**
     * Creates new form MainView
     */
    public Hoja1() {
        initComponents();
        setLocationRelativeTo(null);
        txtFecNac.setText(fechaActual());
        conn.conectar();
        //txtCatBrev.setVisible(false);   
        String []orden ={"1er Puesto","2do Puesto","3er Puesto","Decimo Sup.","Quinto Sup.","Tercio Sup.","Otro"};      
        String []instituciones ={"UAP","PUCP","UNMSM","U. Cayetano Heredia","UNIFE","U. Lima","UIGV","UNFV","UNAC","UNI",
        "U. Nac. Agraria La Molina","U. Pacifico","U. Norver Wienner","UPC","U. Ricardo Palma","USMP","USIL","UTP","UCV","UPN"
        ,"U. Peruana Union","Otras Univ.","PROVINCIA","-----------","U. Nac. de Piura","U. Nac. de Trujillo","ESCUELAS","------------"
        ,"ESAN","CENTRUM","Otras Escuelas","INSTITUTOS","-----------","SENATI","ADEX","Cibertec","CIMAS","IDAT","ICPNA","EIGER"
        ,"ELA","IPAE","IPP","Otros Institutos"};       
        String []grado ={"Incompleto","Estudiante","Egresado","Bachiller","Titulado s/coleg.","Titulado c/coleg.","Egresado Maestria","Magister"};
        String []ciclo ={"1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
        String []especialidad ={"Acuicultura","Administracion","Agronomia","Arquitectura","Arqueologia","Arte"};
             
        jcb1 = new JComboBox(paises);
        jcb2 = new JComboBox(anio);
        jcb3 = new JComboBox(orden);
        jcb4 = new JComboBox(instituciones);
        jcb5 = new JComboBox(grado);
        jcb6 = new JComboBox(ciclo);
        jcb7 = new JComboBox(especialidad);
        
        TableColumn t1 = tableEdEs.getColumnModel().getColumn(1);
        TableColumn t2 = tableEdEs.getColumnModel().getColumn(2);
        TableColumn t3 = tableEdEs.getColumnModel().getColumn(3);
        TableColumn t4 = tableEdEs.getColumnModel().getColumn(4);
        TableColumn x1 = tablaEdSup.getColumnModel().getColumn(0);
        TableColumn x2 = tablaEdSup.getColumnModel().getColumn(2);
        TableColumn x3 = tablaEdSup.getColumnModel().getColumn(3);
        TableColumn x4 = tablaEdSup.getColumnModel().getColumn(7);
        
        TableCellEditor tc1 = new DefaultCellEditor(jcb1);
        TableCellEditor tc2 = new DefaultCellEditor(jcb2);
        TableCellEditor tc3 = new DefaultCellEditor(jcb2);
        TableCellEditor tc4 = new DefaultCellEditor(jcb3);
        TableCellEditor xc1 = new DefaultCellEditor(jcb4);
        TableCellEditor xc2 = new DefaultCellEditor(jcb5);
        TableCellEditor xc3 = new DefaultCellEditor(jcb6);
        TableCellEditor xc4 = new DefaultCellEditor(jcb7);
       
        t1.setCellEditor(tc1);  
        t2.setCellEditor(tc2); 
        t3.setCellEditor(tc3);
        t4.setCellEditor(tc4);
        x1.setCellEditor(xc1);
        x2.setCellEditor(xc2);
        x3.setCellEditor(xc3);
        x4.setCellEditor(xc4);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CbCodPos = new javax.swing.JComboBox<String>();
        lbl2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taRes_Prof = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtApPat = new javax.swing.JTextField();
        txtApMat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombs = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFecNac = new javax.swing.JTextField();
        txtLugNac = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNacional = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtInt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtProv = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtDistrito = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCiud = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtTelef1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtTelef2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        CbSexo = new javax.swing.JComboBox<String>();
        txtDNI = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        CbBrev = new javax.swing.JComboBox<String>();
        jLabel28 = new javax.swing.JLabel();
        txtCatBrev = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        CbAntPen = new javax.swing.JComboBox<String>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtCodDis = new javax.swing.JTextField();
        CbSPens = new javax.swing.JComboBox<String>();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableEdEs = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaEdSup = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        CbLee_in = new javax.swing.JComboBox<String>();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        CbEscribe_in = new javax.swing.JComboBox<String>();
        CbEntiende_in = new javax.swing.JComboBox<String>();
        CbHabla_in = new javax.swing.JComboBox<String>();
        CbLee2 = new javax.swing.JComboBox<String>();
        CbEntiende1 = new javax.swing.JComboBox<String>();
        CbHabla1 = new javax.swing.JComboBox<String>();
        CbHabla2 = new javax.swing.JComboBox<String>();
        CbEntiende2 = new javax.swing.JComboBox<String>();
        CbEscribe1 = new javax.swing.JComboBox<String>();
        CbEscribe2 = new javax.swing.JComboBox<String>();
        CbLee1 = new javax.swing.JComboBox<String>();
        jLabel60 = new javax.swing.JLabel();
        txtIdiom1 = new javax.swing.JTextField();
        txtIdiom2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        CbWord = new javax.swing.JComboBox<String>();
        CbVisio = new javax.swing.JComboBox<String>();
        CbExcel = new javax.swing.JComboBox<String>();
        CbWindows = new javax.swing.JComboBox<String>();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        CbAccess = new javax.swing.JComboBox<String>();
        CbProject = new javax.swing.JComboBox<String>();
        CbEmail = new javax.swing.JComboBox<String>();
        CbPPT = new javax.swing.JComboBox<String>();
        CbEstCiv = new javax.swing.JComboBox();
        CbDepa = new javax.swing.JComboBox();
        txtInfo_Ad = new javax.swing.JTextField();
        CbPais = new javax.swing.JComboBox();
        lblEdad = new javax.swing.JLabel();
        txtFecNac1 = new javax.swing.JTextField();
        txtNCUSPP = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        CbEjerFun = new javax.swing.JComboBox<String>();
        btnNext1 = new javax.swing.JButton();
        btnAtras1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("CURRICULUM DEL POSTULANTE");

        CbCodPos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02AUP", "03ACRE", "04ACAFME", "014AME", "014TOCV-1", "09ASEPP", "013ACRR", "013AIET", "013ACE", "013TOEP", "07ACAN", "07APBAN", "07AINFRA", "07ASOPBD", "07AGTI", "02AU" }));
        CbCodPos.setSelectedIndex(2);
        CbCodPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbCodPosActionPerformed(evt);
            }
        });

        lbl2.setText("Codigo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("RESUMEN PROFESIONAL");

        jLabel3.setText("(Resuma sus estudios, experiencias, competencias / habilidades, conocimiento de idiomas conocimientos informáticos y aspiraciones profesionales)");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/proyecto/imagenes/texto1.PNG"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/proyecto/imagenes/texto2.PNG"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        taRes_Prof.setColumns(20);
        taRes_Prof.setRows(5);
        jScrollPane3.setViewportView(taRes_Prof);

        jEditorPane1.setEditable(false);
        jEditorPane1.setBackground(new java.awt.Color(0, 255, 204));
        jEditorPane1.setColumns(20);
        jEditorPane1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jEditorPane1.setRows(5);
        jScrollPane1.setViewportView(jEditorPane1);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(229, 223, 223));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("1.- DATOS PERSONALES");

        jLabel7.setText("Ap.Paterno");

        jLabel8.setText("Ap.Materno");

        txtApPat.setBackground(new java.awt.Color(204, 204, 204));
        txtApPat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtApMat.setBackground(new java.awt.Color(204, 204, 204));
        txtApMat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtApMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApMatActionPerformed(evt);
            }
        });

        jLabel9.setText("Nombres");

        txtNombs.setBackground(new java.awt.Color(204, 204, 204));
        txtNombs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel10.setText("Edad");

        jLabel11.setText("Fecha de Nacimiento");

        jLabel12.setText("Lugar de Nacimiento");

        txtFecNac.setBackground(new java.awt.Color(204, 204, 204));
        txtFecNac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtLugNac.setBackground(new java.awt.Color(204, 204, 204));
        txtLugNac.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel13.setText("Nacionalidad");

        jLabel14.setText("Sexo");

        jLabel15.setText("Estado Civil");

        txtNacional.setBackground(new java.awt.Color(204, 204, 204));
        txtNacional.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel16.setText("Domiciliio");

        txtDomicilio.setBackground(new java.awt.Color(204, 204, 204));
        txtDomicilio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel17.setText("Num");

        txtNum.setBackground(new java.awt.Color(204, 204, 204));
        txtNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel18.setText("Int");

        txtInt.setBackground(new java.awt.Color(204, 204, 204));
        txtInt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel19.setText("Departamento");

        jLabel20.setText("Provincia");

        txtProv.setBackground(new java.awt.Color(204, 204, 204));
        txtProv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel21.setText("Distrito");

        txtDistrito.setBackground(new java.awt.Color(204, 204, 204));
        txtDistrito.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel22.setText("Ciudad");

        txtCiud.setBackground(new java.awt.Color(204, 204, 204));
        txtCiud.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel23.setText("Pais");

        jLabel24.setText("Telefono Contacto");

        txtTelef1.setBackground(new java.awt.Color(204, 204, 204));
        txtTelef1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel25.setText("Otro Telefono");

        txtTelef2.setBackground(new java.awt.Color(204, 204, 204));
        txtTelef2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel26.setText("e-mail(solo uno)");

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N

        jLabel27.setText("Documento de Identidad(DNI)");

        CbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));
        CbSexo.setSelectedIndex(-1);
        CbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbSexoActionPerformed(evt);
            }
        });

        txtDNI.setBackground(new java.awt.Color(204, 204, 204));
        txtDNI.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        jLabel29.setText("Brevete");

        CbBrev.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SI", "NO" }));
        CbBrev.setSelectedIndex(-1);
        CbBrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CbBrevMouseClicked(evt);
            }
        });
        CbBrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbBrevActionPerformed(evt);
            }
        });

        jLabel28.setText("Categoria");

        txtCatBrev.setBackground(new java.awt.Color(204, 204, 204));
        txtCatBrev.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel30.setText("¿Usted registra  antecedentes");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel31.setText("penales o policiales?");

        CbAntPen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solo Penales", "Solo Policiales ", "Solo Judiciales", "Mas de uno", "Ninguno" }));
        CbAntPen.setSelectedIndex(4);
        CbAntPen.setToolTipText("");
        CbAntPen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbAntPenActionPerformed(evt);
            }
        });

        jLabel32.setText("S.Pensiones");

        jLabel33.setText("Nro. CUSPP");

        jLabel34.setText("Si Ud. esta discapacitado introduzca su codigo de inscripcion ");

        txtCodDis.setBackground(new java.awt.Color(204, 204, 204));
        txtCodDis.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N

        CbSPens.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AFP Horizone", "AFP Seguro", "AFP Prima", "AFP Profuturo", "SNP", "-----------------", "No estoy Afiliado" }));
        CbSPens.setSelectedIndex(-1);
        CbSPens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbSPensActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("2.- EDUCACION ESCOLAR");

        jLabel36.setText("En caso haya cursado más de 2 instituciones por nivel ");

        tableEdEs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre de la Institucion", "Pais", "Año de Inicio", "Año de Termino", "Orden de Merito"
            }
        ));
        jScrollPane5.setViewportView(tableEdEs);

        jLabel37.setText("Primaria");

        jLabel38.setText("Primaria");

        jLabel39.setText("Secundaria");

        jLabel40.setText("Secundaria");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("3.-EDUCACIÓN SUPERIOR o TÉCNICA");

        tablaEdSup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre de la Institu.", "", "Grado de Instruc.", "Ciclo", "Mes/Año Inicio", "Ultimo mes/año cursado", "Años de Estudio", "Especialidad"
            }
        ));
        jScrollPane6.setViewportView(tablaEdSup);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setText("Ingrese aqui cualquier informacion: ");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("4.-IDIOMAS Y COMPUTACIÓN");

        jLabel44.setText("Al posicionarse en los campos habilitados, lea atentamente el mensaje emergente y seleccione la de su agrado ");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel45.setText("Otros Idiomas ");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Ingles");

        CbLee_in.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbLee_in.setSelectedIndex(-1);
        CbLee_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbLee_inActionPerformed(evt);
            }
        });

        jLabel48.setText("Lee");

        jLabel49.setText("Habla");

        jLabel50.setText("Escribe");

        jLabel51.setText("Entiende");

        CbEscribe_in.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbEscribe_in.setSelectedIndex(-1);
        CbEscribe_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEscribe_inActionPerformed(evt);
            }
        });

        CbEntiende_in.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbEntiende_in.setSelectedIndex(-1);
        CbEntiende_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEntiende_inActionPerformed(evt);
            }
        });

        CbHabla_in.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbHabla_in.setSelectedIndex(-1);
        CbHabla_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbHabla_inActionPerformed(evt);
            }
        });

        CbLee2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbLee2.setSelectedIndex(-1);
        CbLee2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbLee2ActionPerformed(evt);
            }
        });

        CbEntiende1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbEntiende1.setSelectedIndex(-1);
        CbEntiende1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEntiende1ActionPerformed(evt);
            }
        });

        CbHabla1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbHabla1.setSelectedIndex(-1);
        CbHabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbHabla1ActionPerformed(evt);
            }
        });

        CbHabla2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbHabla2.setSelectedIndex(-1);
        CbHabla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbHabla2ActionPerformed(evt);
            }
        });

        CbEntiende2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbEntiende2.setSelectedIndex(-1);
        CbEntiende2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEntiende2ActionPerformed(evt);
            }
        });

        CbEscribe1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbEscribe1.setSelectedIndex(-1);
        CbEscribe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEscribe1ActionPerformed(evt);
            }
        });

        CbEscribe2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbEscribe2.setSelectedIndex(-1);
        CbEscribe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEscribe2ActionPerformed(evt);
            }
        });

        CbLee1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbLee1.setSelectedIndex(-1);
        CbLee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbLee1ActionPerformed(evt);
            }
        });

        jLabel60.setText("Otro idioma");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(CbLee_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel49)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel50))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(CbHabla_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CbEscribe_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CbEntiende_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51))
                                .addContainerGap(28, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel45)
                                .addContainerGap(116, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdiom1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(txtIdiom2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(CbLee1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CbHabla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CbEscribe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(CbEntiende1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(CbLee2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CbHabla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CbEscribe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CbEntiende2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel45)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel51)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbLee_in, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbHabla_in, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbEscribe_in, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbEntiende_in, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addGap(15, 15, 15)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbLee1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CbEntiende1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CbEscribe1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdiom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CbHabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbLee2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbHabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbEntiende2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbEscribe2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdiom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Computacion");

        jLabel52.setText("Ms. Windows");

        jLabel53.setText("Ms. Word");

        jLabel54.setText("Ms. Excel");

        jLabel55.setText("Ms. PowerPoint");

        jLabel56.setText("Ms. Visio");

        CbWord.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbWord.setSelectedIndex(-1);
        CbWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbWordActionPerformed(evt);
            }
        });

        CbVisio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbVisio.setSelectedIndex(-1);
        CbVisio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbVisioActionPerformed(evt);
            }
        });

        CbExcel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbExcel.setSelectedIndex(-1);
        CbExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbExcelActionPerformed(evt);
            }
        });

        CbWindows.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbWindows.setSelectedIndex(-1);
        CbWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbWindowsActionPerformed(evt);
            }
        });

        jLabel57.setText("Ms. Project");

        jLabel58.setText("Ms. Access");

        jLabel59.setText("E-mail");

        CbAccess.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbAccess.setSelectedIndex(-1);
        CbAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbAccessActionPerformed(evt);
            }
        });

        CbProject.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbProject.setSelectedIndex(-1);
        CbProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbProjectActionPerformed(evt);
            }
        });

        CbEmail.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbEmail.setSelectedIndex(-1);
        CbEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEmailActionPerformed(evt);
            }
        });

        CbPPT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NO", "B", "I", "A" }));
        CbPPT.setSelectedIndex(-1);
        CbPPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbPPTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel46)
                .addGap(142, 142, 142))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CbPPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel52)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbVisio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbWindows, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbWord, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbExcel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CbAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(30, 30, 30)
                        .addComponent(CbProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbWindows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57)
                            .addComponent(CbProject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58)
                            .addComponent(CbAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(CbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CbExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)))
                    .addComponent(jLabel52))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbVisio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbPPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addContainerGap())
        );

        CbEstCiv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CbEstCiv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Divorsiado", "Conviviente", "Viudo" }));
        CbEstCiv.setSelectedIndex(-1);
        CbEstCiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEstCivActionPerformed(evt);
            }
        });

        CbDepa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amazonas", "Ancash", "Apurimac", "Arequipa ", "Ayacucho", "Cajamarca ", "Callao", "Cusco", "Huancavelica", "Huanuco", "Ica ", "Junin ", "La Libertad", "Lambayeque", "Lima", "Loreto", "Madre de Dios", "Moquegua", "Pasco", "Piura", "Puno", "San Martin", "Tacna ", "Tumbes ", "Ucayali", " ", " ", " ", " ", " ", " ", " ", " " }));
        CbDepa.setSelectedIndex(-1);
        CbDepa.setToolTipText("");
        CbDepa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbDepaActionPerformed(evt);
            }
        });

        txtInfo_Ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInfo_AdActionPerformed(evt);
            }
        });

        CbPais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Peru", "Afganistan", "Albania", "Andorra", "Afganistán", "Antigua y Barbuda", "Anguila", "Angola", "Antártida", "Argentina", "Austria", "Australia", "Aruba", "Azerbaiyán", "Bosnia-Herzegovina", "Barbados", "Bangladés", "Bélgica", "Burkina Faso", "Bulgaria", "Bahréin", "Burundi", "Benín", "BL-San Bartolomé", "Bermudas", "Brunei", "Bolivia", "Brasil", "Las Bahamas", "Bután", "Isla Bouvet", "Botsuana", "Bielorrusia", "Belice", "Canadá", "Suiza", "Costa de Marfil", "Islas Cook", "Chile", "Camerún", "ChinaColombia", "Costa Rica", "Cuba", "Cabo Verde", "Curacao", "ChipreRepública Checa", "AlemaniaYibuti", "Dinamarca", "Dominica", "República Dominicana", "Argelia", "Ecuador", "Estonia", "Egipto", "Eritrea", "España", "Etiopía", "Finlandia" }));
        CbPais.setSelectedIndex(-1);

        lblEdad.setBackground(new java.awt.Color(0, 255, 204));

        txtFecNac1.setBackground(new java.awt.Color(204, 204, 204));
        txtFecNac1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtNCUSPP.setBackground(new java.awt.Color(204, 204, 204));
        txtNCUSPP.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtNCUSPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNCUSPPActionPerformed(evt);
            }
        });

        jLabel61.setText("Ejercicio de la Funcion Publica");

        CbEjerFun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nunca estuve inhabilitado", "Estoy Inhabilitado", "Estuve Inhabilitado" }));
        CbEjerFun.setSelectedIndex(-1);
        CbEjerFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEjerFunActionPerformed(evt);
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
                        .addComponent(jScrollPane6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtInfo_Ad))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel41)
                            .addComponent(jLabel43))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel40))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel36))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(150, 150, 150)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(18, 18, 18)
                        .addComponent(CbEjerFun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel32)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(CbSPens, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel33)
                                            .addGap(28, 28, 28)
                                            .addComponent(txtNCUSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(283, 283, 283)
                                            .addComponent(jLabel29)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(CbBrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel28)))
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel31)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(txtCatBrev, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addGap(96, 96, 96))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel34)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCodDis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(281, 281, 281)
                                            .addComponent(jLabel25)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtTelef2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel26))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel30)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(CbAntPen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGap(37, 37, 37))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addGap(23, 23, 23))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addGap(41, 41, 41)))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNombs, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addComponent(txtFecNac1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(lblEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel11))
                                                        .addComponent(txtNacional, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(26, 26, 26)
                                                    .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel16)
                                                .addComponent(jLabel20))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addComponent(txtProv, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel21)))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel22)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(txtCiud, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jLabel23))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addComponent(jLabel17)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jLabel18)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                    .addComponent(jLabel12)
                                                                    .addGap(18, 18, 18)
                                                                    .addComponent(txtLugNac, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                    .addComponent(txtInt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(18, 18, 18)
                                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel15)
                                                                        .addComponent(jLabel19)))))))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(278, 278, 278)
                                                    .addComponent(jLabel14)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(CbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(4, 4, 4)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CbDepa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CbPais, 0, 1, Short.MAX_VALUE)
                                        .addComponent(CbEstCiv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGap(81, 81, 81))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel24)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTelef1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtApPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(txtLugNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFecNac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNacional, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CbEstCiv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbDepa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txtInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txtProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(txtCiud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(CbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtTelef1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtTelef2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(CbBrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtCatBrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(CbAntPen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(CbSPens, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodDis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNCUSPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(CbEjerFun, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel40))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtInfo_Ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel2);

        btnNext1.setText("Siguiente Pag.");
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnAtras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pe/egcc/eurekaapp/img/salir.png"))); // NOI18N
        btnAtras1.setText("Volver al menu");
        btnAtras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtras1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbCodPos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAtras1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext1)
                .addGap(34, 34, 34))
            .addComponent(jScrollPane4)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl2)
                                        .addComponent(CbCodPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CbCodPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbCodPosActionPerformed
        // TODO add your handling code here:
     if(CbCodPos.getSelectedIndex()==0){
            jEditorPane1.setText("Auditorio principal");
            pos1.setCODPUESTO("02AUP");
        }
     else{
         if(CbCodPos.getSelectedIndex()==1){
            jEditorPane1.setText("Analista de administracion"+"\n"+"y recuperacion");
            pos1.setCODPUESTO("03ACRE");
         }
         else{
             if(CbCodPos.getSelectedIndex()==2){
                 jEditorPane1.setText("Analista de Corresponsalia "+"\n"+"y Administrador de "+"\n"+"Fondos en M.E");
                 pos1.setCODPUESTO("04ACAFME");
             }
             else{
                 if(CbCodPos.getSelectedIndex()==3){
                     jEditorPane1.setText("Analista de Medios "+"\n"+"electronicos");
                     pos1.setCODPUESTO("014AME");
                 }
                 else{
                     if(CbCodPos.getSelectedIndex()==4){
                         jEditorPane1.setText("Tecnico Operativo "+"\n"+" de Canales Virtuales");
                         pos1.setCODPUESTO("014TOCV-1");
                     }
                     else{
                           if(CbCodPos.getSelectedIndex()==5){
                                 jEditorPane1.setText("Analista de Seleccion "+"\n"+" Evaluacion y Proyecction"+"\n"+" de Personal");
                                 pos1.setCODPUESTO("09ASEPP");
                            }
                            else{
                                 if(CbCodPos.getSelectedIndex()==6){
                                     jEditorPane1.setText("Analista de Corresponsalia");
                                     pos1.setCODPUESTO("013ACRR");
                                  }
                                 else{
                                     if(CbCodPos.getSelectedIndex()==7){
                                            jEditorPane1.setText("Analista de Ingresos "+"\n"+" y Egresos del Tesoro");
                                            pos1.setCODPUESTO("013AIET");
                                        }
                                     else{
                                         if(CbCodPos.getSelectedIndex()==8){
                                            jEditorPane1.setText("Analista de Comercio"+"\n"+" Exterior y ADM. "+"\n"+"de convenios");
                                            pos1.setCODPUESTO("013ACE");
                                         }
                                         else{
                                             if(CbCodPos.getSelectedIndex()==9){
                                                jEditorPane1.setText("Tecnico Operativo "+"\n"+"Entidades Publicas");
                                                pos1.setCODPUESTO("013TOEP");
                                              }
                                             else{
                                                 if(CbCodPos.getSelectedIndex()==10){
                                                    jEditorPane1.setText("Analista Canales "+"\n"+"de Atencion");
                                                    pos1.setCODPUESTO("07ACAN");
                                                 }
                                                 else{
                                                     if(CbCodPos.getSelectedIndex()==11){
                                                       jEditorPane1.setText("Analista de Productos "+"\n"+"Bancarios");
                                                       pos1.setCODPUESTO("07APBAN");
                                                     }
                                                     else{
                                                         if(CbCodPos.getSelectedIndex()==12){
                                                             jEditorPane1.setText("Analista de Infraestructura"+"\n"+" y Comunicaciones");
                                                             pos1.setCODPUESTO("07AINFRA");
                                                         }
                                                         else{
                                                             if(CbCodPos.getSelectedIndex()==13){
                                                               jEditorPane1.setText("Analista de Soporte"+"\n"+" de Plataformas");
                                                               pos1.setCODPUESTO("07ASOPBD");
                                                             }
                                                             else{
                                                                 if(CbCodPos.getSelectedIndex()==14){
                                                                    jEditorPane1.setText("Analista de Gestion "+"\n"+"de tecnologias de "+"\n"+"Informacion");
                                                                    pos1.setCODPUESTO("07AGTI");
                                                                 }
                                                                 else{
                                                                     if(CbCodPos.getSelectedIndex()==15){
                                                                         jEditorPane1.setText("Auditor");
                                                                         pos1.setCODPUESTO("07AU");
                                                                        }
                                                                 }
                                                                 
                                                             }
                                                             
                                                         }
                                                         
                                                     }
                                                      
                                                 }
                                                  
                                             }
                                             
                                             
                                         }
                                         
                                     }
                                     
                                 }
                           
                     
                                }
                           
                     
                         }
                     
                 }
             }
             
         }
     }  
    }//GEN-LAST:event_CbCodPosActionPerformed
    
    public void Registrar_EdSuperior(){
        int id_edsup =(int)(rnd_dir.nextDouble() * 4512 + 2345);
        //Solo registra la primera fila de la tabla
        try {
             //Tabla EDSUPERIOR
             //----------------------------
            edsup.setID_EDSUPERIOR(String.valueOf(id_edsup));
            if(tablaEdSup.getValueAt(0,0).toString().equals("")){
               edsup.setNOMBRE_INSTITUCION(tablaEdSup.getValueAt(0,1).toString());                 
            }else{
             edsup.setNOMBRE_INSTITUCION(tablaEdSup.getValueAt(0,0).toString());   
            }
                      
            regEdSup = "INSERT INTO EDSUPERIOR VALUES ('"+edsup.getID_EDSUPERIOR()+"','"
                    +edsup.getNOMBRE_INSTITUCION()+"')";
             //----------------------------
             //Tabla DETALLE_EDSUPERIOR
             //----------------------------
            det_edsup.setGRADO_INSTRUCCION(tablaEdSup.getValueAt(0,2).toString());
            det_edsup.setCICLO(tablaEdSup.getValueAt(0,3).toString());
            det_edsup.setAÑO_INICIO((int) tablaEdSup.getValueAt(0,4));
            det_edsup.setAÑO_FIN((int)tablaEdSup.getValueAt(0,5));
            det_edsup.setAÑOS_ESTUDIOS(Integer.parseInt(tablaEdSup.getValueAt(0,6).toString()));
            det_edsup.setESPECIALIDAD(tablaEdSup.getValueAt(0,7).toString());
           
            regDet_EdSup = "INSERT INTO DETALLE_EDSUPERIOR VALUES ('"+Hoja3.cv1.getID_CV()+"','"
                    +edsup.getID_EDSUPERIOR()+"','"+det_edsup.getGRADO_INSTRUCCION()+det_edsup.getCICLO()
                    +"','"+det_edsup.getAÑO_INICIO()+"','"+det_edsup.getAÑO_FIN()
                    +"',"+det_edsup.getAÑOS_ESTUDIOS()+",'"+det_edsup.getESPECIALIDAD()
                    +"')";
  
            conn.Escribir(regEdSup);
            //conn.Escribir(regDet_EdSup);
          
        } catch (Exception e) {
           JOptionPane.showMessageDialog(rootPane,"Error_EdSuperior: "+e.getMessage());        
        }     
    }
    
    public void Registrar_EdEscolar(){
        int id_edes =(int)(rnd_dir.nextDouble() * 7659 + 3456);
        try {
            for(int i=0;i<4;i++){  
        //Tabla COLEGIO
        //----------------------------
        coleg.setID_COLEGIO(String.valueOf(id_edes)); 
        coleg.setNOMBRE(tableEdEs.getValueAt(i,0).toString());          
        coleg.setPAIS(tableEdEs.getValueAt(i,1).toString());
        //---------------------------------------------------
        //Tabla EDUCACION_ESCOLAR
        //---------------------------------------------------
        ees.setTIPO_EDUCACION("Primaria");  
        if(i>=2){
        ees.setTIPO_EDUCACION("Secundaria");
        }    
        ees.setAÑO_INICIO(Integer.parseInt(tableEdEs.getValueAt(i,2).toString()));
        ees.setAÑO_TERMINO(Integer.parseInt(tableEdEs.getValueAt(i,3).toString()));        
        ees.setORDEN_MERITO(tableEdEs.getValueAt(i,4).toString());
        
        regColegio = "INSERT INTO COLEGIO VALUES ('"+coleg.getID_COLEGIO()+"','"+coleg.getNOMBRE()
                         +"','"+coleg.getPAIS()+"')";
        
        regEdEs = "INSERT INTO EDUCACION_ESCOLAR VALUES ('"+Hoja3.cv1.getID_CV()+"','"+coleg.getID_COLEGIO()
                         +"','"+ees.getTIPO_EDUCACION()+"',"+ees.getAÑO_INICIO()+","+ees.getAÑO_TERMINO()
                         +",'"+ees.getORDEN_MERITO()+"')";
        conn.Escribir(regColegio);   
        conn.Escribir(regEdEs);        
       }    
            
      } catch (Exception e) {
         JOptionPane.showMessageDialog(rootPane,"Error_EdEscolar: "+e.getMessage());        
        }       
    }
    
    public void Registrar_Idioma(){
        int id_regid =(int)(rnd_dir.nextDouble() * 9834 + 1436);
        try {   
        //----------------------------
        //Tabla IDIOMA
        //----------------------------
        id_in.setID_IDIOMA(String.valueOf(id_regid));
        id_in.setNOMBRE("Ingles");
        detid_in.setLEE((char) CbLee_in.getSelectedItem());
        detid_in.setHABLA((char)CbHabla_in.getSelectedItem()); 
        detid_in.setESCRIBE((char)CbEscribe_in.getSelectedItem()); 
        detid_in.setENTIENDE((char)CbEntiende_in.getSelectedItem()); 
         //---------------------------------------
         int id_regid1 =(int)(rnd_dir.nextDouble() * 21148 + 19367);
         id1.setID_IDIOMA(String.valueOf(id_regid1));
         id1.setNOMBRE(txtIdiom1.getText()); 
         det_id1.setLEE((char)CbLee1.getSelectedItem());
         det_id1.setHABLA((char)CbHabla1.getSelectedItem());
         det_id1.setESCRIBE((char)CbEscribe1.getSelectedItem());
         det_id1.setENTIENDE((char)CbEntiende1.getSelectedItem());
                 
        //--------------------------------------------
         int id_regid2 =(int)(rnd_dir.nextDouble() * 7999 + 1603);
         id2.setID_IDIOMA(String.valueOf(id_regid2));
         id2.setNOMBRE(txtIdiom2.getText());    
         det_id2.setLEE((char)CbLee2.getSelectedItem());
         det_id2.setHABLA((char)CbHabla2.getSelectedItem());
         det_id2.setESCRIBE((char)CbEscribe2.getSelectedItem());
         det_id2.setENTIENDE((char)CbEntiende2.getSelectedItem());
                     
        regId_in = "INSERT INTO IDIOMA VALUES ('"+id_in.getID_IDIOMA()+"','"+id_in.getNOMBRE()+"')";
        
        regId_1 = "INSERT INTO IDIOMA VALUES ('"+id1.getID_IDIOMA()+"','"+id1.getNOMBRE()+"')";
        regId_2 = "INSERT INTO IDIOMA VALUES ('"+id2.getID_IDIOMA()+"','"+id2.getNOMBRE()+"')";
        
        regDet_in = "INSERT INTO DETALLE_IDIOMA VALUES ('"+Hoja3.cv1.getID_CV()+"','"+id_in.getID_IDIOMA()
                            +"','"+detid_in.getLEE()+"','"+detid_in.getHABLA()+"','"+detid_in.getENTIENDE()
                            +"','"+detid_in.getESCRIBE()
                            +"')";
        regDet_1 = "INSERT INTO DETALLE_IDIOMA VALUES ('"+Hoja3.cv1.getID_CV()+"','"+id1.getID_IDIOMA()
                            +"','"+det_id1.getLEE()+"','"+det_id1.getHABLA()+"','"+det_id1.getENTIENDE()
                            +"','"+det_id1.getESCRIBE()
                            +"')";
        regDet_2 = "INSERT INTO DETALLE_IDIOMA VALUES ('"+Hoja3.cv1.getID_CV()+"','"+id2.getID_IDIOMA()
                            +"','"+det_id2.getLEE()+"','"+det_id2.getHABLA()+"','"+det_id2.getENTIENDE()
                            +"','"+det_id2.getESCRIBE()
                            +"')";      
            
        conn.Escribir(regId_in);
        conn.Escribir(regId_1);
        conn.Escribir(regId_2);
        //conn.Escribir(regDet_in);
        //conn.Escribir(regDet_1);
        //conn.Escribir(regDet_2);    
      } catch (Exception e) {
          JOptionPane.showMessageDialog(rootPane,"Error_RegIdioma: "+e.getMessage());             
         }
    }
  
    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void CbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbSexoActionPerformed

    private void CbBrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbBrevActionPerformed
         if(CbBrev.getSelectedIndex()==0){
            txtCatBrev.setVisible(true);
            pos1.setCAT_BREV(txtCatBrev.getText());         
        }else{
            txtCatBrev.setVisible(false); 
         }  
    }//GEN-LAST:event_CbBrevActionPerformed

    private void CbAntPenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbAntPenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbAntPenActionPerformed

    private void CbSPensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbSPensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbSPensActionPerformed

    private void CbLee_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbLee_inActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbLee_inActionPerformed

    private void CbEscribe_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEscribe_inActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEscribe_inActionPerformed

    private void CbEntiende_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEntiende_inActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEntiende_inActionPerformed

    private void CbHabla_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbHabla_inActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbHabla_inActionPerformed

    private void CbLee2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbLee2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbLee2ActionPerformed

    private void CbEntiende1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEntiende1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEntiende1ActionPerformed

    private void CbHabla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbHabla1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbHabla1ActionPerformed

    private void CbHabla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbHabla2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbHabla2ActionPerformed

    private void CbEntiende2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEntiende2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEntiende2ActionPerformed

    private void CbEscribe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEscribe1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEscribe1ActionPerformed

    private void CbEscribe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEscribe2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEscribe2ActionPerformed

    private void CbLee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbLee1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbLee1ActionPerformed

    private void CbWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbWordActionPerformed

    private void CbVisioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbVisioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbVisioActionPerformed

    private void CbExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbExcelActionPerformed

    private void CbWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbWindowsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbWindowsActionPerformed

    private void CbAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbAccessActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbAccessActionPerformed

    private void CbProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbProjectActionPerformed

    private void CbEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEmailActionPerformed
    
    public static String fechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);     
    }
                     
    public void Registrar_Postulante(){
        try {
            //Tabla POSTULANTE       
        pos1.setDNI_POSTULANTE(Integer.parseInt(txtDNI.getText()));
        pos1.setAPPATERNO(txtApPat.getText());
        pos1.setAPMATERNO(txtApMat.getText());
        pos1.setNOMBRE(txtNombs.getText());   
        pos1.setEDAD(26);
        pos1.setFECNAC(txtFecNac.getText());
        pos1.setLUGARNAC(txtLugNac.getText());
        pos1.setNACIONALIDAD(txtNacional.getText());
        pos1.setSEXO((char)CbSexo.getSelectedItem());  
        pos1.setEST_CIVIL((String)CbEstCiv.getSelectedItem()); 
        pos1.setDEPARTAMENT((String)CbDepa.getSelectedItem());
        pos1.setPAIS((String)CbPais.getSelectedItem());
        pos1.setTELEFONO1(Integer.parseInt(txtTelef1.getText()));
        pos1.setTELEFONO2(Integer.parseInt(txtTelef2.getText()));
        pos1.setEMAIL(txtEmail.getText());
        pos1.setSPENS((String)CbSPens.getSelectedItem());
        pos1.setNCUSPP(txtNCUSPP.getText());
        pos1.setANT_PENALES((String)CbAntPen.getSelectedItem());
        pos1.setCOD_DISCAP(txtCodDis.getText());
        pos1.setCAT_BREV(txtCatBrev.getText());
        pos1.setDIRECCION(txtDomicilio.getText()+"/"+txtNum.getText()+"/"+txtInt.getText()+"/"+txtDistrito.getText()+"/"+txtCiud.getText()+"/"+txtProv.getText());
        pos1.setRESUM_PROF(taRes_Prof.getText()); 
        pos1.setNivAccess((char) CbAccess.getSelectedItem());
        pos1.setNivEmail((char) CbEmail.getSelectedItem());
        pos1.setNivExcel((char)CbExcel.getSelectedItem());
        pos1.setNivPPT((char)CbPPT.getSelectedItem());
        pos1.setNivProject((char)CbProject.getSelectedItem());
        pos1.setNivVisio((char) CbVisio.getSelectedItem());
        pos1.setNivWindows((char)CbWindows.getSelectedItem());
        pos1.setNivWord((char)CbWord.getSelectedItem());  
        pos1.setEJERCICIO_FUN_PUBLICA((String) CbEjerFun.getSelectedItem());//falta agregarlo
        //-----------------------------------------------------        
        regPos = "INSERT INTO POSTULANTE VALUES ("+pos1.getDNI_POSTULANTE()+","+pos1.getCAT_BREV()
                        +","+pos1.getDIRECCION()+",'"+pos1.getCODPUESTO()+"','"+pos1.getAPPATERNO()
                        +"','"+pos1.getAPMATERNO()+"','"+pos1.getNOMBRE()+"',"+pos1.getEDAD()
                        +",'"+pos1.getFECNAC()+"','"+pos1.getLUGARNAC()+"','"+pos1.getNACIONALIDAD()+"','"
                        +pos1.getSEXO()+"','"+pos1.getEST_CIVIL()+"','"+pos1.getDEPARTAMENT()+"','"
                        +"','"+pos1.getPAIS()+"','"+pos1.getTELEFONO1()
                        +"','"+pos1.getTELEFONO2()+"','"+pos1.getEMAIL()+"','"+pos1.getSPENS()+"','"
                        +pos1.getNCUSPP()+"','"+pos1.getANT_PENALES()+"','"+pos1.getCOD_DISCAP()
                        +"')";
     
            conn.Escribir(regPos);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Error:"+ e.getMessage());
        }
        
    }
    
    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        try {      
        Registrar_Postulante();
        Registrar_Idioma();
        Registrar_EdEscolar();
        Registrar_EdSuperior();
        
        new Hoja2().setVisible(true);
        this.setVisible(false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Error:"+ e.getMessage());
        }
       
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnAtras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtras1ActionPerformed
        new Inicio().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAtras1ActionPerformed

    private void txtApMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApMatActionPerformed

    private void CbEstCivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEstCivActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEstCivActionPerformed

    private void CbDepaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbDepaActionPerformed
        
    }//GEN-LAST:event_CbDepaActionPerformed

    private void txtInfo_AdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInfo_AdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInfo_AdActionPerformed

    private void CbPPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbPPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbPPTActionPerformed

    private void CbBrevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CbBrevMouseClicked
        
    }//GEN-LAST:event_CbBrevMouseClicked

    private void txtNCUSPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNCUSPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNCUSPPActionPerformed

    private void CbEjerFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEjerFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbEjerFunActionPerformed
    
    /*
    private void insertar(String cad, AccesoDB f){
        boolean k = f.escribir(cad); 
    }
    */
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
            java.util.logging.Logger.getLogger(Hoja1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hoja1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hoja1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hoja1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hoja1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbAccess;
    private javax.swing.JComboBox<String> CbAntPen;
    private javax.swing.JComboBox<String> CbBrev;
    private javax.swing.JComboBox<String> CbCodPos;
    private javax.swing.JComboBox CbDepa;
    private javax.swing.JComboBox<String> CbEjerFun;
    private javax.swing.JComboBox<String> CbEmail;
    private javax.swing.JComboBox<String> CbEntiende1;
    private javax.swing.JComboBox<String> CbEntiende2;
    private javax.swing.JComboBox<String> CbEntiende_in;
    private javax.swing.JComboBox<String> CbEscribe1;
    private javax.swing.JComboBox<String> CbEscribe2;
    private javax.swing.JComboBox<String> CbEscribe_in;
    private javax.swing.JComboBox CbEstCiv;
    private javax.swing.JComboBox<String> CbExcel;
    private javax.swing.JComboBox<String> CbHabla1;
    private javax.swing.JComboBox<String> CbHabla2;
    private javax.swing.JComboBox<String> CbHabla_in;
    private javax.swing.JComboBox<String> CbLee1;
    private javax.swing.JComboBox<String> CbLee2;
    private javax.swing.JComboBox<String> CbLee_in;
    private javax.swing.JComboBox<String> CbPPT;
    private javax.swing.JComboBox CbPais;
    private javax.swing.JComboBox<String> CbProject;
    private javax.swing.JComboBox<String> CbSPens;
    private javax.swing.JComboBox<String> CbSexo;
    private javax.swing.JComboBox<String> CbVisio;
    private javax.swing.JComboBox<String> CbWindows;
    private javax.swing.JComboBox<String> CbWord;
    private javax.swing.JButton btnAtras1;
    private javax.swing.JButton btnNext1;
    private javax.swing.JTextArea jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JTextArea taRes_Prof;
    private javax.swing.JTable tablaEdSup;
    private javax.swing.JTable tableEdEs;
    private javax.swing.JTextField txtApMat;
    private javax.swing.JTextField txtApPat;
    private javax.swing.JTextField txtCatBrev;
    private javax.swing.JTextField txtCiud;
    private javax.swing.JTextField txtCodDis;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDistrito;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecNac;
    private javax.swing.JTextField txtFecNac1;
    private javax.swing.JTextField txtIdiom1;
    private javax.swing.JTextField txtIdiom2;
    private javax.swing.JTextField txtInfo_Ad;
    private javax.swing.JTextField txtInt;
    private javax.swing.JTextField txtLugNac;
    private javax.swing.JTextField txtNCUSPP;
    private javax.swing.JTextField txtNacional;
    private javax.swing.JTextField txtNombs;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtProv;
    private javax.swing.JTextField txtTelef1;
    private javax.swing.JTextField txtTelef2;
    // End of variables declaration//GEN-END:variables
}
