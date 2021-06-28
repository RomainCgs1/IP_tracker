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

import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainGraphique extends BorderPane {

    private final MyB ouvrirPdf;
    private final MyB enregistrer;
    private final HBox HBMenu;
    private final MyText text;
    private final ScrollPane scrollPane;
    private final Controlleur controlleur;

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
