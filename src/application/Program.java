package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Program {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();
        List<PecaXadrez> capturados = new ArrayList<>();

        while (!partidaXadrez.getCheckMate()) {
            try {
                UI.limparTela();
                UI.imprimirPartida(partidaXadrez, capturados);
                System.out.println();
                System.out.print("Origem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

                boolean[][] possiveisMovimentos = partidaXadrez.possiveisMovimentos(origem);
                UI.limparTela();
                UI.imprimirMesa(partidaXadrez.getPecas(), possiveisMovimentos);

                System.out.println();
                System.out.print("Destino: ");
                PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

                PecaXadrez pecaCapturada = partidaXadrez.MovimentoXadrez(origem, destino);

                if (pecaCapturada != null) {
                    capturados.add(pecaCapturada);
                }

            } catch (XadrezException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        UI.limparTela();
        UI.imprimirPartida(partidaXadrez, capturados);

    }
}
