import ABSTRACT_FACTORY.*;
import BRIDGE.*;
import BUILDER.*;
import COMPOSITE.ClientComposite;
import COMPOSITE.Personne;
import COMPOSITE.Societe;
import DECORATOR_OBSERVER.CatalogueVehicule;
import FACTORY_METHOD.Commande;
import FACTORY_METHOD.CommandeComptantFactory;
import FACTORY_METHOD.CommandeCreditFactory;
import ITERATOR.Catalogue;
import ITERATOR.IterableCollection;
import ITERATOR.Iterator;
import TEMPLATE_METHOD.CommandeCIV;
import TEMPLATE_METHOD.CommandeCameroon;
import TEMPLATE_METHOD.CommandeT;

import java.util.*;

public class Client {

    /**
     * Programme principal
     *
     * @param args
     */
    public static void main(String[] args) {
        // variables ------------------------------------------------------------------

        // pour les inputs
        Scanner scanner = new Scanner(System.in);
        // liste des vehicules du systeme
        IterableCollection catalogue = new Catalogue();

        // liste des clients
        List<ClientComposite> clients = new ArrayList<>();

        // liste des vehicules du catalogue en utilisant Observer & Decorator
        CatalogueVehicule catalogueVehicule = new CatalogueVehicule();

        // liste des commandes du systeme
        ArrayList<Commande> commandes = new ArrayList<>();

        System.out.println("---------------- CATALOGUEDE VENTE DE VEHICULE ----------------\n");
        System.out.println("---------------- QUELQUES DONNEES DE TEST ----------------");

        // donnees clients
        // ----------------------------------------------------------------

        // personnes
        ClientComposite p1 = new Personne("N1", "Ali", 10, "M");
        ClientComposite p2 = new Personne("N2", "Baba", 10, "M");
        ClientComposite p3 = new Personne("N3", "Bobo", 10, "M");
        ClientComposite p4 = new Personne("N4", "Bibi", 10, "F");
        ClientComposite p5 = new Personne("N5", "Bil", 10, "F");

        // societe
        ClientComposite s1 = new Societe("S1", "Societe 1", "Yaounde");
        s1.add(p1);
        s1.add(p2);
        s1.add(p3);

        clients.add(p1);
        clients.add(p2);
        clients.add(p3);
        clients.add(p4);
        clients.add(p5);

        clients.add(s1);

        int choix;
        do {
            System.out.println("\n---------------- APPLICATION ----------------\n");

            // Affichage du menu
            System.out.println("1. Ajouter des véhicules au catalogue");
            System.out.println("2. Rechercher un vehicule dans le catalogue");
            System.out.println("3. Afficher les vehicules du catalogue");
            // System.out.println("4. Afficher séquentielle les vehicules du catalogue");
            System.out.println("5. Passer une commande");
            System.out.println("6. Ajouter un client");
            System.out.println("7. Afficher les clients");
            System.out.println("8. Implanter les formulaires HTML");
            System.out.println("9. Quitter \n");

            // saisie du choix
            System.out.print("Votre choix: ");

            // Vérification de la validité de la saisie
            while (!scanner.hasNextInt()) {
                System.out.println("Saisie invalide !");
                System.out.print("Votre choix: ");
                scanner.next(); // Consomme la mauvaise saisie
            }

            // Lecture du choix
            choix = scanner.nextInt();

            // Traitement du choix
            switch (choix) {
                case 1:
                    construireObject(catalogueVehicule, catalogue);
                    // Traiter l'option 1
                    break;
                case 2:
                    rechercherVehicule(catalogue);
                    break;
                case 3:
                    afficherVehicule(catalogueVehicule);
                    break;
                // case 4:
                // listeVehicules(catalogue);
                // // Traiter l'option 3
                // break;
                case 5:
                    passerCommande(catalogue);
                    break;
                case 6:
                    ajouterClient(clients);
                    break;
                case 7:
                    afficherClient(clients);
                    break;
                case 8:
                    implanterFormulaire();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        } while (choix != 9);

        scanner.close();

    }

    // --------------------- Méthodes de traitement des options --------------------

    /**
     * Construire les objets du domaine (automobile à
     * essence ou électrique, scooter à essence ou
     * électrique, etc.)
     *
     * @param vehiculeList
     */
    public static void construireObject(CatalogueVehicule catalogueVehicule, IterableCollection vehiculeList) {
        // variables d'execution
        Scanner scanner = new Scanner(System.in);

        Automobile automobileElectrique = null;
        Scooter scooterElectrique = null;

        // fabriques
        IFabriqueVehicule fabriqueEssence = new FabriqueVehiculeEssence();
        IFabriqueVehicule fabriqueElectrique = new FabriqueVehiculeElectrique();

        System.out.println(
                "\n=================== Construction des objets du domaine (Patron Abstract Factory) ===================\n");

        int choix;
        do {

            // Affichage du menu
            System.out.println("Selectioonner la famille du véhicule à ajouter\n");
            System.out.println("1. Véhicule à éssence");
            System.out.println("2. Véhicule électrique");
            System.out.println("3. Quitter\n");

            // saisie du choix
            System.out.print("Votre choix: ");

            // Vérification de la validité de la saisie
            while (!scanner.hasNextInt()) {
                System.out.println("Saisie invalide !");
                System.out.print("Votre choix: ");
                scanner.next(); // Consomme la mauvaise saisie
            }

            // Lecture du choix
            choix = scanner.nextInt();

            // Traitement du choix
            switch (choix) {
                case 1:
                    System.out
                            .println("\n----------- Utilisation de la fabrique  de véhicules à essence -----------\n");
                    System.out.println("1. Automobile");
                    System.out.println("2. Scooter");

                    System.out.print("Votre choix: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Saisie invalide !\n");
                        scanner.next(); // Consomme la mauvaise saisie
                    } else {
                        int c = scanner.nextInt();

                        System.out.print("Numéro d'Immatriculation: ");
                        String numIm = scanner.next();

                        System.out.print("Nom: ");
                        String nom = scanner.next();

                        System.out.print("Couleur: ");
                        String couleur = scanner.next();

                        System.out.print("Marque: ");
                        String marque = scanner.next();

                        System.out.print("Siege: ");
                        String siege = scanner.next();

                        System.out.print("Prix: ");
                        double prix = scanner.nextDouble();
                        System.out.print("\n");

                        switch (c) {
                            case 1:
                                Automobile automobileEssence = fabriqueEssence.creerAutomobile(numIm, nom, couleur,
                                        marque, siege, prix);
                                /* Ajout a la liste sequentielle */
                                vehiculeList.addVehicule(automobileEssence);

                                /* Ajout au catalogue */
                                catalogueVehicule.addVehicule(automobileEssence);
                                System.out.println("Automobile ajoutée au catalogue avec succès.\n");
                                break;

                            case 2:

                                Scooter scooterEssence = fabriqueEssence.creerScooter(numIm, nom, couleur,
                                        marque, siege, prix);

                                vehiculeList.addVehicule(scooterEssence);
                                catalogueVehicule.addVehicule(scooterEssence);

                                System.out.println("Scooter ajoutée au catalogue avec succès.\n");
                                break;

                            default:
                                break;
                        }
                    }

                    break;
                case 2:
                    System.out
                            .println("\n----------- Utilisation de la fabrique  de véhicules electrique -----------\n");
                    System.out.println("1. Automobile");
                    System.out.println("2. Scooter");

                    System.out.print("Votre choix: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Saisie invalide !\n");
                        scanner.next(); // Consomme la mauvaise saisie
                    } else {
                        int c = scanner.nextInt();

                        System.out.print("Numéro d'Immatriculation: ");
                        String numIm = scanner.next();

                        System.out.print("Nom: ");
                        String nom = scanner.next();

                        System.out.print("Couleur: ");
                        String couleur = scanner.next();

                        System.out.print("Marque: ");
                        String marque = scanner.next();

                        System.out.print("Siege: ");
                        String siege = scanner.next();

                        System.out.print("Prix: ");
                        double prix = scanner.nextDouble();
                        System.out.print("\n");

                        switch (c) {
                            case 1:
                                Automobile automobileElectrique1 = fabriqueElectrique.creerAutomobile(numIm, nom,
                                        couleur,
                                        marque, siege, prix);

                                vehiculeList.addVehicule(automobileElectrique1);
                                catalogueVehicule.addVehicule(automobileElectrique1);

                                System.out.println("Automobile ajoutée au catalogue avec succès.\n");
                                break;

                            case 2:
                                Scooter scooterElectrique1 = fabriqueElectrique.creerScooter(numIm, nom, couleur,
                                        marque, siege, prix);

                                vehiculeList.addVehicule(scooterElectrique1);

                                catalogueVehicule.addVehicule(scooterElectrique1);

                                System.out.println("Scooter ajoutée au catalogue avec succès. \n");
                                break;

                            default:
                                break;
                        }
                    }

                    break;
                case 3:
                    // Sortie de la fonction
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 3);
    }

    /**
     *
     * @param catalogue
     */
    public static void passerCommande(IterableCollection catalogue) {
        // variables d'execution
        Scanner scanner = new Scanner(System.in);

        CommandeComptantFactory commandeComptantFactory = new CommandeComptantFactory();
        CommandeCreditFactory commandeCreditFactory = new CommandeCreditFactory();
        Commande commande = null;
        double montantTtc = 0;
        Vehicule vehiculeForCommande = null;
        List<Document> documents = new ArrayList<>();
        MonteurAbstrait monteurLiasse = new MonteurLiasse();
        Directeur directeur = new Directeur(monteurLiasse);

        System.out.println(
                "\n=================== Initialisation de la liasse vide (SINGLETON) ===================\n");
        Liasse emptyLiasse = Liasse.getInstanceLiasse("Liasse " + new Random(5).nextInt());

        System.out.println(
                "\n=================== Création de la commande (Factory Method) ===================\n");

        int choix;
        do {
            // Affichage du menu
            System.out.println("Quelle type de commande voulez-vous effectuer ? \n");
            System.out.println("1. Commande au comptant");
            System.out.println("2. Commande à crédit");
            System.out.println("3. Quitter\n");

            // saisie du choix
            System.out.print("Votre choix: ");

            // Vérification de la validité de la saisie
            while (!scanner.hasNextInt()) {
                System.out.println("Saisie invalide !");
                System.out.print("Votre choix: ");
                scanner.next(); // Consomme la mauvaise saisie
            }

            // Lecture du choix
            choix = scanner.nextInt();

            /*------------ Traitement apres le choix -----------*/
            // Traitement du choix
            switch (choix) {
                case 1:
                    System.out.println("Bien vouloir fournir les documents suivants :  \n");
                    System.out.println("Demande d'immatriculation \n");

                    System.out.print("Nom : ");
                    String nomDemandeIm = scanner.next();

                    System.out.print("Chemin d'acces : ");
                    String pathDemandeIm = scanner.next();

                    System.out.print("Taille : ");
                    float sizeDemandeIm = scanner.nextFloat();

                    System.out.println("Certificat de session \n");
                    System.out.print("Nom : ");
                    String nomCs = scanner.next();

                    System.out.print("Chemin d'acces : ");
                    String pathCs = scanner.next();

                    System.out.print("Taille : ");
                    float sizeCs = scanner.nextFloat();

                    System.out.println("Bon de commande \n");
                    System.out.print("Nom : ");
                    String nomBc = scanner.next();

                    System.out.print("Chemin d'acces : ");
                    String pathBc = scanner.next();

                    System.out.print("Taille : ");
                    float sizeBc = scanner.nextFloat();

                    System.out.println("***** Creation de la liasse de document *****");
                    /*
                     * ----------- documents a insérer dans la liasse fournits par le client
                     * ---------------
                     */
                    Document demandeIm = new Document(nomDemandeIm, pathDemandeIm, sizeDemandeIm);
                    Document certificat = new Document(nomCs, pathCs, sizeCs);
                    Document bonCmd = new Document(nomBc, pathBc, sizeBc);
                    documents.add(demandeIm);
                    documents.add(certificat);
                    documents.add(bonCmd);

                    /* ----------- construction de la liasse -------------- */
                    directeur.construire(emptyLiasse, demandeIm, certificat, bonCmd);

                    System.out.print("\n Numero d'immatriculation du vehicule choisi : ");
                    String numImV = scanner.next();

                    Iterator iterator = catalogue.createIterator();
                    while (iterator.hasNext()) {
                        Vehicule vehicule = (Vehicule) iterator.next();
                        if (Objects.equals(vehicule.getNumImmatriculation(), numImV)) {
                            vehiculeForCommande = vehicule;
                        }
                    }
                    System.out.println(
                            "============= Calcul du montant de la commande en fonction du pays de livraison (TEMPLATE METHOD) ======================  : \n");
                    if (vehiculeForCommande != null) {

                        System.out.println("\n Choisir votre pays de résidence  : \n");

                        System.out.println("1. Cameroun");
                        System.out.println("2. Cote d'Ivoir");

                        System.out.print("Votre choix: ");
                        CommandeT cmdCamer = null;
                        double montantTva = 0;
                        if (!scanner.hasNextInt()) {
                            System.out.println("Saisie invalide !\n");
                            scanner.next(); // Consomme la mauvaise saisie
                        } else {
                            int c = scanner.nextInt();
                            switch (c) {
                                case 1 -> {
                                    cmdCamer = new CommandeCameroon(vehiculeForCommande.getPrice());
                                    cmdCamer.calculMontantTtc();
                                    montantTtc = cmdCamer.getMontantTtc();
                                    montantTva = cmdCamer.getMontantTva();
                                }
                                case 2 -> {
                                    CommandeT cmdCiv = new CommandeCIV(vehiculeForCommande.getPrice());
                                    cmdCiv.calculMontantTtc();
                                    montantTtc = cmdCiv.getMontantTtc();
                                    montantTva = cmdCiv.getMontantTva();
                                }
                            }
                        }
                        commande = commandeComptantFactory.creerCommande("Commande", vehiculeForCommande, "En cours");

                        System.out.println("\n Récapitulatif de la commande  : \n");
                        System.out.println("Numero de la commande  : " + commande.getCmdNumber());
                        System.out.println("Etat  : " + commande.getState());
                        System.out.println("Vehicule  : " + vehiculeForCommande.getName());
                        System.out.println("Montant Tva  : " + montantTva);
                        System.out.println("Montant tout taxe compris à payer  : " + montantTtc + "\n");
                    } else {
                        System.out.println("Aucun vehicule trouve.");
                    }
                    break;
                case 2:
                    System.out.println("\n Bien vouloir fournir les documents suivants :  \n");
                    System.out.println("Demande d'immatriculation \n");

                    System.out.print("Nom : ");
                    String nomDemandeIm2 = scanner.next();

                    System.out.print("Chemin d'acces : ");
                    String pathDemandeIm2 = scanner.next();

                    System.out.print("Taille : ");
                    float sizeDemandeIm2 = scanner.nextFloat();

                    System.out.println("Certificat de session \n");
                    System.out.print("Nom : ");
                    String nomCs2 = scanner.next();

                    System.out.print("Chemin d'acces : ");
                    String pathCs2 = scanner.next();

                    System.out.print("Taille : ");
                    float sizeCs2 = scanner.nextFloat();

                    System.out.println("Bon de commande \n");
                    System.out.print("Nom : ");
                    String nomBc2 = scanner.next();

                    System.out.print("Chemin d'acces : ");
                    String pathBc2 = scanner.next();

                    System.out.print("Taille : ");
                    float sizeBc2 = scanner.nextFloat();

                    System.out.println("***** Creation de la liasse de document *****");
                    /*
                     * ----------- documents a insérer dans la liasse fournits par le client
                     * ---------------
                     */
                    Document demandeIm2 = new Document(nomDemandeIm2, pathDemandeIm2, sizeDemandeIm2);
                    Document certificat2 = new Document(nomCs2, pathCs2, sizeCs2);
                    Document bonCmd2 = new Document(nomBc2, pathBc2, sizeBc2);
                    documents.add(demandeIm2);
                    documents.add(certificat2);
                    documents.add(bonCmd2);

                    /* ----------- construction de la liasse -------------- */
                    directeur.construire(emptyLiasse, demandeIm2, certificat2, bonCmd2);

                    System.out.print("\n Numero d'immatriculation du vehicule choisi : ");
                    String numImV2 = scanner.next();

                    Iterator iterator2 = catalogue.createIterator();
                    while (iterator2.hasNext()) {
                        Vehicule vehicule = (Vehicule) iterator2.next();
                        if (Objects.equals(vehicule.getNumImmatriculation(), numImV2)) {
                            vehiculeForCommande = vehicule;
                        }
                    }
                    double montantTva = 0;

                    if (vehiculeForCommande != null) {

                        System.out.println("\n Choisir votre pays de résidence : \n");

                        System.out.println("1. Cameroun");
                        System.out.println("2. Cote d'Ivoir");

                        System.out.print("Votre choix: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Saisie invalide !\n");
                            scanner.next(); // Consomme la mauvaise saisie
                        } else {
                            int c = scanner.nextInt();

                            switch (c) {
                                case 1 -> {
                                    CommandeT cmdCamer = new CommandeCameroon(vehiculeForCommande.getPrice());
                                    cmdCamer.calculMontantTtc();
                                    montantTtc = cmdCamer.getMontantTtc();
                                    montantTva = cmdCamer.getMontantTva();
                                }
                                case 2 -> {
                                    CommandeT cmdCiv = new CommandeCIV(vehiculeForCommande.getPrice());
                                    cmdCiv.calculMontantTtc();
                                    montantTva = cmdCiv.getMontantTva();
                                    montantTtc = cmdCiv.getMontantTtc();
                                }
                            }
                        }
                        commande = commandeCreditFactory.creerCommande("Commande", vehiculeForCommande, "En cours");

                        System.out.println("\n Récapitulatif de la commande  : \n");
                        System.out.println("Numero de la commande  : " + commande.getCmdNumber());
                        System.out.println("Etat  : " + commande.getState());
                        System.out.println("Vehicule  : " + vehiculeForCommande.getName());
                        System.out.println("Montant TVA  : " + montantTva);
                        System.out.println("Montant tout taxe compris à payer  : " + montantTtc);
                        System.out.println("Date de rembourcement  : " + commande.getDateRembourssement() + "\n");
                    } else {
                        System.out.println("Aucun vehicule trouve.");
                    }
                case 3:
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 3);
    }

    /**
     * Retrouver séquentiellement les véhicules du
     * catalogue
     *
     * @param catalogue
     * @return
     */
    public static void rechercherVehicule(IterableCollection catalogue) {

        // resultat de la recherche
        ArrayList<Vehicule> resultat = new ArrayList<>();

        // variables d'execution
        Scanner scanner = new Scanner(System.in);

        // Iterateur
        Iterator iterator = catalogue.createIterator();

        System.out.println(
                "\n=================== Retrouver séquentiellement les véhicules du catalogue (Patron Iterator) ===================\n");

        System.out.println("Filtres: ");

        System.out.print("Marque: ");
        String marque = scanner.next();

        System.out.print("Couleur: ");
        String couleur = scanner.next();

        System.out.print("Siege: ");
        String siege = scanner.next();
        System.out.print("\n");

        // System.out.println("marque: " + marque);
        // System.out.println("couleur: " + couleur);
        // System.out.println("siege: " + siege);

        if (marque.trim() != "" && couleur.trim() != "" && siege.trim() != "") {
            while (iterator.hasNext()) {
                Vehicule vehicule = (Vehicule) iterator.next();
                if (vehicule.getMarque().compareToIgnoreCase(marque) == 0
                        && vehicule.getColor().compareToIgnoreCase(couleur) == 0
                        && vehicule.getSeat().compareToIgnoreCase(siege) == 0) {
                    resultat.add(vehicule);
                }
            }

            System.out.println("Resultat de la recherche: \n");
            if (resultat.isEmpty()) {
                System.out.println("Aucun véhicule dans le système \n");
            } else {
                for (int x = 0; x < resultat.size(); x++) {
                    Vehicule v = resultat.get(x);
                    System.out.println("Nom du véhicule trouvé ==> " + v.getName() + "\n");
                }
            }
        } else {
            System.out.println("Formulaire invalide !.");
        }
    }

    /**
     * afficher les clients
     * 
     * @param clients
     */
    public static void afficherClient(List<ClientComposite> clients) {
        // Parcours de la collection à l'aide de l'itérateur
        if (clients.isEmpty()) {
            System.out.print("Aucun client dans le système. \n");
            return;
        }
        for (ClientComposite client : clients) {
            // System.out.println(" ==> Numéro de CNI : " + client.getCNI() + "Nom : " +
            // client.getName());
            client.afficher();
        }
    }

    /**
     *
     * @param vehicules
     */
    public static void listeVehicules(IterableCollection vehicules) {
        Iterator iterator = vehicules.createIterator();

        // Parcours de la collection à l'aide de l'itérateur
        if (!iterator.hasNext()) {
            System.out.print("Aucun vehicule dans le catalogue. \n");
            return;
        }
        while (iterator.hasNext()) {
            Vehicule vehicule = (Vehicule) iterator.next();
            System.out.println(" ==> Numéro d'immatriculation : " + vehicule.getNumImmatriculation()
                    + "Nom du vehicule : " + vehicule.getName() + ", Marque : " + vehicule.getMarque() + ", Couleur : "
                    + vehicule.getColor() + ", Prix " + vehicule.getPrice());
        }
    }

    /**
     * Affichage de la liste des vehicules du catalogue avec Observer & Decorator
     * 
     * @param catalogueVehicule
     */
    public static void afficherVehicule(CatalogueVehicule catalogueVehicule) {

        // Parcours du catalogue
        if (catalogueVehicule == null) {
            System.out.print("Aucun vehicule dans le catalogue. \n");
            return;
        }
        catalogueVehicule.getCatalogue();
    }

    public static void ajouterClient(List<ClientComposite> clients) {
        ClientComposite client = null;
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("\n----------- Ajouter un client (PATRON COMPOSITE) -----------\n");
            System.out.println("1. Particulier");
            System.out.println("2. Société");
            System.out.println("3. Quitter");

            System.out.print("Votre choix: ");

            // Vérification de la validité de la saisie
            while (!scanner.hasNextInt()) {
                System.out.println("Saisie invalide !");
                System.out.print("Votre choix: ");
                scanner.next(); // Consomme la mauvaise saisie
            }

            // Lecture du choix
            choix = scanner.nextInt();

            // Traitement du choix
            switch (choix) {
                case 1:

                    System.out.print("Entrez le numero de cni du client : ");
                    String numCni = scanner.next();

                    System.out.print("Entrez le nom du client : ");
                    String nomCLient = scanner.next();

                    System.out.print("Entrez l'age de cni du client : ");
                    int age = scanner.nextInt();

                    System.out.print("Entrez le sexe de cni du client : ");
                    String sexeC = scanner.next();

                    /**** creation du client a base du patron composite ****/
                    client = new Personne(numCni, nomCLient, age, sexeC);
                    clients.add(client);
                    client.afficher();
                    break;
                case 2:
                    System.out.print("Entrez le NUI : ");
                    String nui = scanner.next();

                    System.out.print("Entrez le nom de la societe : ");
                    String nomS = scanner.next();

                    System.out.print("Entrez la localisation : ");
                    String localisation = scanner.next();

                    /**** creation du client a base du patron composite ****/
                    client = new Societe(nui, nomS, localisation);
                    clients.add(client);
                    client.afficher();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 3);
    }

    /**
     * Implanter des formulaires HTML ou à l’aide de
     * widgets
     *
     */
    public static void implanterFormulaire() {

        // liste des widgets
        ArrayList<Widget> widgets = new ArrayList<>();

        // variables d'execution
        Scanner scanner = new Scanner(System.in);
        Scanner scannerC1 = new Scanner(System.in);

        System.out.println(
                "\n=================== Implanter des formulaires HTML ou à l’aide de widgets (Patron Bridge) ===================\n");

        int c;

        do {

            // Affichage du menu
            System.out.println("1. Creation des widgets");
            System.out.println("2. Implanter");
            System.out.println("3. Quitter\n");

            // saisie du choix
            System.out.print("Votre choix: ");

            // Vérification de la validité de la saisie
            while (!scanner.hasNextInt()) {
                System.out.println("Saisie invalide !");
                System.out.print("Votre choix: ");
                scannerC1.next(); // Consomme la mauvaise saisie
            }

            // Lecture du choix
            c = scanner.nextInt();

            // traitement du choix
            switch (c) {
                case 1 -> {
                    int choix;
                    do {
                        System.out.println("Creation des widgets ------------------------\n");

                        // Affichage du menu
                        System.out.println("Selectioonner le widget à ajouter\n");
                        System.out.println("1. Input Text");
                        System.out.println("2. Input Select");
                        System.out.println("3. Input Radio");
                        System.out.println("4. Input Checkbox");
                        System.out.println("5. Input Button");
                        System.out.println("6. Quitter\n");

                        // saisie du choix
                        System.out.print("Votre choix: ");

                        // Vérification de la validité de la saisie
                        while (!scanner.hasNextInt()) {
                            System.out.println("Saisie invalide !");
                            System.out.print("Votre choix: ");
                            scanner.next(); // Consomme la mauvaise saisie
                        }

                        // Lecture du choix
                        choix = scanner.nextInt();

                        // label
                        String label;

                        // traitement du choix
                        switch (choix) {
                            case 1:

                                System.out.print("Label: ");
                                label = scanner.next();
                                System.out.print("\n");

                                Widget inputText = new InputText(label);
                                widgets.add(inputText);
                                System.out.println("Widget ajouté\n");
                                break;

                            case 2:

                                System.out.print("Label: ");
                                label = scanner.next();
                                System.out.print("\n");

                                Widget inputSelect = new InputSelect(label);
                                widgets.add(inputSelect);
                                System.out.println("Widget ajouté\n");
                                break;

                            case 3:

                                System.out.print("Label: ");
                                label = scanner.next();
                                System.out.print("\n");

                                Widget inputRadio = new InputRadio(label);
                                widgets.add(inputRadio);
                                System.out.println("Widget ajouté\n");
                                break;

                            case 4:

                                System.out.print("Label: ");
                                label = scanner.next();
                                System.out.print("\n");

                                Widget inputCheckbox = new InputCheckbox(label);
                                widgets.add(inputCheckbox);
                                System.out.println("Widget ajouté\n");
                                break;

                            case 5:

                                System.out.print("Label: ");
                                label = scanner.next();
                                System.out.print("\n");

                                Widget inputButton = new InputButton(label);
                                widgets.add(inputButton);
                                System.out.println("Widget ajouté\n");
                                break;

                            case 6:

                                System.out.println("Quitter\n");
                                break;

                            default:
                                System.out.println("Choix invalide !\n");
                                break;
                        }

                    } while (choix != 6);
                }
                case 2 -> {
                    System.out.println("Implanter le formulaire HTML ------------------------\n");
                    if (widgets.isEmpty()) {
                        System.out.println("Aucun widget n'a été crée.\n");
                    } else {
                        FormulaireHtml formulaire = new FormulaireHtml(widgets);
                        formulaire.implanter();

                    }
                }
                case 3 -> {
                }
                default -> System.out.println("Choix invalide !\n");
            }

        } while (c != 3);

        // scanner.close();

    }
}