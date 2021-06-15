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

import org.xbill.DNS.*;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class App 
{
    public static void main( String[] args ) {
        //System.out.println( "Hello World!" );
        //String ip = Lire.S();
        //InetAddress addr = Address.getByName(ip);
        //System.out.println(addr);
        String ip;
        InetAddress test = null;
        String nom = null;

        do
        {
            System.out.println("Saisir une addresse");
            ip = Lire.S();
            try {
                test = Address.getByAddress(ip);
                nom = Address.getHostName(test);
            } catch (UnknownHostException e) {
                System.out.println("Inconnu");
                nom = null;
            }
            System.out.println(nom);
        }while(ip != "stop" && ip != "");
    }

    public static String getAdress(String adresse) {
        InetAddress test = null;
        String nom;
        try {
            test = Address.getByAddress(adresse);
            nom = Address.getHostName(test);
        } catch (UnknownHostException e) {
            nom = "Inconnu";
            System.out.println(nom);
        }
        return nom;
    }
}
