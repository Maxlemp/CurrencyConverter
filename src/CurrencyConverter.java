import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class CurrencyConverter  implements ActionListener {
    //hedha win bch yekteb l user (esm l field)
    TextField t1;

    //hne bch tetekteb l resultat mta3 l conversion
    TextField t2;

    //hedhi l window mte3na l kbira elli bch n7otou fiha kol chy
    Frame win, win2;

    //bch naamel panel fiha les button cancel w convert w panel fiha be9i lkol
    Panel P1, P2;

    //Button b1 bch ndetecti ki yenzel convert w b2 ki yenzel cancel
    Button b1, b2;

    //Choice bch n7ot fiha list roulant wala dra chesmha ki yenzel t9ollou ekhtar euro wala dollar
    Choice c1;
    //label bch n7ot fihom text
    Label l1, l2;


    //bch nekhdem kol chy fel constructor ki t3ayet constructor yekhdem kol chy
    public CurrencyConverter() {
        l1 = new Label(" =");
        l2 = new Label(" Dinar");
        l2.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC,  15));
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        //sna3t l labels wa7da fiha dinar bch tet7at fel ekhir w wa7da fiha = bch tet7at fel west
        t1 = new TextField(10);
        t2 = new TextField(10);
        t2.setEditable(false);
        //sna3t les textField

        //String title="Currency Converter";
        //title.setFont(new Font("Arial Black", Font.BOLD ,  20));
        //win = new Frame(title);
        win =  new Frame("Currency Converter");

        //super("Currency Converter");
        //sna3t l frame w samitha Currency Converter

        P1 = new Panel();
        P2 = new Panel();
        //sna3t le 2 panel


        b1 = new Button("Convert");
        b2 = new Button("Cancel");
        //sna3t buttons fihom text  wahda fiha convert w lokhra cancel


        c1 = new Choice();
        c1.add("-----");
        c1.add("Euro");
        c1.add("Dollar");
        //sna3t list roulant w zedt fiha text ------ And Euro and Dollar


        win.setLayout(new GridLayout(2, 1));
        //bch nrod l window l kbira grid layout yaani sous forme grids 2 ligne w 1 colone


        P1.setLayout(new FlowLayout());
        P2.setLayout(new FlowLayout());
        //bch nrod l panels el zouz flow layout bch yjiw l 7ajet elli fiha 9odem b3adhhom


        P1.add(t1);
        P1.add(c1);
        P1.add(l1);
        P1.add(t2);
        P1.add(l2);
        P1.setBackground(Color.black);
        //bch nzid kol chy lel panel lowla P1 (kol chy bekhlef l buttons) w MRATBIN lezem


        P2.add(b1);
        P2.add(b2);
        P2.setBackground(Color.black);
        //bch nzidd button lel panel 2


        win.add(P1);


        win.add(P2);
        //taw sna3t les 2 panels bch nzidhom lel window lkbira

        win.setSize(400,200);
        win.show();
        //win.setSize bsh naamel biha l width o l height taa l window te3i
        //win.show to show the window

        //l 7ad l 2en el window ma tetsakarch khater ma yaarach l x heki mta3 windows ech chnowa taamel
        //lezem n9ouloulou
        win.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                System.exit(0);
            }
        });
        //hedha code compact tajem haka wala taamel win.addWindowListener(new WindowAdapter()); w temchi tekhdem methode window adapter


        //taw l windows tetsaker lezem nrodou les button yekhdmou
        //lezem nzidou event listener 3al Convert(esmha b1) w Cancel (esmha b2)
        //bch nestamlou actionlistener lezem l class mte3na y implementi ActionListener
        b1.addActionListener(this);
        b2.addActionListener(this);
        //khedma wfet fel class hedha taw lezem n9ouloulou ki tsir action chnowa bch yaamel

    }


    //hne nchoufou ken bch tsir action chnowa bch ysir
    @Override
    public void actionPerformed(ActionEvent e) {
        //how bch yaatina l resultat sous form event fiha chkoun nzel w chnowa 3mal
        //a7na nest7a9ou chkoun nzel bch naamlou 7asb elli nzel alih tsir haja:
        //ken Convert nzel ntesti
        //ken cancel naawed l champ nfaraghhom
        //taw bch nekhou esm elli nzel

        String evt = e.getActionCommand();
        //evt bch tkoun fiha text "Convert" wala text "Cancel" elli houma esemi les button b1 b2


        //taw ntesti w bch nebda bel sehel evt == cancel
        if (evt.equals("Cancel")) {
            //bch nreseti l text field lowel
            t1.setText("");
            //bch nreseti l text field theni
            t2.setText("");
            //bch nreseti l choice(list deroulant) n7ot awel ekhtiyar elli howa -------
            c1.select(0);
            // hedhi el cancel button walet khadema taw el convert
        }


        //test ken nzelt convert
        if (evt.equals("Convert")) {
            //inpt bch n7ot fih elli 3tah l user
            Double inpt;

            // st bch n7ot fih el ekhtiyar mta3 ll user euro wala dollar
            String st = c1.getSelectedItem();

            //lezem nchouf ken ma 7atech nombre w 7at alphabet ma n3adich
            //yjareb yaamel conversion mel String lel integer ken ma khtafch yokhrej jemla mel fonction
            //5ater l champ TextField ma yaati w yekhou ken String
            try {
                inpt = Double.parseDouble(t1.getText());
            } catch (NumberFormatException e1) {
                //System.out.println("Hello");
                // amalt faz kif yda5l ay haja b5lef double to5rjlo window tgolo error rak ktebt haja ghalta o tfas5lo
                // li ketbo
               Frame win2 = new Frame("Error");
               Label l3 = new Label("Error, You didn't enter a double variable.");
               l3.setForeground(Color.RED);
               l3.setFont(new Font("Error", Font.BOLD,  19));
               win2.add(l3);
               win2.setSize(400,100);
               win2.setLocationRelativeTo(win);
               win2.setVisible(true);
               win2.addWindowListener(new WindowAdapter() {
                                          public void windowClosing(WindowEvent w) {
                                              win2.setVisible(false);
                                              t1.setText("");
                                              t2.setText("");
                                              c1.select(0);
                                          }});
                return ;
            }

            //w taw lezem nchouf l Choice elli 3tah euro wala dollar
            if (st.equals("Euro")) {
                //medem 7ab mel euro lel dinar yaani * 3.16
                //w bch n7ot directoment fel field theni t2
                //betbi3a lezem n7ot String yaani lezem n7awel lel string
               /* String tost = String.valueOf(inpt * 3.16);
                t2.setText(tost);*/
                // idha nheb nekho seulement deux chiffres aprés la virgule
                 double tost = inpt * 3.16;
                t2.setText(String.format("%.2f", tost));



            } else if (st.equals("Dollar")) {
                //nafs l 7keya fel dollar just nadhreb fel *2.88
              /*  String tost = String.valueOf(inpt * 2.88);
                t2.setText(tost);*/
                //idha nheb nekho seulement deux chiffres aprés la virgule
                 double tost = inpt * 2.88;
                t2.setText(String.format("%.2f", tost));

            }
        }
    }
    //Our Main xD :D
    public static void main(String[] args) {
        new CurrencyConverter();
        //or CurrencyConverter CC = new CurrencyConverter(); works too
    }


}