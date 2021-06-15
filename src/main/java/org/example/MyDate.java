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

public class MyDate {
    private int jour;
    private String mois;
    private int annee;
    private boolean detaillee = false;
    private int heures;
    private int minutes;
    private double secondes;
    private int milis;

    public boolean isDetaillee() {
        return detaillee;
    }

    public int getHeures() {
        return heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getSecondes() {
        return secondes;
    }

    public int getMilis() {
        return milis;
    }

    public int getJour() {
        return jour;
    }

    public String getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public MyDate(int jour, String mois, int annee)
    {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public MyDate(int jour, int mois, int annee)
    {
        this.jour = jour;

        switch (mois)
        {
            case 1:
                this.mois = "Janvier";
                break;
            case 2:
                this.mois = "Février";
                break;
            case 3:
                this.mois = "Mars";
                break;
            case 4:
                this.mois = "Avril";
                break;
            case 5:
                this.mois = "Mai";
                break;
            case 6:
                this.mois = "Juin";
                break;
            case 7:
                this.mois = "Juillet";
                break;
            case 8:
                this.mois = "Aout";
                break;
            case 9:
                this.mois = "Septembre";
                break;
            case 10:
                this.mois = "Octobre";
                break;
            case 11:
                this.mois = "Novembre";
                break;
            case 12:
                this.mois = "Décembre";
                break;

        }
        this.annee = annee;
    }

    //version avec heure précise

    public MyDate(int milis, int secondes, int minutes, int heures, int jour, String mois, int annee)
    {
        this.detaillee = true;
        this.milis = milis;
        this.secondes = secondes;
        this.minutes = minutes;
        this.heures = heures;
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public MyDate(int milis, int secondes, int minutes, int heures, int jour, int mois, int annee)
    {
        this.detaillee = true;
        this.milis = milis;
        this.secondes = secondes;
        this.minutes = minutes;
        this.heures = heures;
        this.jour = jour;

        switch (mois)
        {
            case 1:
                this.mois = "Janvier";
                break;
            case 2:
                this.mois = "Février";
                break;
            case 3:
                this.mois = "Mars";
                break;
            case 4:
                this.mois = "Avril";
                break;
            case 5:
                this.mois = "Mai";
                break;
            case 6:
                this.mois = "Juin";
                break;
            case 7:
                this.mois = "Juillet";
                break;
            case 8:
                this.mois = "Aout";
                break;
            case 9:
                this.mois = "Septembre";
                break;
            case 10:
                this.mois = "Octobre";
                break;
            case 11:
                this.mois = "Novembre";
                break;
            case 12:
                this.mois = "Décembre";
                break;

        }

        this.annee = annee;
    }

    public MyDate(String  secondes, String minutes, String heures, String jour, String mois, String annee)
    {
        this.detaillee = true;
        this.secondes = Double.parseDouble(secondes);
        this.minutes = Integer.parseInt(minutes);
        this.heures = Integer.parseInt(heures);
        this.jour = Integer.parseInt(jour);

        switch (Integer.parseInt(mois))
        {
            case 1:
                this.mois = "Janvier";
                break;
            case 2:
                this.mois = "Février";
                break;
            case 3:
                this.mois = "Mars";
                break;
            case 4:
                this.mois = "Avril";
                break;
            case 5:
                this.mois = "Mai";
                break;
            case 6:
                this.mois = "Juin";
                break;
            case 7:
                this.mois = "Juillet";
                break;
            case 8:
                this.mois = "Aout";
                break;
            case 9:
                this.mois = "Septembre";
                break;
            case 10:
                this.mois = "Octobre";
                break;
            case 11:
                this.mois = "Novembre";
                break;
            case 12:
                this.mois = "Décembre";
                break;

        }

        this.annee = Integer.parseInt(annee);
    }

}
