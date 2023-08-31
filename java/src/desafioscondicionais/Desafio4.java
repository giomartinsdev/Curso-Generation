package desafioscondicionais;

import java.util.Scanner;

public class Desafio4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //por boas praticas, todos os inputs devem ser minusculos e sem acentucao
        System.out.println("por boas praticas, todos os inputs devem ser minusculos e sem acentucao\n");
        System.out.println("digite se é invertebrado ou vertebrado: \n");
        String vertebraeOfAnimal = reader.next();

        System.out.println("digite se é mamifero, ave, inseto ou anelideo: \n");
        String typeOfAnimal = reader.next();

        System.out.println("digite se o animal é carnivero, onivoro, herbivoro ou hemafago: \n");
        String eatOfAnimal = reader.next();


        switch (vertebraeOfAnimal) {
            case "vertebrado":
                switch (typeOfAnimal) {
                    case "ave":
                        switch (eatOfAnimal) {
                            case "carnivoro":
                                System.out.println("aguia");
                                break;
                            case "onivoro":
                                System.out.println("pomba");
                                break;
                            default:
                                System.out.println("por favor insira carnivoro ou onivoro");
                        }
                        break;
                    case "mamifero":
                        switch (eatOfAnimal) {
                            case "onivoro":
                                System.out.println("homem");
                                break;
                            case "herbivoro":
                                System.out.println("vaca");
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
                switch (typeOfAnimal) {
                    case "inseto":
                        switch (eatOfAnimal) {
                            case "hematofago":
                                System.out.println("pulga");
                                break;
                            case "herbivoro":
                                System.out.println("lagarta");
                                break;
                            default:
                                System.out.println("por favor insira hematofago ou herbivoro");
                        }
                        break;
                    case "mamifero":
                        switch (eatOfAnimal) {
                            case "hematofago":
                                System.out.println("sanguessuga");
                                break;
                            case "onivoro":
                                System.out.println("minhoca");
                                break;
                            default:
                                System.out.println("por favor insira hematofago ou onivoro");
                        }
                        break;
                    default:
                        System.out.println("por favor mamifero ou inseto");
                }
                break;
            default:
                System.out.println("por favor insira vertebrado ou invertebrado");
        }
    }
}
