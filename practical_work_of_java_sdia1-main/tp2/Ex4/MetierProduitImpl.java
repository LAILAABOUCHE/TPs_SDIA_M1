package Ex4;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetierProduit{
    private List<Produit> produits = new ArrayList<>();
    @Override
    public Produit add(Produit p) {
        this.produits.add(p);
        return p;
    }

    @Override
    public List<Produit> getAll() {
        return this.produits;
    }

    @Override
    public List<Produit> findByNom(String motCle) {
        List<Produit> returnedList = new ArrayList<>();
        for(Produit p:produits) {
            if(p.getNom().equals(motCle)) {
                returnedList.add(p);
            }
        }
        return returnedList;
    }

    @Override
    public Produit findById(long id) {
        for(Produit p: produits) {
            if(p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Produit p = findById(id);
        produits.remove(p);
    }
}
