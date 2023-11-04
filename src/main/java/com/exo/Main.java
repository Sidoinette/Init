package com.exo;

import java.util.ArrayList;
import java.util.Scanner;

import com.exo.entities.Medecin;
import com.exo.entities.Patient;
import com.exo.entities.RendezVous;
import com.exo.repositories.core.DataBase;
import com.exo.repositories.core.Mysql;
import com.exo.repositories.db.MedecinRepository;
import com.exo.repositories.db.PatientRepository;
import com.exo.repositories.db.RendezVousRepository;
import com.exo.repositories.db.implemente.MedecinRepositoryImpl;
import com.exo.repositories.db.implemente.PatientRepositoryImpl;
import com.exo.repositories.db.implemente.RendezVousRepositoryImpl;
import com.exo.services.MedecinService;
import com.exo.services.MedecinServiceImpl;
import com.exo.services.PatientService;
import com.exo.services.PatientServiceImpl;
import com.exo.services.RendezVousService;
import com.exo.services.RendezVousServiceImpl;


public class Main {
    private static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) {
        DataBase dataBase= new Mysql();
        // 
        // yy-mm-dd
        // 
        MedecinRepository medRepository = new MedecinRepositoryImpl(dataBase);
        MedecinService medecinServiceImpl = new MedecinServiceImpl(medRepository);
        // 
        PatientRepository patientRepository = new PatientRepositoryImpl(dataBase);
        PatientService patientServiceImpl = new PatientServiceImpl(patientRepository);
        // 
        RendezVousRepository rendezVousRepository = new RendezVousRepositoryImpl(dataBase);
        RendezVousService rendezVousServiceImpl = new RendezVousServiceImpl(rendezVousRepository,medRepository,patientRepository);

       int choix;
       do {
            vide();
            System.out.println("=======================================");
            System.out.println("               ENTETE");
            System.out.println("=======================================");
            System.out.println("1-Créer un Patient");
            System.out.println("2-Créer un Medecin");
            System.out.println("3-Planifier un Rendez-vous");
            System.out.println("4-Afficher les Rendez-vous du jour");
            System.out.println("5-Afficher les Rendez-vous d'un medecin");
            System.out.println("6-Annuler un Rendez-vous");
            System.out.println("7-Quitter");
            choix=scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    vide();
                    System.out.println("=======================================");
                    System.out.println("               PATIENT");
                    System.out.println("=======================================");
                    // 
                    Patient pat = new Patient();
                    ArrayList<String> antecedent = new ArrayList<>();
                    System.out.println("Nom: ");
                    pat.setNom(scanner.nextLine());
                    System.out.println("Prenom: ");
                    pat.setPrenom(scanner.nextLine());
                    System.out.println("Tel: ");
                    pat.setTel(scanner.nextLine());
                    int rep;
                    // 
                    do {
                        System.out.println("ajouter un antécédant??[oui=>1 | non=>0]: ");
                        rep = scanner.nextInt();
                        scanner.nextLine();
                        if (rep!=0) {
                            System.out.println("Antecedent: ");
                            antecedent.add(scanner.nextLine());
                        }
                    } while (rep != 0);
                    // 
                    pat.setAntecedents(antecedent);
                    // 
                    patientServiceImpl.add(pat);
                    pause();
                    break;
                case 2:
                    int choixMenu;
                    do{
                        vide();
                        System.out.println("=======================================");
                        System.out.println("               MEDECIN");
                        System.out.println("=======================================");
                        System.out.println("1-AJOUTER");
                        System.out.println("2-LISTER");
                        System.out.println("3-QUITTER");
                        choixMenu=scanner.nextInt();
                        scanner.nextLine();
                        switch (choixMenu) {
                            case 1:
                                vide();
                                System.out.println("=======================================");
                                System.out.println("           AJOUT MEDECIN");
                                System.out.println("=======================================");
                                // 
                                Medecin med = new Medecin();
                                System.out.println("Nom: ");
                                med.setNom(scanner.nextLine());
                                System.out.println("Prenom: ");
                                med.setPrenom(scanner.nextLine());
                                System.out.println("Tel: ");
                                med.setTel(scanner.nextLine());
                                System.out.println("Specialite: ");
                                med.setSpecialite(scanner.nextLine());
                                med.setEtat("disponible");
                                // 
                                medecinServiceImpl.add(med);
                                pause();
                                break;
                            case 2:
                                vide();
                                System.out.println("=======================================");
                                System.out.println("           LISTE MEDECIN");
                                System.out.println("=======================================");
                                // programation fonctionnel
                                medecinServiceImpl.getAll().forEach(System.out::println);
                                pause();
                                break;
                            
                            default:
                                break;
                        }
                    }while(choixMenu!=3);
                    break;
            
                case 3:
                    vide();
                    System.out.println("=======================================");
                    System.out.println("               RENDEZ-VOUS");
                    System.out.println("=======================================");
                    // 
                    RendezVous rdv = new RendezVous();
                    String no=null;
                    // 
                    System.out.println("choisir un médecin");
                    Medecin med = medecinServiceImpl.show(scanner.nextInt());
                    scanner.nextLine();
                    if (med!=null) {
                        no="ok";
                    }else{
                        med = new Medecin();
                        System.out.println("Nom: ");
                        med.setNom(scanner.nextLine());
                        System.out.println("Prenom: ");
                        med.setPrenom(scanner.nextLine());
                        System.out.println("Tel: ");
                        med.setTel(scanner.nextLine());
                        System.out.println("Specialite: ");
                        med.setSpecialite(scanner.nextLine());
                        med.setEtat("indisponible");
                    }
                    // 
                    System.out.println("choisir un patient");
                    pat = patientServiceImpl.show(scanner.nextInt());
                    scanner.nextLine();
                    if (pat!=null) {
                       no="ok";
                    }else{
                        pat = new Patient();
                        ArrayList<String> ant = new ArrayList<>();
                        System.out.println("Nom: ");
                        pat.setNom(scanner.nextLine());
                        System.out.println("Prenom: ");
                        pat.setPrenom(scanner.nextLine());
                        System.out.println("Tel: ");
                        pat.setTel(scanner.nextLine());
                        pat.setEtat("indisponible");
                        // 
                        do {
                            System.out.println("ajouter un antécédant?[oui=>1 | non=>0]: ");
                            rep = scanner.nextInt();
                            scanner.nextLine();
                            if (rep!=0) {
                                System.out.println("Antecedent: ");
                                ant.add(scanner.nextLine());
                            }
                        } while (rep != 0);
                        pat.setAntecedents(ant);
                    }
                    // 
                    // FAIRE LE RENDEZ-VOUS
                    System.out.println("date[yyyy/mm/d]: ");
                    String date = scanner.nextLine();
                    System.out.println("heure:[h:min:00]: ");
                    String h =scanner.nextLine();
                    // 
                    if (rendezVousServiceImpl.show(date,h,med.getId()).size()!=0) {
                        System.out.println("le medecin n'est pas disponible !!!!");
                        no = null;
                    }
                    // 
                    if (med!=null & pat!=null & no!=null) {
                        rdv.setMed(med);
                        rdv.setPatient(pat);
                        rdv.setDate(date);
                        rdv.setHeure(h);
                        rdv.setEtat(0);
                        rendezVousServiceImpl.add(rdv);
                    }
                    pause();
                    break;
                case 4:
                    vide();
                    System.out.println("=======================================");
                    System.out.println("               RENDEZ-VOUS du JOUR");
                    System.out.println("=======================================");
                    pause();
                    break;
                default:
                    break;
            }
       } while (choix!=7);

    }

    public static void vide(){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause(){
		System.out.println("Appuyer sur une touche pour continuer...");
		scanner.nextLine();
	}
}