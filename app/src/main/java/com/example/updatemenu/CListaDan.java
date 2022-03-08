package com.example.updatemenu;

import java.util.ArrayList;

public class CListaDan implements IListaDan {

    public ArrayList<MPozycjaMenu> wybierzPozycjeDoZmiany(int pozycja)
    {
        ListaDan.remove(pozycja);
        return ListaDan;

    }
}
