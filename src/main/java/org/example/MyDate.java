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
    private final int jour;
    private final String mois;
    private final int annee;
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

    @Override
    public String toString() {
        String s;
        s = jour + " " + mois + " " + annee;

        if(secondes != 0 || minutes != 0 || heures != 0 || milis != 0)
        {
            s += " à " + heures + " heures " + minutes + " minutes " + secondes;
            if(milis != 0)
            {
                s += "," + milis;
            }

            s += " secondes";
        }

        return s;
    }

    public MyDate(int jour, int mois, int annee)
    {
        this.jour = jour;
        this.mois = tradMois(mois);
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
        this.mois = tradMois(mois);
        this.annee = annee;
    }

    public MyDate(String  secondes, String minutes, String heures, String jour, String mois, String annee)
    {
        this.detaillee = true;
        this.secondes = Double.parseDouble(secondes);
        this.minutes = Integer.parseInt(minutes);
        this.heures = Integer.parseInt(heures);
        this.jour = Integer.parseInt(jour);
        this.mois = tradMois(mois);
        this.annee = Integer.parseInt(annee);
    }

    public static String tradMois(String mois)
    {
        String s = "";
        switch (Integer.parseInt(mois))
        {
            case 1:
                s = "Janvier";
                break;
            case 2:
                s = "Février";
                break;
            case 3:
                s = "Mars";
                break;
            case 4:
                s = "Avril";
                break;
            case 5:
                s = "Mai";
                break;
            case 6:
                s = "Juin";
                break;
            case 7:
                s = "Juillet";
                break;
            case 8:
                s = "Aout";
                break;
            case 9:
                s = "Septembre";
                break;
            case 10:
                s = "Octobre";
                break;
            case 11:
                s = "Novembre";
                break;
            case 12:
                s = "Décembre";
                break;

        }
        return s;
    }

    public static String tradMois(int mois)
    {
        String s = "";
        switch (mois)
        {
            case 1:
                s = "Janvier";
                break;
            case 2:
                s = "Février";
                break;
            case 3:
                s = "Mars";
                break;
            case 4:
                s = "Avril";
                break;
            case 5:
                s = "Mai";
                break;
            case 6:
                s = "Juin";
                break;
            case 7:
                s = "Juillet";
                break;
            case 8:
                s = "Aout";
                break;
            case 9:
                s = "Septembre";
                break;
            case 10:
                s = "Octobre";
                break;
            case 11:
                s = "Novembre";
                break;
            case 12:
                s = "Décembre";
                break;

        }
        return s;
    }

}
