/*
 * Copyright (c) 2021. Romain Cognasse
 *
 * This file is part of IP tracker.
 *
 * IP tracker is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * IP tracker is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with IP tracker.
 * If not, see <http://www.gnu.org/licenses/>.
 */

package org.example;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fichier {

    String chemin;
    String saveChemin;

    String contenu;
    MyDate date;

    public boolean hasConnection() {
        return connection;
    }

    private boolean connection = false;

    public Fichier()
    {
        chemin = "";
        contenu  = "";
    }

    public Fichier(String chemin)
    {
        this.chemin = chemin;
        this.contenu = "";
    }

    public Fichier(String chemin, String contenu)
    {
        this.chemin = chemin;
        this.contenu = contenu;
    }

    public String analyser() throws IOException {

        FileChooser fileChooser = new FileChooser();
        if(chemin != null)
        {
            fileChooser.setInitialDirectory(new File(chemin));
        }
        fileChooser.setTitle("Choisir le fichier à ouvir");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("PDF files (*.pdf", "*.pdf");
        fileChooser.getExtensionFilters().add(filter);
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        System.out.println(selectedFile);

        if (selectedFile != null)
        {
            //récupération de la date
            if(selectedFile.getName().contains("imputabilities_logs"))
            {
                String[] path = selectedFile.getName().split("/");
                String name = path[path.length-1];
                String[] splitName = name.split(" ")[0].split("-");
                String annee = splitName[1];
                String mois = splitName[2];
                String jour = "";
                int a = 0;
                char caract = splitName[3].charAt(0);
                if(splitName[3].length() == 2) {
                    jour = splitName[3];
                } else {
                    while(caract != '.' && a<3) {
                        jour = jour + caract;
                        a++;
                        caract = splitName[3].charAt(a);
                    }
                }
                if(a < 3)
                {
                    date = new MyDate(Integer.parseInt(jour), Integer.parseInt(mois), Integer.parseInt(annee));
                }

                chemin = selectedFile.getAbsolutePath();

                File file = new File(chemin);
                String[] sText = null;


                PDDocument document = Loader.loadPDF(file);
                document.getClass();

                if (!document.isEncrypted()) {

                    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                    stripper.setSortByPosition(true);

                    PDFTextStripper tStripper = new PDFTextStripper();

                    String pdfFileInText = tStripper.getText(document);
                    //System.out.println("Text:" + st);

                    // split by whitespace
                    sText = pdfFileInText.split("\\r?\\n");
                }

                String user = "";

                if(date != null)
                {
                    this.contenu = this.contenu + "Archive des journaux du " + date + "\n";
                }

                this.contenu = this.contenu + "Début du rapport : \n \n";

                for (int i = 1; i < sText.length; i++) {
                    if (sText[i].split(" ")[0].equals("Username")) {
                        user = sText[i + 1].split(" ")[0];
                        System.out.println(user);
                        this.contenu = this.contenu + "Utilisateur : " + user + "\n";
                        int j = i + 10;
                        int nombre = 1;
                        while (sText[j].split(" ")[0].equals(nombre + ".")) {
                            nombre++;
                            j++;
                        }
                        nombre--;
                        String[] iP = new String[nombre];
                        String[] sDates = new String[nombre];
                        MyDate[] dates = new MyDate[nombre];
                        this.contenu = this.contenu +  "    IP consultées : \n";
                        for (int t = 0; t < nombre; t++) {
                            iP[t] = sText[i + 10 + t].split(" ")[3];

                            //récupération des dates des évenements
                            sDates[t] = sText[i + 10 + t].split(" ")[5] + " " + sText[i + 10 + t].split(" ")[6];

                            String sDate = sDates[t].split(" ")[0];
                            String[] splitDate = sDate.split("-");
                            String sHeure = sDates[t].split(" ")[1];
                            String[] splitHeure = sHeure.split(":");
                            dates[t] = new MyDate(splitHeure[2], splitHeure[1], splitHeure[0], splitDate[2], splitDate[1], splitDate[0]);
                            System.out.println(iP[t]);
                            String ip = iP[t];
                            String adresse = App.getAdress(ip);
                            System.out.println();
                            if(!adresse.contains("Inconnu"))
                            {
                                connection = true;
                            }

                            this.contenu = this.contenu +  "        " + (t + 1) + ". \n" +
                                    "           Le " + dates[t] + "\n" +
                                    "           IP : " + ip + "\n";
                            this.contenu = this.contenu +  "           Site trouvé : " + adresse + "\n";
                        }
                        this.contenu = this.contenu +  "\n";
                        i = i + nombre + 10;
                    }

                    System.out.println("Fin");
                    this.contenu = this.contenu + "Fin du rapport.";
                }

            }
            else {
                this.contenu = "Le fichier n'est pas reconnu (son nom ne contient pas \" imputabilities_logs\").";
            }

        } else {
            this.contenu = "Aucun fichier selectionné.";
        }

        return contenu;
    }



    public void sauvegarder() throws IOException {


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sauvegarder");
        fileChooser.setInitialFileName("Imputabilities_logs du " + this.date + " -- nom de domaine");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT files", "*txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        saveChemin = file.getAbsolutePath();
        File txt = new File(saveChemin);

        if (txt.createNewFile()) {
            System.out.println("File created : " + txt.getName());
        } else {
            System.out.println("File already exists.");

        }


        FileWriter myWriter = new FileWriter(saveChemin);
        myWriter.write(this.contenu);
        myWriter.close();
    }

}