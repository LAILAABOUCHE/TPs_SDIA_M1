package org.example.EX3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class MetierClientImpl implements IMetier<Client>{
    private List<Client> clients;
    private File file;

    public MetierClientImpl() {}

    public MetierClientImpl(List<Client> clients, File file) {
        this.clients = clients;
        this.file = file;
    }

    @Override
    public Client add(Client o) {
        clients.add(o);
        return o;
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        for(Client c: clients) {
            if(c.getFirstName().equals(nom)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void delete(String nom) {
        getAll().removeIf(p -> p.getFirstName().equals(nom));
    }

    @Override
    public void saveAll() {
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(file, false);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(clients);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
