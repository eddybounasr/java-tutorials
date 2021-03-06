/*
 * Copyright © <Pascal Fares @ ISSAE - Cnam Liban>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), 
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions: 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * The Software is provided “as is”, without warranty of any kind, express or implied, including but not limited to the warranties of merchantability, 
 * fitness for a particular purpose and noninfringement. In no event shall the authors or copyright holders be liable for any claim, damages or other liability, 
 * whether in an action of contract, tort or otherwise, arising from, out of or in connection with the software or the use or other dealings in the Software. »
 */
package net.cofares.libListesRes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pascalfares
 */
public class FonctionsSurListes {
    public static Integer lMax(List<Integer> l) throws Exception {
        if ((l==null) || (l.size()==0)) {
            //Pas de max de liste vide faire uhe exception
            throw new Exception("Pas de max de liste vide...");
        }
        //Si ici liste non vide et non null
        if (l.size() == 1) return l.get(0);
        if (l.size()==2) return ((l.get(0) > l.get(1)) ? l.get(0) : l.get(1));
        //Split the lists
        int half = l.size()/2;
        List<Integer> l1 = l.subList(0, half);
        List<Integer> l2 = l.subList(half, l.size());
        Integer m1,m2;
        m1=lMax(l1);
        m2=lMax(l2);
        return ((m1>m2) ? m1 : m2);
    }
    
    public static Integer lMax2(List<Integer> l,int debut, int fin) throws Exception {
        if ((fin -debut)<=0) {
            //Pas de max de liste vide faire uhe exception
            throw new Exception("Pas de max de liste vide...");
        }
        //Si ici liste non vide et non null
        if ((fin -debut)==1) return l.get(debut);
        if ((fin-debut)==2) return ((l.get(debut) > l.get(fin)) ? l.get(debut) : l.get(fin));
        //Split the lists
        int half = (fin-debut)/2;
        //List<Integer> l1 = l.subList(0, half);
        //List<Integer> l2 = l.subList(half, l.size());
        Integer m1,m2;
        m1=lMax2(l,debut,debut+half);
        m2=lMax2(l,debut+half,fin);
        return ((m1>m2) ? m1 : m2);
    }
}
