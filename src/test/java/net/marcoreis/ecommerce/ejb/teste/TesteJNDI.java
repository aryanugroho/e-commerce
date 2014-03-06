package net.marcoreis.ecommerce.ejb.teste;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;

public class TesteJNDI {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            NamingEnumeration<NameClassPair> lista = ctx.list("");
            //
            while (lista.hasMore()) {
                NameClassPair proximo = lista.nextElement();
                System.out.println(proximo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
