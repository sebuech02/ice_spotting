package pa_dev.train_spotting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public final static ArrayList<datensatzstamm> stammdaten = new ArrayList<datensatzstamm>(Arrays.asList(new datensatzstamm(1125, "Baureihe 411", "(ICE T)", "Arnstadt"),
            new datensatzstamm(4717, "Baureihe 407", "(ICE 3M)", "Paris"),
            new datensatzstamm(202, "Baureihe 402", "(ICE 2)", "Wuppertal"),
            new datensatzstamm(116, "Baureihe 401", "(ICE 1)", "Pforzheim"),
            new datensatzstamm(1167, "Baureihe 411", "(ICE T)", "Traunstein"),
            new datensatzstamm(1153, "Baureihe 411", "(ICE T)", "Ilmenau"),
            new datensatzstamm(220, "Baureihe 402", "(ICE 2)", "Meiningen"),
            new datensatzstamm(213, "Baureihe 402", "(ICE 2)", "Nauen"),
            new datensatzstamm(243, "Baureihe 402", "(ICE 2)", "Bautzen/Budyšin"),
            new datensatzstamm(322, "Baureihe 403", "(ICE 3)", "Solingen"),
            new datensatzstamm(307, "Baureihe 403", "(ICE 3)", "Oberhausen"),
            new datensatzstamm(314, "Baureihe 403", "(ICE 3)", "Bergisch Gladbach"),
            new datensatzstamm(4712, "Baureihe 407", "(ICE 3M)", "Dillingen a.d. Donau"),
            new datensatzstamm(159, "Baureihe 401", "(ICE 1)", "Bad Oldesloe"),
            new datensatzstamm(328, "Baureihe 403", "(ICE 3)", "Aachen"),
            new datensatzstamm(1162, "Baureihe 411", "(ICE T)", "Vaihingen an der Enz"),
            new datensatzstamm(223, "Baureihe 402", "(ICE 2)", "Schwerin"),
            new datensatzstamm(235, "Baureihe 402", "(ICE 2)", "Görlitz"),
            new datensatzstamm(242, "Baureihe 402", "(ICE 2)", "Quedlinburg"),
            new datensatzstamm(1170, "Baureihe 411", "(ICE T)", "Prenzlau"),
            new datensatzstamm(4610, "Baureihe 406", "(ICE 3M)", "Frankfurt am Main"),
            new datensatzstamm(152, "Baureihe 401", "(ICE 1)", "Hanau"),
            new datensatzstamm(1155, "Baureihe 411", "(ICE T)", "Mühlhausen/Thüringen"),
            new datensatzstamm(305, "Baureihe 403", "(ICE 3)", "Baden-Baden"),
            new datensatzstamm(1504, "Baureihe 415", "(ICE T)", "Heidelberg"),
            new datensatzstamm(4710, "Baureihe 407", "(ICE 3)", "Ansbach"),
            new datensatzstamm(353, "Baureihe 403", "(ICE 3)", "Neu-Ulm"),
            new datensatzstamm(4651, "Baureihe 406", "(ICE 3M)", "Amsterdam"),
            new datensatzstamm(117, "Baureihe 401", "(ICE 1)", "Hof"),
            new datensatzstamm(1112, "Baureihe 411", "(ICE T)", "Freie und Hansestadt Hamburg"),
            new datensatzstamm(241, "Baureihe 402", "(ICE 2)", "Bad Hersfeld"),
            new datensatzstamm(315, "Baureihe 403", "(ICE 3)", "Singen (Hohentwiel)"),
            new datensatzstamm(238, "Baureihe 402", "(ICE 2)", "Saarbrücken"),
            new datensatzstamm(157, "Baureihe 401", "(ICE 1)", "Landshut"),
            new datensatzstamm(110, "Baureihe 401", "(ICE 1)", "Gelsenkirchen"),
            new datensatzstamm(203, "Baureihe 402", "(ICE 2)", "Cottbus/Chóśebuz"),
            new datensatzstamm(181, "Baureihe 401", "(ICE 1)", "Interlaken"),
            new datensatzstamm(5517, "Baureihe 605", "(ICE-TD)", "København"),
            new datensatzstamm(4607, "Baureihe 406", "(ICE 3M)", "Hannover"),
            new datensatzstamm(319, "Baureihe 403", "(ICE 3)", "Duisburg"),
            new datensatzstamm(1190, "Baureihe 411", "(ICE T)", "Wien"),
            new datensatzstamm(333, "Baureihe 403", "(ICE 3)", "Goslar"),
            new datensatzstamm(240, "Baureihe 402", "(ICE 2)", "Bochum"),
            new datensatzstamm(217, "Baureihe 402", "(ICE 2)", "Bergen auf Rügen"),
            new datensatzstamm(230, "Baureihe 402", "(ICE 2)", "Delitzsch"),
            new datensatzstamm(1119, "Baureihe 411", "(ICE T)", "Meißen"),
            new datensatzstamm(4611, "Baureihe 406", "(ICE 3M)", "Düsseldorf"),
            new datensatzstamm(1191, "Baureihe 411", "(ICE T)", "Salzburg"),
            new datensatzstamm(304, "Baureihe 403", "(ICE 3)", "München"),
            new datensatzstamm(190, "Baureihe 401", "(ICE 1)", "Ludwigshafen am Rhein"),
            new datensatzstamm(358, "Baureihe 403", "(ICE 3)", "St. Ingbert"),
            new datensatzstamm(318, "Baureihe 403", "(ICE 3)", "Münster (Westf.)"),
            new datensatzstamm(323, "Baureihe 403", "(ICE 3)", "Schaffhausen"),
            new datensatzstamm(162, "Baureihe 401", "(ICE 1)", "Geisenheim/Rheingau"),
            new datensatzstamm(1118, "Baureihe 411", "(ICE T)", "Plauen/Vogtland"),
            new datensatzstamm(1131, "Baureihe 411", "(ICE T)", "Trier"),
            new datensatzstamm(231, "Baureihe 402", "(ICE 2)", "Brandenburg an der Havel"),
            new datensatzstamm(1503, "Baureihe 415", "(ICE T)", "Altenbeken"),
            new datensatzstamm(222, "Baureihe 402", "(ICE 2)", "Eberswalde"),
            new datensatzstamm(1178, "Baureihe 411", "(ICE T)", "Ostseebad Warnemünde"),
            new datensatzstamm(169, "Baureihe 401", "(ICE 1)", "Worms"),
            new datensatzstamm(1164, "Baureihe 411", "(ICE T)", "Rödental"),
            new datensatzstamm(218, "Baureihe 402", "(ICE 2)", "Braunschweig"),
            new datensatzstamm(176, "Baureihe 401", "(ICE 1)", "Bremen"),
            new datensatzstamm(216, "Baureihe 402", "(ICE 2)", "Dessau"),
            new datensatzstamm(1157, "Baureihe 411", "(ICE T)", "Innsbruck"),
            new datensatzstamm(207, "Baureihe 402", "(ICE 2)", "Stendal"),
            new datensatzstamm(1501, "Baureihe 415", "(ICE T)", "Eisenach"),
            new datensatzstamm(101, "Baureihe 401", "(ICE 1)", "Gießen"),
            new datensatzstamm(120, "Baureihe 401", "(ICE 1)", "Lüneburg"),
            new datensatzstamm(178, "Baureihe 401", "(ICE 1)", "Bremerhaven"),
            new datensatzstamm(1126, "Baureihe 411", "(ICE T)", "Leipzig"),
            new datensatzstamm(1152, "Baureihe 411", "(ICE T)", "Travemünde"),
            new datensatzstamm(186, "Baureihe 401", "(ICE 1)", "Chur"),
            new datensatzstamm(1107, "Baureihe 411", "(ICE T)", "Pirna"),
            new datensatzstamm(114, "Baureihe 401", "(ICE 1)", "Friedrichshafen"),
            new datensatzstamm(158, "Baureihe 401", "(ICE 1)", "Gütersloh"),
            new datensatzstamm(325, "Baureihe 403", "(ICE 3)", "Ravensburg"),
            new datensatzstamm(317, "Baureihe 403", "(ICE 3)", "Recklinghausen"),
            new datensatzstamm(1177, "Baureihe 411", "(ICE T)", "Rathenow"),
            new datensatzstamm(1158, "Baureihe 411", "(ICE T)", "Falkenberg/Elster"),
            new datensatzstamm(324, "Baureihe 403", "(ICE 3)", "Fürth"),
            new datensatzstamm(1175, "Baureihe 411", "(ICE T)", "Villingen-Schwenningen"),
            new datensatzstamm(201, "Baureihe 402", "(ICE 2)", "Rheinsberg"),
            new datensatzstamm(204, "Baureihe 402", "(ICE 2)", "Bielefeld"),
            new datensatzstamm(311, "Baureihe 403", "(ICE 3)", "Wiesbaden"),
            new datensatzstamm(362, "Baureihe 403", "(ICE 3)", "Schwerte (Ruhr)"),
            new datensatzstamm(1127, "Baureihe 411", "(ICE T)", "Weimar"),
            new datensatzstamm(4602, "Baureihe 406", "(ICE 3M)", "Euregio Maas-Rhein"),
            new datensatzstamm(1165, "Baureihe 411", "(ICE T)", "Bad Oeynhausen"),
            new datensatzstamm(351, "Baureihe 403", "(ICE 3)", "Herford"),
            new datensatzstamm(1163, "Baureihe 411", "(ICE T)", "Ostseebad Binz"),
            new datensatzstamm(1161, "Baureihe 411", "(ICE T)", "Andernach"),
            new datensatzstamm(1506, "Baureihe 415", "(ICE T)", "Kassel"),
            new datensatzstamm(208, "Baureihe 402", "(ICE 2)", "Bonn"),
            new datensatzstamm(167, "Baureihe 401", "(ICE 1)", "Garmisch-Partenkirchen"),
            new datensatzstamm(210, "Baureihe 402", "(ICE 2)", "Fontanestadt Neuruppin"),
            new datensatzstamm(360, "Baureihe 403", "(ICE 3)", "Linz am Rhein"),
            new datensatzstamm(327, "Baureihe 403", "(ICE 3)", "Siegen"),
            new datensatzstamm(233, "Baureihe 402", "(ICE 2)", "Ulm"),
            new datensatzstamm(1502, "Baureihe 415", "(ICE T)", "Karlsruhe"),
            new datensatzstamm(212, "Baureihe 402", "(ICE 2)", "Potsdam"),
            new datensatzstamm(335, "Baureihe 403", "(ICE 3)", "Konstanz"),
            new datensatzstamm(113, "Baureihe 401", "(ICE 1)", "Frankenthal/Pfalz"),
            new datensatzstamm(119, "Baureihe 401", "(ICE 1)", "Osnabrück"),
            new datensatzstamm(224, "Baureihe 402", "(ICE 2)", "Saalfeld (Saale)"),
            new datensatzstamm(1151, "Baureihe 411", "(ICE T)", "Elsterwerda"),
            new datensatzstamm(161, "Baureihe 401", "(ICE 1)", "Bebra"),
            new datensatzstamm(219, "Baureihe 402", "(ICE 2)", "Hagen"),
            new datensatzstamm(168, "Baureihe 401", "(ICE 1)", "Crailsheim"),
            new datensatzstamm(337, "Baureihe 403", "(ICE 3)", "Stuttgart"),
            new datensatzstamm(174, "Baureihe 401", "(ICE 1)", "Zürich"),
            new datensatzstamm(4652, "Baureihe 406", "(ICE 3M)", "Arnhem"),
            new datensatzstamm(1156, "Baureihe 411", "(ICE T)", "Waren (Müritz)"),
            new datensatzstamm(359, "Baureihe 403", "(ICE 3)", "Leverkusen"),
            new datensatzstamm(153, "Baureihe 401", "(ICE 1)", "Neumünster"),
            new datensatzstamm(1129, "Baureihe 411", "(ICE T)", "Kiel"),
            new datensatzstamm(239, "Baureihe 402", "(ICE 2)", "Essen"),
            new datensatzstamm(1105, "Baureihe 411", "(ICE T)", "Dresden"),
            new datensatzstamm(1109, "Baureihe 411", "(ICE T)", "Güstrow"),
            new datensatzstamm(232, "Baureihe 402", "(ICE 2)", "Frankfurt (Oder)"),
            new datensatzstamm(309, "Baureihe 403", "(ICE 3)", "Aalen"),
            new datensatzstamm(1169, "Baureihe 411", "(ICE T)", "Tutzing"),
            new datensatzstamm(227, "Baureihe 402", "(ICE 2)", "Ludwigslust"),
            new datensatzstamm(1104, "Baureihe 411", "(ICE T)", "Erfurt"),
            new datensatzstamm(332, "Baureihe 403", "(ICE 3)", "Augsburg"),
            new datensatzstamm(321, "Baureihe 403", "(ICE 3)", "Krefeld"),
            new datensatzstamm(330, "Baureihe 403", "(ICE 3)", "Göttingen"),
            new datensatzstamm(4601, "Baureihe 406", "(ICE 3M)", "Europa/Europe"),
            new datensatzstamm(234, "Baureihe 402", "(ICE 2)", "Minden"),
            new datensatzstamm(316, "Baureihe 403", "(ICE 3)", "Siegburg"),
            new datensatzstamm(313, "Baureihe 403", "(ICE 3)", "Treuchtlingen"),
            new datensatzstamm(1192, "Baureihe 411", "(ICE T)", "Linz"),
            new datensatzstamm(1110, "Baureihe 411", "(ICE T)", "Naumburg (Saale)"),
            new datensatzstamm(334, "Baureihe 403", "(ICE 3)", "Offenburg"),
            new datensatzstamm(310, "Baureihe 403", "(ICE 3)", "Wolfsburg"),
            new datensatzstamm(184, "Baureihe 401", "(ICE 1)", "Bruchsal"),
            new datensatzstamm(4603, "Baureihe 406", "(ICE 3M)", "Mannheim"),
            new datensatzstamm(1166, "Baureihe 411", "(ICE T)", "Bingen am Rhein"),
            new datensatzstamm(1132, "Baureihe 411", "(ICE T)", "Wittenberge"),
            new datensatzstamm(229, "Baureihe 402", "(ICE 2)", "Templin"),
            new datensatzstamm(1113, "Baureihe 411", "(ICE T)", "Hansestadt Stralsund"),
            new datensatzstamm(1103, "Baureihe 411", "(ICE T)", "Paderborn"),
            new datensatzstamm(215, "Baureihe 402", "(ICE 2)", "Bitterfeld-Wolfen"),
            new datensatzstamm(355, "Baureihe 403", "(ICE 3)", "Tuttlingen"),
            new datensatzstamm(237, "Baureihe 402", "(ICE 2)", "Neustrelitz"),
            new datensatzstamm(206, "Baureihe 402", "(ICE 2)", "Magdeburg"),
            new datensatzstamm(1160, "Baureihe 411", "(ICE T)", "Markt Holzkirchen"),
            new datensatzstamm(103, "Baureihe 401", "(ICE 1)", "Neu-Isenburg"),
            new datensatzstamm(1101, "Baureihe 411", "(ICE T)", "Neustadt an der Weinstraße"),
            new datensatzstamm(363, "Baureihe 403", "(ICE 3)", "Weilheim i. OB"),
            new datensatzstamm(105, "Baureihe 401", "(ICE 1)", "Offenbach am Main"),
            new datensatzstamm(354, "Baureihe 403", "(ICE 3)", "Mittenwald"),
            new datensatzstamm(226, "Baureihe 402", "(ICE 2)", "Lutherstadt Wittenberg"),
            new datensatzstamm(221, "Baureihe 402", "(ICE 2)", "Lübbenau/Spreewald"),
            new datensatzstamm(228, "Baureihe 402", "(ICE 2)", "Altenburg"),
            new datensatzstamm(308, "Baureihe 403", "(ICE 3)", "Murnau am Staffelsee"),
            new datensatzstamm(108, "Baureihe 401", "(ICE 1)", "Lichtenfels"),
            new datensatzstamm(214, "Baureihe 402", "(ICE 2)", "Hamm (Westf.)"),
            new datensatzstamm(1154, "Baureihe 411", "(ICE T)", "Sonneberg"),
            new datensatzstamm(1130, "Baureihe 411", "(ICE T)", "Jena"),
            new datensatzstamm(336, "Baureihe 403", "(ICE 3)", "Ingolstadt"),
            new datensatzstamm(155, "Baureihe 401", "(ICE 1)", "Rosenheim"),
            new datensatzstamm(236, "Baureihe 402", "(ICE 2)", "Jüterbog"),
            new datensatzstamm(1174, "Baureihe 411", "(ICE T)", "Hansestadt Warburg"),
            new datensatzstamm(306, "Baureihe 403", "(ICE 3)", "Nördlingen"),
            new datensatzstamm(303, "Baureihe 403", "(ICE 3)", "Dortmund"),
            new datensatzstamm(4604, "Baureihe 406", "(ICE 3)", "Brussel/Bruxelles"),
            new datensatzstamm(301, "Baureihe 403", "(ICE 3)", "Freiburg im Breisgau"),
            new datensatzstamm(244, "Baureihe 402", "(ICE 2)", "Koblenz"),
            new datensatzstamm(352, "Baureihe 403", "(ICE 3)", "Mönchengladbach"),
            new datensatzstamm(1168, "Baureihe 411", "(ICE T)", "Ellwangen"),
            new datensatzstamm(320, "Baureihe 403", "(ICE 3)", "Weil am Rhein"),
            new datensatzstamm(361, "Baureihe 403", "(ICE 3)", "Celle"),
            new datensatzstamm(1171, "Baureihe 411", "(ICE T)", "Oschatz"),
            new datensatzstamm(1117, "Baureihe 411", "(ICE T)", "Erlangen"),
            new datensatzstamm(209, "Baureihe 402", "(ICE 2)", "Riesa"),
            new datensatzstamm(211, "Baureihe 402", "(ICE 2)", "Uelzen"),
            new datensatzstamm(1102, "Baureihe 411", "(ICE T)", "Neubrandenburg"),
            new datensatzstamm(1128, "Baureihe 411", "(ICE T)", "Reutlingen"),
            new datensatzstamm(205, "Baureihe 402", "(ICE 2)", "Zwickau"),
            new datensatzstamm(1182, "Baureihe 411", "(ICE T)", "Mainz"),
            new datensatzstamm(1522, "Baureihe 415", "(ICE T)", "Torgau"),
            new datensatzstamm(4683, "Baureihe 406", "(ICE 3MF)", "Limburg an der Lahn"),
            new datensatzstamm(1173, "Baureihe 411", "(ICE T)", "Halle (Saale)"),
            new datensatzstamm(1176, "Baureihe 411", "(ICE T)", "Coburg"),
            new datensatzstamm(1180, "Baureihe 411", "(ICE T)", "Darmstadt"),
            new datensatzstamm(1181, "Baureihe 411", "(ICE T)", "Horb am Neckar"),
            new datensatzstamm(1520, "Baureihe 415", "(ICE T)", "Gotha"),
            new datensatzstamm(1521, "Baureihe 415", "(ICE T)", "Homburg/Saar"),
            new datensatzstamm(106, "Baureihe 401", "(ICE 1)", "Itzehoe"),
            new datensatzstamm(107, "Baureihe 401", "(ICE 1)", "Plattling"),
            new datensatzstamm(357, "Baureihe 403", "(ICE 3)", "Esslingen am Neckar"),
            new datensatzstamm(1184, "Baureihe 411", "(ICE T)", "Kaiserslautern"),
            new datensatzstamm(1524, "Baureihe 415", "(ICE T)", "Hansestadt Rostock"),
            new datensatzstamm(1108, "Baureihe 411", "(ICE T)", "Berlin"),
            new datensatzstamm(1111, "Baureihe 411", "(ICE T)", "Hansestadt Wismar"),
            new datensatzstamm(4682, "Baureihe 406", "(ICE 3M)", "Köln"),
            new datensatzstamm(188, "Baureihe 401", "(ICE 1)", "Hildesheim"),
            new datensatzstamm(180, "Baureihe 401", "(ICE 1)", "Castrop-Rauxel"),
            new datensatzstamm(182, "Baureihe 401", "(ICE 1)", "Rüdesheim am Rhein"),
            new datensatzstamm(1159, "Baureihe 411", "(ICE T)", "Passau"),
            new datensatzstamm(1505, "Baureihe 415", "(ICE T)", "Marburg"),
            new datensatzstamm(183, "Baureihe 401", "(ICE 1)", "Timmendorfer Strand"),
            new datensatzstamm(4680, "Baureihe 406", "(ICE 3MF)", "Würzburg"),
            new datensatzstamm(312, "Baureihe 403", "(ICE 3)", "Montabaur"),
            new datensatzstamm(185, "Baureihe 401", "(ICE 1)", "Freilassing"),
            new datensatzstamm(4684, "Baureihe 406", "(ICE 3MF)", "Forbach-Lorraine"),
            new datensatzstamm(112, "Baureihe 401", "(ICE 1)", "Memmingen"),
            new datensatzstamm(115, "Baureihe 401", "(ICE 1)", "Regensburg"),
            new datensatzstamm(302, "Baureihe 403", "(ICE 3)", "Hansestadt Lübeck"),
            new datensatzstamm(175, "Baureihe 401", "(ICE 1)", "Nürnberg"),
            new datensatzstamm(1183, "Baureihe 411", "(ICE T)", "Oberursel (Taunus)"),
            new datensatzstamm(104, "Baureihe 401", "(ICE 1)", "Fulda"),
            new datensatzstamm(187, "Baureihe 401", "(ICE 1)", "Mühldorf a. Inn"),
            new datensatzstamm(173, "Baureihe 401", "(ICE 1)", "Basel"),
            new datensatzstamm(177, "Baureihe 401", "(ICE 1)", "Rendsburg"),
            new datensatzstamm(331, "Baureihe 403", "(ICE 3)", "Westerland/Sylt"),
            new datensatzstamm(156, "Baureihe 401", "(ICE 1)", "Heppenheim/Bergstraße"),
            new datensatzstamm(172, "Baureihe 401", "(ICE 1)", "Aschaffenburg"),
            new datensatzstamm(154, "Baureihe 401", "(ICE 1)", "Flensburg"),
            new datensatzstamm(225, "Baureihe 402", "(ICE 2)", "Oldenburg (Oldb)"),
            new datensatzstamm(4685, "Baureihe 406", "(ICE 3MF)", "Schwäbisch Hall"),
            new datensatzstamm(160, "Baureihe 401", "(ICE 1)", "Mülheim an der Ruhr"),
            new datensatzstamm(1172, "Baureihe 411", "(ICE T)", "Bamberg"),
            new datensatzstamm(102, "Baureihe 401", "(ICE 1)", "Jever"),
            new datensatzstamm(1523, "Baureihe 415", "(ICE T)", "Hansestadt Greifswald")));
    private ScrollView scview;
    private LinearLayout container;

    private Toolbar toolbar;
    public Menu men;
    public EditText et;
    public Button suche_go;

    public static tinydb database;
    public static ArrayList<datensatzeintrag> eintrage;
    public static ArrayList<datensatzeintrag_mit_datum> eintrag_mit_datum;
    public static boolean fnoentry;
    public static boolean fsaw;
    public static boolean frode;
    public static boolean f401;
    public static boolean f402;
    public static boolean f403;
    public static boolean f406;
    public static boolean f407;
    public static boolean f411;
    public static boolean f415;
    public static boolean f605;
    public static boolean reverse;
    public static int sort_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Lade-Daten", Toast.LENGTH_SHORT).show();
        getSupportActionBar().setTitle("ICE-Spotting");
        getSupportActionBar().setSubtitle("Zugliste");
        database = new tinydb(MainActivity.this);
        //stammdaten=stammdaten_ohne_filter;
        //eintrage=lade_eintrage();
        eintrag_mit_datum=lade_eintrage();
        scview=findViewById(R.id.zugliste);
        container=findViewById(R.id.zugcontainer);
        //suche_go=findViewById(R.id.suche_go);
        //et=findViewById(R.id.input_suche);

        //suche_go.setOnClickListener(this);
        lade_filter();
        lade_sort();
        befulle_zugliste(stammdaten);
    }

    @Override
    public void onClick(View v){
        int id = v.getId();
        if (id<10000){
            String str = String.valueOf(id);
            if(!str.equals("null")) {
                Intent actvar = new Intent(MainActivity.this, trainview.class);
                actvar.putExtra("id", str);
                startActivity(actvar);
            }
            //auf Zugnummer gedrüct
        } else if (id<20000) {
            //auf Baureihe grdrückt
            String str = String.valueOf(id-10000);
            if(!str.equals("null")) {
                Intent actvar = new Intent(MainActivity.this, infos_zu_br.class);
                actvar.putExtra("id", str);
                startActivity(actvar);
            }
        } else if (id<30000) {
            //auf ICE gedrückt erstmall abgeschaft
        } else if (id==suche_go.getId()) {
            container.removeAllViews();
            String in  = et.getText().toString();
            filter_with(in.trim());
            System.out.println("Suche mit: " + in.trim());
        }
    }
    @Override
    public void onResume(){
        super.onResume();
        lade_filter();
        lade_sort();
        befulle_zugliste(stammdaten);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.mymenu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.suche).getActionView();
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {

                filter_with("");
                return false;
            }
        });

        final SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length()>2 || newText.length()==0){
                    container.removeAllViews();
                    filter_with(newText.trim());
                }
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("ICH WERDE GERUFEN");
                //MenuItem item = menu.findItem(R.id.mybutton);
                //item.setVisible(true);
                container.removeAllViews();
                filter_with(query.trim());
                searchView.clearFocus();
                return true;
            }
        };
        searchView.setOnQueryTextListener(queryTextListener);

        men=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            this.onBackPressed();
        } else if (id == R.id.filter) {
            startActivity(new Intent(MainActivity.this, filter_trains.class));
        } else if (id == R.id.sortierung) {
            startActivity(new Intent(MainActivity.this, sort_trains.class));
        } else if (id == R.id.suche) {
            //scview.fullScroll(ScrollView.FOCUS_UP);
            //et.setActivated(true);
            //EditText et = (EditText) men.findItem(R.id.et);
            //et.setActivated(men.findItem(R.id.et).isVisible());
        } else if (id == R.id.impressum) {
            startActivity(new Intent(MainActivity.this, impressum.class));
        }
        return true;
    }

    private void befulle_zugliste(ArrayList<datensatzstamm> input){
        //Toast.makeText(this, "Jetzt solte sich die Liste aktualisieren.", Toast.LENGTH_LONG).show();
        container.removeAllViews();
        container.requestLayout();
        input=sortiere(input);

        for(datensatzstamm entry: input){
            Boolean erstep=false;
            LinearLayout dateneintrag = new LinearLayout(this);
            dateneintrag.removeAllViews();
            LinearLayout zeile = new LinearLayout(this);
            zeile.removeAllViews();
            LinearLayout attr = new LinearLayout(this);
            attr.removeAllViews();
            TableLayout tl = new TableLayout(this);
            tl.removeAllViews();
            TableRow tr = new TableRow(this);
            tr.removeAllViews();
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            LinearLayout.LayoutParams lp_zeile = lp;
            lp_zeile.setMargins(0,0,0,10);
            TextView tv = new TextView(this);
            Button zugnummer = new Button(this);
            Button baureihe = new Button(this);
            Button icetyp = new Button(this);
            View div = makediv(this);
            ImageView sehen = new ImageView(this);
            ImageView fahren = new ImageView(this);
            LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(64,64);
            Typeface Typeface = null;


            dateneintrag.setLayoutParams(lp_zeile);
            dateneintrag.setOrientation(LinearLayout.VERTICAL);
            zeile.setLayoutParams(lp);
            zeile.setOrientation(LinearLayout.HORIZONTAL);
            attr.setLayoutParams(lp);
            attr.setOrientation(LinearLayout.HORIZONTAL);
            attr.setGravity(Gravity.RIGHT);
            tl.setLayoutParams(lp);
            tl.setShrinkAllColumns(true);
            tl.setColumnStretchable(0,true);
            tr.setLayoutParams(lp);
            tv.setText("   " + entry.name);
            tv.setTextSize(20);
            tv.setTypeface(Typeface, Typeface.BOLD);
            sehen.setImageResource(R.drawable.gesehen);
            fahren.setImageResource(R.drawable.gefahren);
            sehen.setLayoutParams(ll);
            fahren.setLayoutParams(ll);
            zugnummer.setText("Tr.: " + String.valueOf(entry.zahl));
            zugnummer.setId(entry.zahl);
            zugnummer.setBackground(getDrawable(R.drawable.shape_train));
            zugnummer.setPadding(50,10,20,10);
            zugnummer.setOnClickListener(this);
            baureihe.setText(entry.br);
            baureihe.setId(entry.zahl+10000);
            baureihe.setBackground(getDrawable(R.drawable.shape_train));
            baureihe.setPadding(50,10,20,10);
            baureihe.setOnClickListener(this);
            icetyp.setText(entry.typ);
            icetyp.setTypeface(Typeface, Typeface.ITALIC);
            icetyp.setBackground(getDrawable(R.drawable.shape_wagon));
            icetyp.setPadding(20,10,20,10);
            if (zug_wurde_gesehen(entry.zahl)){
                attr.addView(sehen);
            }
            if (zug_wurde_gefahren(entry.zahl)){
                attr.addView(fahren);
            }
            tr.addView(tv);
            tr.addView(zugnummer);
            tl.addView(tr);
            dateneintrag.addView(tl);
            zeile.addView(baureihe);
            zeile.addView(icetyp);
            dateneintrag.addView(zeile);
            dateneintrag.addView(attr);
            dateneintrag.addView(div);

            //filterung nach den Häckchen
            if (f401 && entry.br.contains("401")) {
                erstep=true;
            } else if (f402 && entry.br.contains("402")) {
                erstep=true;
            } else if (f403 && entry.br.contains("403")) {
                erstep=true;
            } else if (f406 && entry.br.contains("406")) {
                erstep=true;
            } else if (f407 && entry.br.contains("407")) {
                erstep=true;
            } else if (f411 && entry.br.contains("411")) {
                erstep=true;
            } else if (f415 && entry.br.contains("415")) {
                erstep=true;
            } else if (f605 && entry.br.contains("605")) {
                erstep=true;
            }
            if(erstep){
                if(fnoentry && !zug_wurde_gesehen(entry.zahl) && !zug_wurde_gefahren(entry.zahl)){
                    container.addView(dateneintrag);
                } else if (fsaw && zug_wurde_gesehen(entry.zahl)) {
                    container.addView(dateneintrag);
                } else if (frode && zug_wurde_gefahren(entry.zahl)) {
                    container.addView(dateneintrag);
                }
            }
        }
        container.invalidate();
    }

    public void filter_with(String input){
        ArrayList<datensatzstamm> filtered_list = new ArrayList<datensatzstamm>();
        for(datensatzstamm el: stammdaten){
            if(el.name.toLowerCase().contains(input.toLowerCase()) || String.valueOf(el.zahl).contains(input)){
                filtered_list.add(el);
            }
        }
        befulle_zugliste(filtered_list);
    }

    public static View makediv(Context con){
        View v = new View(con);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 7);
        v.setLayoutParams(lp);
        v.setBackgroundColor(Color.parseColor("#ff0000"));
        return v;
    }

    public static datensatzstamm find_datensatz(int input){
        for(datensatzstamm el: stammdaten){
            if (el.zahl==input){
                return el;
            }
        }
        return null;
    }

    public ArrayList<datensatzeintrag_mit_datum> lade_eintrage(){
        ArrayList<datensatzeintrag_mit_datum> temp = new ArrayList<datensatzeintrag_mit_datum>();
        temp=database.getListObject_new("user-input_new", temp);
        if(temp.size()<1){
            ArrayList<datensatzeintrag> tempy = new ArrayList<datensatzeintrag>();
            tempy=database.getListObject("user-input", tempy);
            temp=convert_eintrage(temp, tempy);
        }
        return temp;
    }
    /*public ArrayList<datensatzeintrag> lade_eintrage(){
        ArrayList<datensatzeintrag> temp = new ArrayList<datensatzeintrag>();
        temp=database.getListObject("user-input", temp);
        return temp;
    }
     */

    public ArrayList<datensatzeintrag_mit_datum> convert_eintrage(ArrayList<datensatzeintrag_mit_datum> a, ArrayList<datensatzeintrag> b){
        for (datensatzeintrag el: b){
         datensatzeintrag_mit_datum z = new datensatzeintrag_mit_datum(el.zug_id, el.gesehen, el.gefahren, el.bemerkung);
         a.add(z);
        }
        return a;
    }

    public static void del_eintrag(datensatzeintrag_mit_datum input){
        eintrage:eintrag_mit_datum.remove(input);
        save_eintrage();
    }
    public static void save_eintrage(){
        database.putListObject_new("user-input_new", eintrag_mit_datum);
    }
    public static void sichtung_add(datensatzeintrag_mit_datum el){
        if(eintrag_mit_datum==null){
            eintrag_mit_datum = new ArrayList<datensatzeintrag_mit_datum>();
        }
        eintrag_mit_datum.add(el);
        save_eintrage();
    }
    public ArrayList<datensatzeintrag_mit_datum> finde_entry_zu_zug(int input){
        ArrayList<datensatzeintrag_mit_datum> temp = new ArrayList<datensatzeintrag_mit_datum>();
        for (datensatzeintrag_mit_datum el: eintrag_mit_datum){
            if (el.zug_id==input){
                temp.add(el);
            }
        }
        return temp;
    }

    public boolean zug_wurde_gesehen(int input){
        for(datensatzeintrag_mit_datum el: finde_entry_zu_zug(input)){
            if(el.gesehen){
                return true;
            }
        }
        return false;
    }
    public boolean zug_wurde_gefahren(int input){
        for(datensatzeintrag_mit_datum el: finde_entry_zu_zug(input)){
            if(el.gefahren){
                return true;
            }
        }
        return false;
    }
    public static void lade_filter(){
        fnoentry=database.getBoolean_true("noentry");
        fsaw=database.getBoolean_true("saw");
        frode=database.getBoolean_true("rode");
        f401=database.getBoolean_true("401");
        f402=database.getBoolean_true("402");
        f403=database.getBoolean_true("403");
        f406=database.getBoolean_true("406");
        f407=database.getBoolean_true("407");
        f411=database.getBoolean_true("411");
        f415=database.getBoolean_true("415");
        f605=database.getBoolean_true("605");
        save_filter();
    }
    public static void save_filter(){
        database.putBoolean("noentry", fnoentry);
        database.putBoolean("saw", fsaw);
        database.putBoolean("rode", frode);
        database.putBoolean("401", f401);
        database.putBoolean("402", f402);
        database.putBoolean("403", f403);
        database.putBoolean("406", f406);
        database.putBoolean("407", f407);
        database.putBoolean("411", f411);
        database.putBoolean("415", f415);
        database.putBoolean("605", f605);
    }
    public static  void lade_sort(){
        reverse=database.getBoolean("sort_rev");
        sort_type=database.getInt("sort_type");
        if (sort_type==0){
            sort_type=2;
        }
        save_sort();
    }

    public static void save_sort(){
        database.putBoolean("sort_rev", reverse);
        database.putInt("sort_type", sort_type);
    }
    public ArrayList<datensatzstamm> sortiere(ArrayList<datensatzstamm> in){
        if(sort_type==1){
            //Sort nach Zugname
            in.sort(new Comparator<datensatzstamm>() {
                @Override
                public int compare(datensatzstamm t1, datensatzstamm t2) {
                    return t1.name.compareTo(t2.name);
                }
            });
        } else if (sort_type==2) {
            //Sort nach Zugnummer
            in.sort(new Comparator<datensatzstamm>() {
                @Override
                public int compare(datensatzstamm t1, datensatzstamm t2) {
                    return t1.zahl - t2.zahl;
                }
            });
        } else if (sort_type==3) {
            //Sort nach BR müssen wir noch etwas ändern.
            in.sort(new Comparator<datensatzstamm>() {
                @Override
                public int compare(datensatzstamm t1, datensatzstamm t2) {
                    if(t1.getbrint()<t2.getbrint()) {
                        return -1;
                    } else if (t1.getbrint()>t2.getbrint()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
        } else if(sort_type==0){
            //Standart_sortierung
            //in=stammdaten_ohne_filter;
            //Sortierung wurde ausgebaut, es sollte immer nach Sort=1 geändert werden.
        }
        if(reverse){
            Collections.reverse(in);
        }
        return in;
    }
}