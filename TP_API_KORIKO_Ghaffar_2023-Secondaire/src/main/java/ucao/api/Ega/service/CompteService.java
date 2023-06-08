package ucao.api.Ega.service;

import ucao.api.Ega.entity.Compte;
import ucao.api.Ega.entity.Operation;

import java.util.List;

public interface CompteService {
    public List<Compte> showCompte();
    public Compte saveCompte(Compte compte);
    public Compte getOneCompte(Integer id);
    public void deleteCompte(Integer id);

    public void effectuerVersement(Integer compte_id, double montant);
    public void effectuerRetrait(Integer compte_id, double montant);
    public void effectuerVirement(Integer compteEmetteur_id, Integer compteBeneficiaire_id, double montant);
    public List<Compte> getComptesByClient(Integer client_id);
    public List<Operation> getDepotsByCompte(Integer compte_id);
    public List<Operation> getRetraitsByCompte(Integer compte_id);
}
