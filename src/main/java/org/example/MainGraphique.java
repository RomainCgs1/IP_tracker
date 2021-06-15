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

import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class MainGraphique extends BorderPane {

    private MyB ouvrirPdf;
    private MyB enregistrer;
    private HBox HBMenu;
    private MyText text;
    private ScrollPane scrollPane;
    private Controlleur controlleur;

    public MyB getOuvrirPdf() {
        return ouvrirPdf;
    }

    public MyB getEnregistrer() {
        return enregistrer;
    }

    public HBox getHBMenu() {
        return HBMenu;
    }

    public MyText getText() {
        return text;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public MainGraphique()
    {
        this.ouvrirPdf = new MyB("Analyser un fichier");
        this.enregistrer = new MyB("Enregistrer");
        this.HBMenu = new HBox(this.ouvrirPdf, this.enregistrer);
        this.setTop(this.HBMenu);
        this.text = new MyText("test");
        text.setText(text.getText() + "\nbonjour");
        scrollPane = new ScrollPane(text);
        
        this.setCenter(this.scrollPane);


        this.controlleur = new Controlleur(this);

        ouvrirPdf.setOnAction(
                action -> {
                    controlleur.changeEtat(1);
                }
        );

        this.enregistrer.setOnAction(
                action -> {
                    controlleur.changeEtat(2);
                }
        );

    }

}
