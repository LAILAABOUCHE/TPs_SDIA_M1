package Ex3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {
    private String reference;
    private Date dateCommande;
    private Client client;
    private boolean etatCommande;

    public Commande(String reference, Date dateCommande, Client client, boolean etatCommande) {
        this.reference = reference;
        this.dateCommande = dateCommande;
        this.client = client;
        this.etatCommande = etatCommande;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(boolean etatCommande) {
        this.etatCommande = etatCommande;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "reference='" + reference + '\'' +
                ", dateCommande=" + dateCommande +
                ", client=" + client +
                ", etatCommande=" + etatCommande +
                '}';
    }
}
