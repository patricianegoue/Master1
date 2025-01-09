package COMPOSITE;

public interface ClientComposite {
     String getName();
     void afficher();
    String getCNI();
    String getNUI();
     void add(ClientComposite client);
     void remove(ClientComposite client);
     int count();
     String getClient(int index);
}
