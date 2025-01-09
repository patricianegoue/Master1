package COMPOSITE;

import java.util.ArrayList;
import java.util.List;

public class Societe implements ClientComposite {
    private String name;
    private String localisation;
    private List<ClientComposite> clients;
    private String NUI;

    public Societe(String NUI, String name, String localisation) {
        this.NUI = NUI;
        this.name = name;
        this.localisation = localisation;
        this.clients = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void afficher() {

        System.out.println("Nom de la societe : " + name + " et de localisation : " + localisation);
        if (clients.isEmpty()) {
            System.out.println("Societe vide ! \n");
        }
        // } else {
        if (!clients.isEmpty()) {
            System.out.println("----- Filliales -------\n");
            for (ClientComposite client : clients) {
                client.afficher();
            }
        }

        // }
    }

    @Override
    public String getCNI() {
        return null;
    }

    @Override
    public String getNUI() {
        return NUI;
    }

    @Override
    public void add(ClientComposite client) {
        this.clients.add(client);
    }

    @Override
    public void remove(ClientComposite client) {
        this.clients.remove(client);
    }

    @Override
    public int count() {
        return this.clients.size();
    }

    @Override
    public String getClient(int index) {
        return this.clients.get(index).getName();
    }
}
