package application;

import xadrez.PartidaXadrez;

public class Program {
    public static void main(String[] args) throws Exception {

        PartidaXadrez partidaXadrez = new PartidaXadrez();
        UI.printBoard(partidaXadrez.getPecas());

    }
}
