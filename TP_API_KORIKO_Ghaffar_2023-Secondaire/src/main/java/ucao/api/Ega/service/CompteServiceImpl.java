package ucao.api.Ega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucao.api.Ega.entity.Compte;
import ucao.api.Ega.entity.Operation;
import ucao.api.Ega.entity.OperationType;
import ucao.api.Ega.repository.CompteRepository;
import ucao.api.Ega.repository.OperationRepository;

import java.util.List;
@Service
public class CompteServiceImpl implements CompteService{
    @Autowired
    private CompteRepository compteRepository;
    private OperationRepository operationRepository;
    @Override
    public List<Compte> showCompte() {
        return compteRepository.findAll();
    }

    @Override
    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public Compte getOneCompte(Integer id) {
        return compteRepository.findById(id).get();
    }

    @Override
    public void deleteCompte(Integer id) {
        compteRepository.deleteById(id);
    }

    @Override
    public void effectuerVersement(Integer compte_id, double montant) {
        Compte compte = getOneCompte(compte_id);
        double nouveauSolde = compte.getSolde() + montant;
        compte.setSolde(nouveauSolde);
        saveCompte(compte);
    }

    @Override
    public void effectuerRetrait(Integer compte_id, double montant) {
        Compte compte = getOneCompte(compte_id);
        double nouveauSolde = compte.getSolde() - montant;
        if (nouveauSolde >= 0) {
            compte.setSolde(nouveauSolde);
            saveCompte(compte);
        } else {
            throw new IllegalArgumentException("Solde insuffisant pour effectuer le retrait.");
        }
    }

    @Override
    public void effectuerVirement(Integer compteEmetteur_id, Integer compteBeneficiaire_id, double montant) {
        Compte compteEmetteur = getOneCompte(compteEmetteur_id);
        Compte compteBeneficiaire = getOneCompte(compteBeneficiaire_id);

        double nouveauSoldeEmetteur = compteEmetteur.getSolde() - montant;
        if (nouveauSoldeEmetteur >= 0) {
            double nouveauSoldeBeneficiaire = compteBeneficiaire.getSolde() + montant;

            compteEmetteur.setSolde(nouveauSoldeEmetteur);
            compteBeneficiaire.setSolde(nouveauSoldeBeneficiaire);

            saveCompte(compteEmetteur);
            saveCompte(compteBeneficiaire);
        } else {
            throw new IllegalArgumentException("Solde insuffisant pour effectuer le virement.");
        }
    }

    @Override
    public List<Compte> getComptesByClient(Integer client_id) {
        return compteRepository.findByClientId(client_id);
    }

    @Override
    public List<Operation> getDepotsByCompte(Integer compte_id) {
        return operationRepository.findByCompteIdAndType(compte_id, OperationType.DEPOSIT);
    }

    @Override
    public List<Operation> getRetraitsByCompte(Integer compte_id) {
        return operationRepository.findByCompteIdAndType(compte_id, OperationType.WITHDRAWAL);
    }
}
