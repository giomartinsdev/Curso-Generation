package desafioscondicionais;

import java.util.Scanner;

public class Desafio4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // Introdução e solicitação de entrada do usuário
        // Por boas praticas, todos os inputs devem ser minusculos e sem acentuacao
        System.out.println("por boas praticas, todos os inputs devem ser minusculos e sem acentuacao\n");
        System.out.println("digite se é invertebrado ou vertebrado: \n");
        String vertebraeOfAnimal = reader.next();

        System.out.println("digite se é mamifero, ave, inseto ou anelideo: \n");
        String typeOfAnimal = reader.next();

        System.out.println("digite se o animal é carnivero, onivoro, herbivoro ou hemafago: \n");
        String eatOfAnimal = reader.next();

        // Começa a estrutura de seleção usando switch
        switch (vertebraeOfAnimal) {
            case "vertebrado":
                // Caso o animal seja vertebrado
                switch (typeOfAnimal) {
                    case "ave":
                        // Caso o animal seja ave
                        switch (eatOfAnimal) {
                            case "carnivoro":
                                System.out.println("aguia"); // Saída para águia
                                break;
                            case "onivoro":
                                System.out.println("pomba"); // Saída para pomba
                                break;
                            default:
                                System.out.println("por favor insira carnivoro ou onivoro");
                        }
                        break;
                    case "mamifero":
                        // Caso o animal seja mamífero
                        switch (eatOfAnimal) {
                            case "onivoro":
                                System.out.println("homem"); // Saída para homem
                                break;
                            case "herbivoro":
                                System.out.println("vaca"); // Saída para vaca
                                break;
                            default:
                                System.out.println("por favor insira onivoro ou herbivoro");
                        }
                        break;
                    default:
                        System.out.println("por favor insira ave ou mamifero");
                }
                break;
            case "invertebrado":
                // Caso o animal seja invertebrado
                switch (typeOfAnimal) {
                    case "inseto":
                        // Caso o animal seja inseto
                        switch (eatOfAnimal) {
                            case "hematofago":
                                System.out.println("pulga"); // Saída para pulga
                                break;
                            case "herbivoro":
                                System.out.println("lagarta"); // Saída para lagarta
                                break;
                            default:
                                System.out.println("por favor insira hematofago ou herbivoro");
                        }
                        break;
                    case "anelideo":
                        // Caso o animal seja anelídeo (adicionado no comentário para correção)
                        switch (eatOfAnimal) {
                            case "hematofago":
                                System.out.println("sanguessuga"); // Saída para sanguessuga
                                break;
                            case "onivoro":
                                System.out.println("minhoca"); // Saída para minhoca
                                break;
                            default:
                                System.out.println("por favor insira hematofago ou onivoro");
                        }
                        break;
                    default:
                        System.out.println("por favor inseto ou anelideo");
                }
                break;
            default:
                System.out.println("por favor insira vertebrado ou invertebrado");
        }
    }
}
