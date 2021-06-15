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

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.IOException;

public class Controlleur {

    private MainGraphique vue;
    private int etat;
    private Fichier fichier;
    String text;

    public Controlleur(MainGraphique vue)
    {
        fichier = new Fichier();
        this.vue = vue;
        changeEtat(0);
    }


    public void changeEtat(int etat)
    {
        this.etat = etat;

        switch (etat) {

            case 0:
                vue.getText().setText("");
                vue.getEnregistrer().setDisable(true);
                break;

            case 1:
                this.vue.getText().setText("Analyse en cours...");
                try {
                    text = fichier.analyser();
                    if(!text.equals("Début du rapport : \n \n" + "Fin du rapport."))
                    {
                        this.vue.getText().setFill(Color.BLACK);
                        if(!fichier.hasConnection())
                        {
                            this.vue.getText().setText("---------------- Aucun nom de domaine n'a été trouvé. ---------------- \n" +
                                    "---------------- Vérifiez votre connection internet. ---------------- \n \n" +
                                    text);
                        }
                        else
                        {
                            this.vue.getText().setText(text);
                        }
                        vue.getEnregistrer().setDisable(false);
                    }
                    else
                    {
                        this.vue.getText().setText("Impossible d'analyser le fichier.");
                    }
                } catch (IOException e) {
                    this.vue.getText().setFill(Color.RED);
                    this.vue.getText().setText("Il y a eu une erreur.");
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    fichier.sauvegarder();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }

    }
}
